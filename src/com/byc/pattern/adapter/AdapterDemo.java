package com.byc.pattern.adapter;

// ⽬标接⼝
interface Target {
    void request();
}

// 被适配者类
class Adaptee {
    void specificRequest() {
        System.out.println("Specific request");
    }
}

// 适配器类
class Adapter implements Target {

    private Adaptee adaptee;

    Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        adaptee.specificRequest();
    }
}

public class AdapterDemo {

    public static void main(String[] args) {
        Target target = new Adapter(new Adaptee());
        target.request();
    }
}
