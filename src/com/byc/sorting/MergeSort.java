package com.byc.sorting;

import java.util.Arrays;

public class MergeSort {

    public static int[] mergeSort(int[] arr) {
        if (arr.length <= 1) return arr;
        int mid = arr.length / 2;
        int[] arr1 = Arrays.copyOfRange(arr, 0, mid);
        int[] arr2 = Arrays.copyOfRange(arr, mid, arr.length);
        return merge(mergeSort(arr1), mergeSort(arr2));
    }

    private static int[] merge(int[] arr1, int[] arr2) {
        int[] mergedArr = new int[arr1.length + arr2.length];
        int index = 0;
        int p1 = 0, p2 = 0;
        while (p1 < arr1.length && p2 < arr2.length) {
            if (arr1[p1] < arr2[p2]) mergedArr[index++] = arr1[p1++];
            else mergedArr[index++] = arr2[p2++];
        }
        while (p1 < arr1.length) {
            mergedArr[index++] = arr1[p1++];
        }
        while (p2 < arr2.length) {
            mergedArr[index++] = arr2[p2++];
        }
        return mergedArr;
    }
}
