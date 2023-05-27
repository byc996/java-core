package com.byc.synchronization;

/**
 * volatile
 * 1. 保证可见性，不保证原子性
 * 2. 禁止指令重排
 */
public class VolatileDemo {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getSingleton();
    }
}

class Singleton {
    // volatile 是防止指令重排
    private static volatile Singleton singleton;

    private Singleton(){}
    public static Singleton getSingleton() {
        if (singleton == null) {
            // 创建对象需要加锁
            synchronized (Singleton.class) {
                // 需要再次判断是否为null，因为可能多个线程在第一次判断时为null
                if (singleton == null) {
                    /**
                     * singleton = new Singleton() 可以分为三步：
                     * 1. 分配内存
                     * 2. 初始化对象，调用构造函数
                     * 3. 变量指向对象地址
                     */
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}