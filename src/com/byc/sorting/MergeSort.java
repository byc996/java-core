package com.byc.sorting;

import java.util.Arrays;

public class MergeSort {

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid ,right);
        }
    }

    private static void merge(int[] arr, int left, int mid , int right) {
        int[] merged = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                merged[k++] = arr[i++];
            } else {
                merged[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            merged[k++] = arr[i++];
        }
        while (j <= right) {
            merged[k++] = arr[j++];
        }
        for (int l = left; l<= right; l++) {
            arr[l] = merged[l - left];
        }
    }
}
