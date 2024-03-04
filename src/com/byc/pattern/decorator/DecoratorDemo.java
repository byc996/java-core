package com.byc.pattern.decorator;

// 组件接⼝
interface Component {
    void operation();
}

// 具体组件
class ConcreteComponent implements Component {
    @Override
    public void operation() {
        System.out.println("ConcreteComponent operation");
    }
}

// 定义⼀个抽象的装饰者类，继承⾃Component
abstract class Decorator implements Component {
    protected Component component;
    Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void operation() {
        component.operation();
    }
}

// 具体的装饰者实现
class ConcreteDecorator extends Decorator {

    ConcreteDecorator(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        // 可以在调⽤前后添加额外的⾏为
        System.out.println("Before operation in ConcreteDecorator");
        super.operation();
        System.out.println("After operation in ConcreteDecorator");
    }
}

public class DecoratorDemo {

    public static void main(String[] args) {
        // 创建具体组件
        Component concreteComponent = new ConcreteComponent();
        // 使⽤具体装饰者包装具体组件
        Decorator decorator = new ConcreteDecorator(concreteComponent);
        // 调⽤操作
        decorator.operation();
    }
}
