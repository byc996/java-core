package com.byc.interview;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;


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
