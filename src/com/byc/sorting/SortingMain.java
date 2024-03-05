package com.byc.sorting;

import java.util.Arrays;

public class SortingMain {

    public static void main(String[] args) {
        int[] arr = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
//        BubbleSort.bubbleSort(arr);
//        InsertionSort.insertionSort(arr);
//        SelectionSort.selectionSort(arr);
//        QuickSort.quickSort(arr, 0, arr.length - 1);
//        ShellSort.shellSort(arr);
//        System.out.println(Arrays.toString(arr));
//        MergeSort.mergeSort(arr, 0, arr.length-1);
//        System.out.println(Arrays.toString(arr));
//        HeapSort.heapSort(arr);
//        System.out.println(Arrays.toString(arr));
//        CountingSort.countingSort(arr);
//        System.out.println(Arrays.toString(arr));
//        BubbleSort.bubbleSort(arr);
//        System.out.println(Arrays.toString(arr));
        RadixSort.radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
