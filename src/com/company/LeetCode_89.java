package com.company;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_89 {
    public List<Integer> grayCode_1(int n) {
        // 动态规划
        List<Integer> arr = new ArrayList<>();
        arr.add(0);
        for(int i = 0; i < n; i++) {
            int add = 1 << i;
            for(int j = arr.size() - 1; j >= 0; j--) {
                arr.add(arr.get(j) + add);
            }
        }
        return arr;
    }

    public List<Integer> grayCode_2(int n) {
        //直接推导
        List<Integer> arr = new ArrayList<>();
        arr.add(0);
        for(int i = 1; i < 1 << n; i++) {
            int previous = arr.get(i - 1);
            if(i % 2 == 1) {
                previous ^= 1;
                arr.add(previous);
            } else {
                int j = 1;
                int counter = 0;
                while((j & previous) == 0) {
                    j = j << 1;
                    counter++;
                }
                previous ^= (1 << (counter + 1));
                arr.add(previous);
            }
        }
        return arr;
    }
}
