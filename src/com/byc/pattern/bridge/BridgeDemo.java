package com.byc.pattern.bridge;

interface Implementation {
    void operationImpl();
}

interface TV {
    void on();
    void off();
    void tuneChannel();
}

class ConcreteImplementationA implements Implementation {
    @Override
    public void operationImpl() {
        // 具体实现A
    }
}
class ConcreteImplementationB implements Implementation {
    @Override
    public void operationImpl() {
        // 具体实现B
    }
}

class ATV implements TV {
    @Override
    public void on() {
        System.out.println("A TV is ON");
    }
    @Override
    public void off() {
        System.out.println("A TV is OFF");
    }
    @Override
    public void tuneChannel() {
        System.out.println("Tuning A TV channel");
    }
}
class BTV implements TV {
    @Override
    public void on() {
        System.out.println("B TV is ON");
    }
    @Override
    public void off() {
        System.out.println("B TV is OFF");
    }
    @Override
    public void tuneChannel() {
        System.out.println("Tuning B TV channel");
    }
}

abstract class Abstraction {
    protected Implementation mImplementor;
    public Abstraction(Implementation implementor) {
        this.mImplementor = implementor;
    }
    public void operation() {
        this.mImplementor.operationImpl();
    }
}
abstract class RemoteControl {
    // 持有⼀个实现化接⼝的引⽤
    protected TV tv;
    public RemoteControl(TV tv) {
        this.tv = tv;
    }
    abstract void turnOn();
    abstract void turnOff();
    abstract void changeChannel();
}


class RefinedAbstraction extends Abstraction {
    public RefinedAbstraction(Implementation implementation) {
        super(implementation);
    }
    @Override
    public void operation() {
// 委托给实现部分的具体类
        super.operation();
    }
}

class BasicRemoteControl extends RemoteControl {
    public BasicRemoteControl(TV tv) {
        super(tv);
    }
    @Override
    void turnOn() {
        tv.on();
    }
    @Override
    void turnOff() {
        tv.off();
    }
    @Override
    void changeChannel() {
        tv.tuneChannel();
    }
}

public class BridgeDemo {

    public static void main(String[] args) {
        // 创建具体实现化对象
        Implementation implementationA = new ConcreteImplementationA();
        Implementation implementationB = new ConcreteImplementationB();
// 使⽤扩充抽象化对象，将实现化对象传递进去
        Abstraction abstractionA = new RefinedAbstraction(implementationA);
        Abstraction abstractionB = new RefinedAbstraction(implementationB);
// 调⽤抽象化的操作
        abstractionA.operation();
        abstractionB.operation();

        TV aTV = new ATV();
        TV bTV = new BTV();
        RemoteControl basicRemoteForA = new BasicRemoteControl(aTV);
        RemoteControl basicRemoteForB = new BasicRemoteControl(bTV);

        basicRemoteForA.turnOn(); // A TV is ON
        basicRemoteForA.changeChannel(); // Tuning A TV channel
        basicRemoteForA.turnOff(); // A TV is OFF
        basicRemoteForB.turnOn(); // B TV is ON
        basicRemoteForB.changeChannel(); // Tuning B TV channel
        basicRemoteForB.turnOff(); // B TV is OFF
    }
}
