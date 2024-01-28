package com.byc.interview;

public class TerminateThread {

    private static void stopTerminateThread() throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        Thread.sleep(500);
        thread.stop();
        Thread.sleep(500);
        System.out.println(thread.getState());
    }

    static volatile boolean flag = true;
    private static void variableTerminateThread() throws InterruptedException {


        Thread thread = new Thread(() -> {
           while (flag) {

           }
            System.out.println("任务结束");
        });
        thread.start();
        Thread.sleep(500);
        flag = false;
        Thread.sleep(500);
        System.out.println(thread.getState());
    }

    private static void interruptTerminateThread() throws InterruptedException {

        Thread thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {

            }
            System.out.println("任务结束");
        });
        thread.start();
        Thread.sleep(500);
        System.out.println(thread.isInterrupted());
        thread.interrupt();
        Thread.sleep(500);
        System.out.println(thread.getState());
    }

    public static void main(String[] args) throws InterruptedException {
//        stopTerminateThread(); // TERMINATED
//        variableTerminateThread(); // TERMINATED
        interruptTerminateThread(); // TERMINATED
    }
}
