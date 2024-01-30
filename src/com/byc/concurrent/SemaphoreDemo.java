package com.byc.concurrent;

import java.util.concurrent.*;

public class SemaphoreDemo {

    public static void main(String[] args) {
        // 创建一个具有固定线程数量的线程池对象（如果这里线程池的线程数量给太少的话你会发现执行的很慢）
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(100, 200,
                10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1000));
        // 初始许可证数量
        Semaphore semaphore = new Semaphore(20);
        for (int i = 0; i < 200; i++) {
            int threadNum = i;
            threadPoolExecutor.execute(() -> {
                try {
                    semaphore.acquire(); // 获取一个许可，所以可运行线程数量为20/1=20
                    test(threadNum);
                    semaphore.release(); // 释放一个许可
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        threadPoolExecutor.shutdown();
        System.out.println("结束");
    }

    public static void test(int threadnum) throws InterruptedException {
        Thread.sleep(1000);// 模拟请求的耗时操作
        System.out.println("threadnum:" + threadnum);
        Thread.sleep(1000);// 模拟请求的耗时操作
    }
}
