package com.byc.functional_interface;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Predicate;

public class PredicateDemo {
    public static void main(String[] args) {
        Predicate<String> predicate = s -> s.length() > 5;
        System.out.println(check("hello", predicate)); // false

        Arrays.asList("sd", "heeeeee", "i2321111", "wewee")
                .stream().filter(predicate).forEach(System.out::println); // heeeeee     i2321111
    }

    public static boolean check(String s, Predicate<String> predicate) {
        return predicate.test(s);
    }
}
