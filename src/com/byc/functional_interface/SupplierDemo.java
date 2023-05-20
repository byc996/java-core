package com.byc.functional_interface;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class SupplierDemo {
    public static void main(String[] args) {
        // 使用lambda表达式作为Supplier
        Supplier<Integer> supplier = () -> new Random().nextInt();
        System.out.println(supplier.get()); // 随机整数

        // Supplier 作为参数
        int result = func(() -> 10);
        System.out.println(result); // 10

    }

    public static int func(Supplier<Integer> supplier) {
        return supplier.get();
    }

}
