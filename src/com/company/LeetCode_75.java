package com.company;

public class LeetCode_75 {
/**
 * Copyright (C), 2019-2019, citi Group
 * Filename: LeetCode_75
 * Author: wyf
 * Date: 20190922 21:41
 * Description: 颜色分类
 * History:
 *
 */
public void sortColors(int[] nums) {
    int boundary1 = 0, boundary2 = nums.length - 1;
    int curr = 0;
    while(curr <= boundary2){
        if(nums[curr] == 0){
            swap(nums, curr, boundary1);
            boundary1++;
            curr++;
        }
        else if(nums[curr] == 2){
            swap(nums, curr, boundary2);
            boundary2--;
        }
        else curr++;
    }
}

public void swap(int[] nums, int i, int j){
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
}
}
