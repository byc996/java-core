package com.byc.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableDemo {
    public static void main(String[] args) {
        CallableThread callableThread = new CallableThread();
        FutureTask<String> futureTask = new FutureTask(callableThread);
        new Thread(futureTask).start();
        try {
            String result = futureTask.get();
            System.out.println(result);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

    }
}


class CallableThread implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(2000);
        return "return value";
    }
}