package com.byc.sorting;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class BucketSort {


    public static void bucketSort(int[] arr, int bucket_size) {
        int min = arr[0], max = arr[0];
        for (int val : arr) {
            if (val < min) min = val;
            if (val > max) max = val;
        }
        int bucket_cnt = (max - min) / bucket_size + 1;
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < bucket_cnt; i++) {
            buckets.add(new ArrayList<>());
        }
        for (int val : arr) {
            int idx = (val - min) / bucket_size;
            buckets.get(idx).add(val);
        }
        for (int i = 0; i < bucket_cnt; i++) {
            Collections.sort(buckets.get(i));
        }
        int index = 0;
        for (List<Integer> bucket : buckets) {
            for (int val : bucket) arr[index++] = val;
        }

    }
}
