package com.byc.collection;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayToCollectionDemo {

    public static void referenceArrayToList() {
        String[] strArray = {"hello", " , ", "world"};
        // 第一种 Arrays.asList
        List<String> list1 = Arrays.asList(strArray);
        System.out.println(list1);

        // 第二种 Arrays.stream
        List<String> list2 = Arrays.stream(strArray).collect(Collectors.toList());
        System.out.println(list2);
    }

    public static void primitiveArrayToList() {
        int[] ints = {1, 3, 23, 3, 44, 592};
        List<Integer> list1 = Arrays.stream(ints).boxed().collect(Collectors.toList());
        System.out.println(list1);

        char[] cs = {'a', 'r', 's', 'b', '1'};
        // chars() 方法 将CharSequence转换成IntStream
        List<Character> list2 = String.valueOf(cs).chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        System.out.println(list2);
        List<Character> list3 = new ArrayList<>();
        for (char c : cs) {
            list3.add(c);
        }
        System.out.println(list3);
    }

    public static void listToReferenceArray() {
        List<String> stringList = Arrays.asList("hello", " , ", "world");
        String[] strs = stringList.toArray(new String[0]);
        System.out.println(Arrays.toString(strs));
    }

    public static void listToPrimitiveArray() {
        // int list -> int array
        List<Integer> intList = Arrays.asList(23, 2, 44, 98);
        int[] ints = intList.stream().mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(ints));

        // Character list -> char array
        List<Character> charList = Arrays.asList('a', '8', 'q', 'b');
        String collect = charList.stream().map(String::valueOf).collect(Collectors.joining());
        char[] charArray = collect.toCharArray();
        System.out.println(charArray);

        // Boolean list -> boolean array
        List<Boolean> boolList = Arrays.asList(true, false, true, true);
        boolean[] boolArray = new boolean[boolList.size()];
        for (int i = 0; i < boolList.size(); i++) {
            boolArray[i] = boolList.get(i);
        }
        System.out.println(Arrays.toString(boolArray));
    }

    public static void listToSet() {
        List<Integer> integerList = Arrays.asList(12, 23, 4223, 13, 23, 13);
        Set<Integer> set = new HashSet<>(integerList);
        System.out.println(set);

        List<Integer> integerList2 = new ArrayList<>(set);
        System.out.println(integerList2);
    }

    public static void arrayToString() {
        char[] cs = {'a', 'd', '1', '9'};
        String cStr = String.valueOf(cs);
        System.out.println(cStr);

        int[] is = {32, 10, 23, 2, 5, 9};
        String iStr = Arrays.stream(is).mapToObj(String::valueOf).collect(Collectors.joining());
        System.out.println(iStr);

        String[] ss = {"hello", ", ", "world"};
        String join = String.join("~", ss);
        System.out.println(join); // hello~, ~world
    }

    public static void listToString() {
        List<Integer> iList = Arrays.asList(23, 44, 2, 98, 0);
        String s = iList.toString();
        System.out.println(s); // [23, 44, 2, 98, 0]

        //
        List<String> sList = Arrays.asList("0", "sdf", "ew", "*");
        // join(CharSequence delimiter, Iterable<? extends CharSequence> elements)
        String join = String.join("~", sList);
        System.out.println(join); // 0~sdf~ew~*

        List<Character> cList = Arrays.asList('i', '9', 'k');
        String collect = cList.stream().map(String::valueOf).collect(Collectors.joining(",", "{", "}"));
        System.out.println(collect); // {i,9,k}
    }


    public static void main(String[] args) {
//        referenceArrayToList();
//        primitiveArrayToList();
//        listToReferenceArray();
//        listToPrimitiveArray();
//        listToSet();
        arrayToString();
        listToString();
    }
}
