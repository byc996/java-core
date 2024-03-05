package com.byc.pattern.mediator;

import java.util.ArrayList;
import java.util.List;

// 抽象中介者
abstract class Mediator {
    abstract void register(Colleague colleague);
    // 定义⼀个抽象的发送消息⽅法
    public abstract void send(String message, Colleague player);
}

// 同事对象
abstract class Colleague {
    protected Mediator mediator;
    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }
    // 发送消息
    public abstract void send(String message);
    // 接收消息
    public abstract void receive(String message);
}

// 具体中介者
class ConcreteMediator extends Mediator {
    private List<Colleague> colleagues = new ArrayList<>();
    public void register(Colleague colleague) {
        colleagues.add(colleague);
    }
    @Override
    public void send(String message, Colleague colleague) {
        for (Colleague c : colleagues) {
            // 排除发送消息的同事对象
            if (c != colleague) {
                c.receive(message);
            }
        }
    }
}

// 具体同事对象1
class ConcreteColleague1 extends Colleague {
    public ConcreteColleague1(Mediator mediator) {
        super(mediator);
    }
    @Override
    public void send(String message) {
        mediator.send(message, this);
    }
    @Override
    public void receive(String message) {
        System.out.println("ConcreteColleague1 received: " + message);
    }
}

// 具体同事对象1
class ConcreteColleague2 extends Colleague {
    public ConcreteColleague2(Mediator mediator) {
        super(mediator);
    }
    @Override
    public void send(String message) {
        mediator.send(message, this);
    }
    @Override
    public void receive(String message) {
        System.out.println("ConcreteColleague2 received: " + message);
    }
}
public class MediatorDemo {
    public static void main(String[] args) {
        // 创建中介者
        Mediator mediator = new ConcreteMediator();
        // 创建同事对象
        Colleague colleague1 = new ConcreteColleague1(mediator);
        Colleague colleague2 = new ConcreteColleague2(mediator);
        // 注册同事对象到中介者
        mediator.register(colleague1);
        mediator.register(colleague2);
        // 同事对象之间发送消息
        colleague1.send("Hello from Colleague1!");
        colleague2.send("Hi from Colleague2!");
    }
}
