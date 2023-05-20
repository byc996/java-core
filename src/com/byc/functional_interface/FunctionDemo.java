package com.byc.functional_interface;

import java.util.Arrays;
import java.util.function.Function;

public class FunctionDemo {
    public static void main(String[] args) {
        Function<Integer, Double> function = val -> (val + val * 0.2);
        double salary = salary(1000, function);
        System.out.println(salary);

        Arrays.asList(100, 1000, 2000).stream().map(function).forEach(System.out::println);
    }

    public static double salary(int base, Function<Integer, Double> function) {
        return function.apply(base);
    }
}
