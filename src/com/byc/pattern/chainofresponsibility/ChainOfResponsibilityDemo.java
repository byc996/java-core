package com.byc.pattern.chainofresponsibility;

import jdk.internal.org.objectweb.asm.Handle;

interface Handler {
    // 处理请求的⽅法
    void handleRequest(Request request);
    // 设置下⼀个处理者的⽅法
    void setNextHandler(Handler nextHandler);
}

class ConcreteHandler implements Handler {
    private Handler nextHandler;

    @Override
    public void handleRequest(Request request) {
        // 根据具体情况处理请求，如果⽆法处理则交给下⼀个处理者
        if (canHandle(request)) {
            // 处理请求的逻辑
        } else if (nextHandler != null) {
            // 交给下⼀个处理者处理
            nextHandler.handleRequest(request);
        } else {
            // ⽆法处理请求的逻辑
        }
    }

    @Override
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    // 具体处理者⾃⼰的判断条件
    private boolean canHandle(Request request) {
// 根据具体情况判断是否能够处理请求
//        return /* 判断条件 */;
        return true;
    }
}

class Request {

}

public class ChainOfResponsibilityDemo {

    public static void main(String[] args) {
        // 创建处理者实例
        Handler handler1 = new ConcreteHandler();
        Handler handler2 = new ConcreteHandler();
        // 构建责任链
        handler1.setNextHandler(handler2);

        // 发送请求
        Request request = new Request(/* 请求参数 */);
        handler1.handleRequest(request);
    }
}
