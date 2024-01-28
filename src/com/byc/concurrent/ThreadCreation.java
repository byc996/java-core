package com.byc.concurrent;

import java.util.concurrent.*;

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.print("MyThread: " + i);
        }
        System.out.println();
    }
}

class MyRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.print("MyRunnable: " + i);
        }
        System.out.println();
    }
}

class MyCallable implements Callable {

    @Override
    public Object call() throws Exception {
        int count = 0;
        for (int i = 0; i < 100; i++) {
            count+=i;
        }
        return count;
    }
}


public class ThreadCreation {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 1. 继承Thread
        MyThread myThread = new MyThread();
        myThread.start(); // 启动新线程，在新线程中执行 run() 方法
//        myThread.run(); // 在主线程中执行

        // 2.1 实现Runnable接口
        MyRunnable myRunnable = new MyRunnable();
        myRunnable.run();
        // 2.2匿名内部类
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.print("匿名内部类: " + i);
                }
                System.out.println();
            }
        }).start();
        // 2.3 lambda
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.print("lambda: " + i);
            }
            System.out.println();
        }).start();

        // 3. callable
        MyCallable callable = new MyCallable();
        FutureTask futureTask = new FutureTask(callable);
        Thread thread = new Thread(futureTask);
        thread.start();
        Object count = futureTask.get();
        System.out.println("总和为：" + count);

        // 4.1 线程池 Executors
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.print("Executors: " + i);
                }
                System.out.println();
            }
        });
        // 别忘记关闭线程池
        executorService.shutdown();
        // 4.2 线程池 ThreadPoolExecutor
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 5,
                10, TimeUnit.SECONDS, new LinkedBlockingQueue<>(10));
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.print("ThreadPoolExecutor: " + i);
                }
                System.out.println();
            }
        });
        threadPoolExecutor.shutdown();
    }
}
