package com.byc.sorting;

public class QuickSort {

    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pos = partition(arr, left, right);
            quickSort(arr, left, pos -1);
            quickSort(arr, pos + 1, right);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int pointer = left;
        for (int i = left; i < right; i++) {
            if (arr[i] < pivot) {
                int temp = arr[i];
                arr[i] = arr[pointer];
                arr[pointer] = temp;
                pointer++;
            }
        }
        int temp = arr[pointer];
        arr[pointer] = arr[right];
        arr[right] = temp;
        return pointer;
    }
}
