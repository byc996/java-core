package com.byc.sorting;

public class ShellSort {

    public static void shellSort(int[] arr) {
        int gap = arr.length / 2;
        while (gap > 0) {
            for (int i = gap; i < arr.length; i++) {
                int current = arr[i];
                int prevIndex = i - gap;
                // insertion sort
                while (prevIndex >= 0 && arr[prevIndex] > current) {
                    arr[prevIndex + gap] = arr[prevIndex];
                    prevIndex -= gap;
                }
                arr[prevIndex + gap] = current;
            }
            gap /= 2;
        }
    }
}
