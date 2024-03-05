package com.byc.pattern.command;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

interface Command {
    void execute();
    void undo();
}

class ConcreteCommand implements Command {

    private Receiver receiver;

    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        // 调⽤接收者相应的操作
        receiver.action();
    }

    @Override
    public void undo() {

    }
}

class Receiver {
    public void action() {
        System.out.println("Receiver action");
    }
}

class Invoker {
    private Queue<Command> commandQueue; // 命令队列
    private Stack<Command> undoStack; // 撤销栈
    public Invoker() {
        this.commandQueue = new LinkedList<>();
        this.undoStack = new Stack<>();
    }
    // 设置命令并执⾏
    public void setAndExecuteCommand(Command command) {
        command.execute();
        commandQueue.offer(command);
        undoStack.push(command);
    }
    // 撤销上⼀个命令
    public void undoLastCommand() {
    if (!undoStack.isEmpty()) {
        Command lastCommand = undoStack.pop();
        lastCommand.undo(); // 需要命令类实现 undo ⽅法
        commandQueue.remove(lastCommand);
    } else {
        System.out.println("No command to undo.");
    }
}
    // 执⾏命令队列中的所有命令
    public void executeCommandsInQueue() {
        for (Command command : commandQueue) {
            command.execute();
        }
    }
}

public class CommandDemo {

    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        Command command = new ConcreteCommand(receiver);
        Invoker invoker = new Invoker();
        invoker.setAndExecuteCommand(command);
        invoker.executeCommandsInQueue();
    }
}
