package com.byc.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(100);
        CountDownLatch countDownLatch = new CountDownLatch(500);

        for (int i = 0; i < 500; i++) {
            final int threadNum = i;
            threadPool.execute(() -> {
                try{
                    test(threadNum);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        threadPool.shutdown();
        System.out.println("结束");
    }

    public static void test(int threadnum) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("threadNum:" + threadnum);
        Thread.sleep(1000);
    }
}
