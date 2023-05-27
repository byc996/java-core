package com.byc;

class OuterClass {
    private static final String URL = "http://localhost";
    private int count;

    public static class StaticInnerClass {

        // 静态内部类只能访问外部类的静态成员
        public void printMessage() {
            System.out.println("URL from outer class: " + URL );
//            System.out.println(count);  // error
        }
    }

    public static void printURL() {
        // static method cannot get non-static variable or invoke non-static method
        System.out.println(URL);
    }

    public void printCount() {
        System.out.println(count);
    }
}

public class StaticDemo {
    public static void main(String[] args) {
        OuterClass.printURL();
        OuterClass aStatic = new OuterClass(); // http://localhost
        aStatic.printCount(); // 0

        OuterClass.StaticInnerClass innerClass = new OuterClass.StaticInnerClass();
        innerClass.printMessage(); // URL from outer class: http://localhost
    }
}
