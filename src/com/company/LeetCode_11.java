package com.company;

public class LeetCode_11 {
    //盛最多水的容器
    public int maxArea(int[] height) {
        if(height.length == 2) {
            return height[0] > height[1] ? height[1] : height[0];
        }
        int i = 0;
        int j = height.length - 1;
        int max_capcity = 0;
        while(i < j) {
            if(height[i] > height[j]) {
                max_capcity = height[j] * (j - i) > max_capcity ? height[j] * (j - i) : max_capcity;
                j--;
            } else {
                max_capcity = height[i] * (j - i) > max_capcity ? height[i] * (j - i) : max_capcity;
                i++;
            }
        }
        return max_capcity;
    }
}
