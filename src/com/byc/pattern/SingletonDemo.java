package com.byc.pattern;


/**
 * 懒汉式
 */
class Singleton1 {
    private static Singleton1 singleton;

    public static Singleton1 getInstance() {
        if (singleton == null) {
            return new Singleton1();
        }
        return singleton;
    }
}

/**
 * 饿汉式
 */
class Singleton2 {
    private static Singleton2 singleton2 = new Singleton2();

    public static Singleton2 getInstance() {
        return singleton2;
    }
}

public class SingletonDemo {
}
