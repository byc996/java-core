package com.byc.pattern.visitor;

// 定义动物接⼝
interface Animal {
    void accept(Visitor visitor);
}
// 具体元素类：狮⼦
class Lion implements Animal {
    @Override
    public void accept(Visitor visitor) {
        System.out.print("⼤狮: ");
        visitor.visit(this);
    }
}
// 具体元素类：⼤象
class Elephant implements Animal {
    @Override
    public void accept(Visitor visitor) {
        System.out.print("⼤象: ");
        visitor.visit(this);
    }
}
// 具体元素类：猴⼦
class Monkey implements Animal {
    @Override
    public void accept(Visitor visitor) {
        System.out.print("猴⼦: ");
        visitor.visit(this);
    }
}

// 定义访问者接⼝
interface Visitor {
    void visit(Animal animal);
}

// 具体访问者类：医⽣
class Vet implements Visitor {
    @Override
    public void visit(Animal animal) {
        System.out.println("医生检查");
    }
}
// 具体访问者类：管理员
class Zookeeper implements Visitor {
    @Override
    public void visit(Animal animal) {
        System.out.println("管理员投喂");
    }
}
// 具体访问者类：游客
class VisitorPerson implements Visitor {
    @Override
    public void visit(Animal animal) {
        System.out.println("游客参观");
    }
}
public class VisitorDemo {
    public static void main(String[] args) {
        Animal lion = new Lion();
        Animal elephant = new Elephant();
        Animal monkey = new Monkey();
        Visitor vet = new Vet();
        Visitor zookeeper = new Zookeeper();
        Visitor visitorPerson = new VisitorPerson();
        // 动物接受访问者的访问
        lion.accept(vet);
        elephant.accept(zookeeper);
        monkey.accept(visitorPerson);
    }
}
