package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LeetCode_347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> occurences = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (occurences.containsKey(nums[i])) {
                occurences.put(nums[i], occurences.get(nums[i]) + 1);
            }
            else {
                occurences.putIfAbsent(nums[i], 0);
            }
        }
        List<int[]> occurrenceList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : occurences.entrySet()) {
            occurrenceList.add(new int[]{entry.getKey(), entry.getValue()});
        }
        List<int[]> heap = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            heap.add(occurrenceList.get(i));
        }
        for (int i = k / 2 - 1; i >= 0; i--) {
            adjustHeap(heap, i);
        }
        for (int i = k; i < occurrenceList.size(); i++) {
            if (occurrenceList.get(i)[1] > heap.get(0)[1]) {
                heap.set(0, occurrenceList.get(i));
                adjustHeap(heap, 0);
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = heap.get(i)[0];
        }
        return result;
    }

    private void adjustHeap(List<int[]> heap, int k) {
        for(int i = 2*k+1; i < heap.size(); i = 2*i+1) {
            if(i + 1 < heap.size() && heap.get(i)[1] > heap.get(i+1)[1] ) {
                i++;
            }
            if (heap.get(k)[1] > heap.get(i)[1]) {
                int[] temp = heap.get(i);
                heap.set(i, heap.get(k));
                heap.set(k, temp);
                k = i;
            } else break;
        }
    }
}