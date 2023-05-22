package com.byc.multithreading;

public class RunnableDemo {
    public static void main(String[] args) {
        /**
         *     public Thread(Runnable target) {
         *         init(null, target, "Thread-" + nextThreadNum(), 0);
         *     }
         *
         *     public Thread(Runnable target, String name) {
         *         init(null, target, name, 0);
         *     }
         */
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        }, "A").start();
        new Thread(new RunnableThread(), "B").start();
        new Thread(new RunnableThread(), "C").start();
    }
}

class RunnableThread implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}