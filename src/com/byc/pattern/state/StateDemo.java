package com.byc.pattern.state;

// 状态接⼝
interface State {
    void handle();
}

// 具体状态类1
class ConcreteState1 implements State {
    @Override
    public void handle() {
        // 执⾏在状态1下的操作
        System.out.println("state1");
    }
}

// 具体状态类2
class ConcreteState2 implements State {
    @Override
    public void handle() {
        // 执⾏在状态2下的操作
        System.out.println("state2");
    }
}

// 上下⽂类
class Context {
    private State currentState;
    public void setState(State state) {
        this.currentState = state;
    }
    public void request() {
        currentState.handle();
    }
}

public class StateDemo {
    public static void main(String[] args) {
        Context context = new Context();
        State state1 = new ConcreteState1();
        State state2 = new ConcreteState2();
        context.setState(state1);
        context.request(); // 执⾏在状态1下的操作
        context.setState(state2);
        context.request(); // 执⾏在状态2下的操作
    }
}
