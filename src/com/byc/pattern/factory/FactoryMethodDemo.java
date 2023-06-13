package com.byc.pattern.factory;

/**
 * 工厂方法模式
 */

abstract class Factory {
    abstract Car createCar();
}

class BYDFactory extends Factory{

    @Override
    Car createCar() {
        return new BYD();
    }
}

class TeslaFactory extends Factory{

    @Override
    Car createCar() {
        return new Tesla();
    }
}

public class FactoryMethodDemo {
    public static void main(String[] args) {
        Car byd = new BYDFactory().createCar();
        Car tesla = new TeslaFactory().createCar();
        byd.printName();
        tesla.printName();
    }
}
