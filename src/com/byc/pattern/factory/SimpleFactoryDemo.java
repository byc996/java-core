package com.byc.pattern.factory;

/**
 * 简单工厂模式
 */

class Car {
    void printName(){
        System.out.println("Car");
    }
}

class BYD extends Car {

    @Override
    void printName() {
        System.out.println("BYD");
    }
}

class Tesla extends Car {
    @Override
    void printName() {
        System.out.println("Tesla");
    }
}

class CarFactory {
    public Car getCar(String name) {
        if (name.equals("BYD")) {
            return new BYD();
        } else if (name.equals("Tesla")) {
            return new Tesla();
        } else {
            return new Car();
        }
    }
}

public class SimpleFactoryDemo {

    public static void main(String[] args) {
        CarFactory carFactory = new CarFactory();
        Car tesla = carFactory.getCar("Tesla");
        tesla.printName();
        Car byd = carFactory.getCar("BYD");
        byd.printName();
    }
}
