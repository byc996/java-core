package com.byc.pattern.proxy;

// 1. 定义抽象主题
interface Subject {
    void request();
}

// 2. 定义真实主题
class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("RealSubject handles the request.");
    }
}

// 3. 定义代理
class ProxySubject implements Subject {

    private RealSubject realSubject;

    @Override
    public void request() {
        // 在访问真实主题之前可以添加额外的逻辑
        if (realSubject == null) {
            realSubject = new RealSubject();
        }
        // 调⽤真实主题的⽅法
        realSubject.request();
        // 在访问真实主题之后可以添加额外的逻辑
        System.out.println("proxy");
    }
}


public class ProxyDemo {
    public static void main(String[] args) {
        // 使⽤代理
        Subject subject = new ProxySubject();
        subject.request();
    }
}
