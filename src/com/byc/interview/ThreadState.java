package com.byc.interview;



public class ThreadState {

    private void newState() {
        Thread thread = new Thread(() -> System.out.println("new"));
        System.out.println(thread.getState());
    }

    private void runnableState() {
        Thread thread = new Thread(() -> {
            while (true) {

            }
        });
        thread.start();
        System.out.println(thread.getState());
    }

    private void blockedState() throws InterruptedException {
        Object object = new Object();
        Thread t1 = new Thread(() -> {
            // t1 线程拿不到锁资源，导致变成blocked状态
            synchronized (object) {

            }
        });
        synchronized (object) {
            t1.start();
            Thread.sleep(500);
            System.out.println(t1.getState());
        }
    }

    private void waitingState() throws InterruptedException {
        Object object = new Object();
        Thread thread = new Thread(() -> {
            synchronized (object) {
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread.start();
        Thread.sleep(500);
        System.out.println(thread.getState());
    }

    private void timedWaitingState() throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        thread.start();
        Thread.sleep(500);
        System.out.println(thread.getState());
    }

    private void terminatedState() throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        thread.start();
        Thread.sleep(1000);
        System.out.println(thread.getState());
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadState threadState = new ThreadState();
//        threadState.newState(); // NEW
//        threadState.runnableState(); // RUNNABLE
//        threadState.blockedState(); // BLOCKED
//        threadState.waitingState(); // WAITING
//        threadState.timedWaitingState(); // TIMED_WAITING
        threadState.terminatedState(); // TERMINATED
    }
}
