package com.byc.oop;


// static, compile time
class Overload {
    public double cal(double a, int b) {
        return a + b;
    }
    // 方法名必须相同，参数列表必须不同
    public double cal(double a, double b) {
        return a + b;
    }
    // 参数列表不同时，返回值可以不同
    public String cal(double a, double b, double c) {
        return String.valueOf(a + b + c);
    }
}

// dynamic, runtime
class OverrideParent{
    protected Number test(){
        return 1;
    }
}

class OverrideChild1 extends OverrideParent{
    @Override
    protected Number test() {
        return 2;
    }

    public void print() {
        System.out.println("child");
    }
}

class OverrideChild2 extends OverrideParent{
    // 子类返回值 <= 父类返回值
    @Override
    protected Integer test() {
        return 3;
    }
}

class OverrideChild3 extends OverrideParent{
    // public > protected > default > private
    // 子类权限修饰符 >= 父类权限修饰符
    @Override
    public Number test() {
        return 4;
    }
}


public class PolymorphismDemo {

    public static void overloadFunc(){
        double a = 1.2, b = 2.3, c = 8.0;
        int d = 4;
        Overload overloadDemo = new Overload();
        System.out.println(overloadDemo.cal(a, d));
        System.out.println(overloadDemo.cal(a, b));
        System.out.println(overloadDemo.cal(a, d, c));
    }
    public static void overrideFunc(){
        OverrideParent o1 = new OverrideChild1();
        OverrideParent o2 = new OverrideChild2();
        OverrideParent o3 = new OverrideChild3();
        System.out.println(o1.test());  // 如果子类重写了父类方法，则会调用子类的方法
//        o1.print(); 父类对象不能调用不存在父类的方法
        System.out.println(o2.test());
        System.out.println(o3.test());
    }

    public static void main(String[] args) {
        overloadFunc();
        overrideFunc();
    }
}
