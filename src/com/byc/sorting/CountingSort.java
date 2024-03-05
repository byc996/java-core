package com.byc.sorting;

public class CountingSort {

    public static void countingSort(int[] arr) {
        int min = arr[0], max = arr[0];
        for (int val : arr) {
            if (val < min) min = val;
            if (val > max) max = val;
        }
        if (min == max) return;
        int[] freq = new int[max - min + 1];
        for (int val: arr) freq[val - min]++;
        int index = 0;
        for (int i = 0; i < freq.length; i++) {
            for (int j = 0; j < freq[i]; j++) arr[index++] = min + i;
        }
    }
}
