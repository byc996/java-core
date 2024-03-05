package com.byc.sorting;

import java.util.ArrayList;
import java.util.List;

public class RadixSort {

    public static void radixSort(int[] arr) {
        if (arr.length < 2) return;
        int max = arr[0];
        for (int val : arr) {
            if (val > max) max = val;
        }
        int N = 1;
        while (max / 10 != 0) {
            max /= 10;
            N++;
        }
        for (int i = 0; i < N; i++) {
            List<List<Integer>> radix = new ArrayList<>();
            for (int j = 0; j < 10; j++) radix.add(new ArrayList<>());
            for (int val : arr) {
                int idx = (val / (int)Math.pow(10, i)) % 10;
                radix.get(idx).add(val);
            }
            int index = 0;
            for (List<Integer> l: radix) {
                for (int val: l) arr[index++] = val;
            }
        }

    }
}
