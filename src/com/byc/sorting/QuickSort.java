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
        // i: index of smaller element
        // j: loop variable
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = pivot;
        arr[right] = temp;
        return i + 1;
//        int pivot = arr[right];
//        int pointer = left;
//        for (int i = left; i < right; i++) {
//            if (arr[i] < pivot) {
//                int temp = arr[i];
//                arr[i] = arr[pointer];
//                arr[pointer] = temp;
//                pointer++;
//            }
//        }
//        int temp = arr[pointer];
//        arr[pointer] = arr[right];
//        arr[right] = temp;
//        return pointer;
    }
}
