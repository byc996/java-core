package com.byc.functional_interface;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;

public class ConsumerDemo {
    public static void main(String[] args) {
        String str = "hello";
        // lambda 表达式
//        Consumer consumer = s -> System.out.println(s);
        Consumer consumer = System.out::println; // method reference
        consumer.accept(str); // hello

        Arrays.asList(1, 3, 4, 5).forEach(ConsumerDemo::print); // 依次打印 12345

        transform(str, s -> {
            System.out.println(s.toUpperCase()); // HELLO
        });
    }

    public static void transform(String s, Consumer<String> consumer) {
        consumer.accept(s);
    }

    public static void print(Integer s) {
        System.out.print(s);
    }
}
