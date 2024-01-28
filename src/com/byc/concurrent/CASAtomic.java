package com.byc.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.atomic.LongAdder;


public class CASAtomic {

    private static AtomicInteger counter = new AtomicInteger(0);

    // AtomicStampedReference解决CAS的ABA问题
    private static AtomicStampedReference<String> atomicStampedRef = new AtomicStampedReference<>("init", 0);


    public static void main(String[] args) {
        Thread t1 = new Thread(new CounterIncrementer(), "t1");
        Thread t2 = new Thread(new CounterIncrementer(), "t2");
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(counter);



        int initStamp = atomicStampedRef.getStamp();
        String initValue = atomicStampedRef.getReference();
        System.out.println("Init value: " + initValue + "," + initStamp);

        Thread t3 = new Thread(() -> {
            int stamp = atomicStampedRef.getStamp();
            String value = atomicStampedRef.getReference();
            atomicStampedRef.compareAndSet(value, "new val", stamp, stamp + 1);
            System.out.println("Updated value: " + atomicStampedRef.getReference() + ", " + atomicStampedRef.getStamp());
        });
        Thread t4 = new Thread(() -> {
            int stamp = atomicStampedRef.getStamp();
            String value = atomicStampedRef.getReference();
            atomicStampedRef.compareAndSet(value, "another new val", stamp, stamp + 1);
            System.out.println("Another Updated value: " + atomicStampedRef.getReference() + ", " + atomicStampedRef.getStamp());
        });
        t3.start();
        t4.start();
        // 等待线程执行完成
        try {
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        LongAdder counter = new LongAdder();
        // 创建一个固定大小的线程池
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // 向线程池提交任务
        for (int i = 0; i < 1000; i++) {
            executor.submit(() -> {
                // 对 LongAdder 进行累加操作
                counter.increment();
            });
        }

        // 关闭线程池
        executor.shutdown();

        // 等待所有任务执行完成
        while (!executor.isTerminated()) {
            // do nothing
        }

        // 输出累加结果
        System.out.println("Final result: " + counter.sum());
    }

    static class CounterIncrementer implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                counter.incrementAndGet();
            }
        }
    }
}
