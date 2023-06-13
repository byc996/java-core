package com.byc.pattern.factory;

class Laptop {
    void printName(){
        System.out.println("Laptop");
    }
}

class Mac extends Laptop {
    @Override
    void printName() {
        System.out.println("Laptop: Mac");
    }
}

class Matebook extends Laptop {
    @Override
    void printName() {
        System.out.println("Laptop: Matebook");
    }
}

class Phone {
    void printName(){
        System.out.println("Phone");
    }
}

class IPhone extends Phone {
    @Override
    void printName() {
        System.out.println("Phone: iPhone");
    }
}

class HuaweiPhone extends Phone {
    @Override
    void printName() {
        System.out.println("Phone: HuaweiPhone");
    }
}

abstract class AbstractClass {
    abstract Laptop createLaptop();
    abstract Phone createPhone();
}

class HuaweiFactory extends AbstractClass {

    @Override
    Laptop createLaptop() {
        return new Matebook();
    }

    @Override
    Phone createPhone() {
        return new HuaweiPhone();
    }
}

class AppleFactory extends AbstractClass {

    @Override
    Laptop createLaptop() {
        return new Mac();
    }

    @Override
    Phone createPhone() {
        return new IPhone();
    }
}


public class AbstractFactoryDemo {

    public static void main(String[] args) {
        HuaweiFactory huaweiFactory = new HuaweiFactory();
        AppleFactory appleFactory = new AppleFactory();
        huaweiFactory.createLaptop().printName(); // Laptop: Matebook
        huaweiFactory.createPhone().printName(); // Phone: HuaweiPhone
        appleFactory.createLaptop().printName(); // Laptop: Mac
        appleFactory.createPhone().printName(); // Phone: iPhone
    }
}
