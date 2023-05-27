package com.byc.synchronization;

import java.util.concurrent.TimeUnit;

/**
 *
 */
public class SynchronizedDemo {

    public static void func1(){
        // 两个线程同一个对象调用 非同步 方法
        Phone phone = new Phone();
        new Thread(()->{
            phone.sendEmail();
        }).start();
        new Thread(()->{
            phone.sendSMS();
        }).start();

        /**
         * 输出：
         * Send an email
         * Send a message
         *
         * 普通方法没有锁，所以按调用时间email会先执行
         */
    }

    public static void func2(){
        // 两个线程同一个对象调用 同步 方法
        Phone phone = new Phone();
        new Thread(()->{
            phone.sendSynchronizedEmail();
        }).start();

        new Thread(()->{
            phone.sendSynchronizedSMS();
        }).start();

        /**
         * 输出：
         * wait for 1s
         * Send a synchronized email
         * Send a synchronized message
         *
         * 普通同步方法锁同一个对象，sms 需要等email
         */
    }

    public static void func3(){
        // 两个线程不同对象调用 同步 方法
        Phone phone1 = new Phone();
        Phone phone2 = new Phone();
        new Thread(()->{
            phone1.sendSynchronizedEmail();
        }).start();
        new Thread(()->{
            phone2.sendSynchronizedSMS();
        }).start();

        /**
         * 输出：
         * Send a synchronized message
         * wait for 1s
         * Send a synchronized email
         *
         * 锁的是不同对象，所以按时间顺序执行
         */
    }

    public static void func4(){
        // 两个线程调用 静态同步 方法
        new Thread(()->{
            Phone.sendStaticSynchronizedEmail();
        }).start();
        new Thread(()->{
            Phone.sendstaticSynchronizedSMS();
        }).start();

        /**
         * 输出：
         * wait for 1s
         * Send a static synchronized email
         * Send a static synchronized message
         *
         * 静态同步方法锁的是类，所以message 需要等待email
         */
    }
    public static void main(String[] args) {
//        func1();
//        func2();
//        func3();
        func4();
    }



}

class Phone {

    public void sendEmail(){
        System.out.println("Send an email");
    }

    public void sendSMS(){
        System.out.println("Send a message");
    }

    public synchronized void sendSynchronizedEmail(){
        try {
            TimeUnit.SECONDS.sleep(1);
            System.out.println("wait for 1s");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Send a synchronized email");
    }

    public synchronized void sendSynchronizedSMS(){
        System.out.println("Send a synchronized message");
    }

    public static synchronized void sendStaticSynchronizedEmail(){
        try {
            TimeUnit.SECONDS.sleep(1);
            System.out.println("wait for 1s");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Send a static synchronized email");
    }

    public static synchronized void sendstaticSynchronizedSMS(){
        System.out.println("Send a static synchronized message");
    }
}