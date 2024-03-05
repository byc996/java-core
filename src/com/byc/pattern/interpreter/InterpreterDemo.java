package com.byc.pattern.interpreter;

// 抽象表达式接⼝
interface Expression {
    int interpret();
}

class TerminalExpression implements Expression {
    private int value;
    public TerminalExpression(int value) {
        this.value = value;
    }
    @Override
    public int interpret() {
        return value;
    }
}

class AddExpression implements Expression {
    private Expression left;
    private Expression right;
    public AddExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }
    @Override
    public int interpret() {
        return left.interpret() + right.interpret();
    }
}

class Context {
// 可以在上下⽂中存储⼀些全局信息或状态
}

public class InterpreterDemo {

    public static void main(String[] args) {
        Context context = new Context();
        Expression expression = new AddExpression(
                new TerminalExpression(1),
                new TerminalExpression(2)
        );
        int result = expression.interpret();
        System.out.println("Result: " + result);
    }
}
