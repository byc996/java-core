package com.byc.multithreading;

public class ThreadDemo {
    public static void main(String[] args) {
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();
        MyThread thread3 = new MyThread();
        thread1.start(); // Thread-1
        thread2.start();
        thread3.start();
//        thread3.start();  // start() 不能重复执行
        thread3.run();  // main
        thread3.run();  // main
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(currentThread().getName());
    }
}
