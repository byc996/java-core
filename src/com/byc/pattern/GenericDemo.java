package com.byc.pattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class GenericClass <T extends Number> {
    T data;
    public GenericClass(T data) {
        this.data = data;
    }

    public void print() {
        System.out.println(data);
    }
}


public class GenericDemo {

    public static <T, V> void print(T data1, V data2) {
        System.out.println(data1 + " " + data2);
    }


    public static <T, V> T print1(T data1, V data2) {
        return data1;
    }

    public static void printList(List<?> list) {
        System.out.println(list);
    }

    public static void main(String[] args) {
        GenericClass<Float> integerGenericClass = new GenericClass<>(23f);
//        GenericClass<String> integerGenericClass1 = new GenericClass<>("sdf");
        integerGenericClass.print();
        GenericDemo.print("heldsf", 132);

        List<Integer> integers = new ArrayList<>(Arrays.asList(1,2,3));
        printList(integers);

        List<String> strs = new ArrayList<>(Arrays.asList("hello", " wk ", "world"));
        printList(strs);
    }
}
