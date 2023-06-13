package com.byc.pattern.singleton;


import java.io.*;
import java.lang.reflect.Constructor;

/**
 * 饿汉式
 */
class EagerSingleton {
    private static EagerSingleton instance = new EagerSingleton();

    private EagerSingleton(){
    }

    public static EagerSingleton getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        EagerSingleton instance1 = EagerSingleton.getInstance();
        EagerSingleton instance2 = EagerSingleton.getInstance();
        System.out.println(instance1 == instance2); // true

    }
}

/**
 * 单线程情况下，懒汉式
 */
class LazySingleton {
    private static LazySingleton instance;
    private LazySingleton() {}

    public static LazySingleton getInstance() {
        if (instance == null) {
            // 多个线程都进入这里，则都会创建新的示例
//            try {
//                TimeUnit.MILLISECONDS.sleep(200);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
            return new LazySingleton();
        }
        return instance;
    }

    public static void main(String[] args) {
        // 多线程情况下不能保证单例
        new Thread(()->{
            LazySingleton lazySingleton = LazySingleton.getInstance();
            System.out.println(lazySingleton); // com.byc.pattern.singleton.LazySingleton@7e76633a
        }).start();

        new Thread(()->{
            LazySingleton lazySingleton = LazySingleton.getInstance();
            System.out.println(lazySingleton); // com.byc.pattern.singleton.LazySingleton@24fac2ca
        }).start();
    }
}

/**
 * 多线程情况下，懒汉式
 */
class SafeLazySingleton {
    private static volatile SafeLazySingleton instance;

    private SafeLazySingleton(){
    }

    public static SafeLazySingleton getInstance() {
        if (instance == null) {
            synchronized (SafeLazySingleton.class) {
                if (instance == null) {
                    instance = new SafeLazySingleton();
                    // 第2步和第3步没有依赖关系，顺序可以颠倒，如果发生指令重排，多线程下，可能出现问题，volatile可以解决
                    // 1. 分配空间
                    // 2. 初始化
                    // 3. 引用赋值
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        // 多线程情况下保证单例
        new Thread(()->{
            SafeLazySingleton safeLazySingleton = SafeLazySingleton.getInstance();
            System.out.println(safeLazySingleton); // com.byc.pattern.singleton.SafeLazySingleton@22da6b96
        }).start();

        new Thread(()->{
            SafeLazySingleton safeLazySingleton = SafeLazySingleton.getInstance();
            System.out.println(safeLazySingleton); // com.byc.pattern.singleton.SafeLazySingleton@22da6b96
        }).start();


    }
}

/**
 * 静态内部类
 */
class InnerClassSingleton{
    private static class InnerClassHolder {
        private static InnerClassSingleton instance = new InnerClassSingleton();
    }
    private InnerClassSingleton() {
        // 防止反射攻击，直接抛出异常
        if (InnerClassHolder.instance != null) {
            throw new RuntimeException("单例中不允许创建多个instance");
        }
    }

    public static InnerClassSingleton getInstance() {
        return InnerClassHolder.instance;
    }

    public static void main(String[] args) {
        InnerClassSingleton instance1 = InnerClassSingleton.getInstance();
        InnerClassSingleton instance2 = InnerClassSingleton.getInstance();
        System.out.println(instance1 == instance2); // true

        // 多线程情况下也能保证线程安全
        new Thread(()->{
            InnerClassSingleton instance3 = InnerClassSingleton.getInstance();
            System.out.println(instance3); // com.byc.pattern.singleton.InnerClassSingleton@5ead6287
        }).start();
        new Thread(()->{
            InnerClassSingleton instance4 = InnerClassSingleton.getInstance();
            System.out.println(instance4); // com.byc.pattern.singleton.InnerClassSingleton@5ead6287
        }).start();

        // 使用反射的方式创建instance，会破坏单例，怎么防止这种情况呢？
        try{
            Constructor<InnerClassSingleton> declaredConstructor = InnerClassSingleton.class.getDeclaredConstructor();
            declaredConstructor.setAccessible(true);
            InnerClassSingleton instance5 = declaredConstructor.newInstance();

            System.out.println(instance1 == instance5); // false
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}

enum EnumSingleton{
    INSTANCE;

    public static void main(String[] args) {
        EnumSingleton instance1 = EnumSingleton.INSTANCE;
        EnumSingleton instance2 = EnumSingleton.INSTANCE;
        System.out.println(instance1==instance2); // true

        Constructor<EnumSingleton> declaredConstructor = null;
        try {
            declaredConstructor = EnumSingleton.class.getDeclaredConstructor(String.class, int.class);
            declaredConstructor.setAccessible(true);
            EnumSingleton instance = declaredConstructor.newInstance("INSTANCE", 0); // 报错, 不能反射创建枚举类型
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}

// 序列化和反序列化破坏单例
public class SingletonDemo implements Serializable {

    // 不过不添加serialVersionUID，当类修改时，比如添加其他属性或方法是，反序列化会报不匹配的错误
    private static final long serialVersionUID = 42L;
    private static SingletonDemo instance = new SingletonDemo();

    public static SingletonDemo getInstance() {
        return instance;
    }
    // 序列化和反序列化会破坏单例， 添加readResolve方法可以解决，返回单例
    Object readResolve(){
        return instance;
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        SingletonDemo instance1 = SingletonDemo.getInstance();
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("text"));
//        objectOutputStream.writeObject(instance1);
//        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("text"));
        SingletonDemo instance2 = (SingletonDemo)objectInputStream.readObject();
        System.out.println(instance1 == instance2); // 如果不存在readResolve方法，则为false，如果存在，则为true
    }
}
