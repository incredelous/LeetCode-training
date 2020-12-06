package com.company;

public class LeetCode_81 {
/**
 * Copyright (C), 2019-2019, citi Group
 * Filename: LeetCode_81
 * Author: wyf
 * Date: 20191013 17:54
 * Description: 搜索旋转排序数组II
 * History:
 *
 */
public boolean search(int[] nums, int target) {
    if(nums.length == 0) return false;
    int low = 0, high = nums.length - 1;
    while(low <= high){
        int mid = (low + high) / 2;
        if(nums[mid] == target || nums[low] == target || nums[high] == target) return true;
        else{
            if(nums[mid] > nums[low] && nums[mid] < nums[high]){
                if(nums[mid] < target) low = mid + 1;
                else high = mid - 1;
            }
            else if(nums[mid] < nums[low]){
                if(nums[low] < target || nums[mid] > target) high = mid - 1;
                else if(nums[mid] < target && nums[high] > target) low = mid + 1;
                else return false;
            }
            else if(nums[mid] > nums[high]){
                if(nums[mid] < target || nums[high] > target) low = mid + 1;
                else if(nums[mid] > target && nums[low] < target) high = mid - 1;
                else return false;
            }
            else if(nums[low] == nums[high]){
                int i;
                for(i = mid+1; i < high; i++) {
                    if(nums[i] != nums[mid]) break;
                }
                if(i == high) high = mid - 1;
                else low = mid + 1;
            }
            else if(nums[mid] == nums[low]) low = mid + 1;
            else if(nums[mid] == nums[high]) high = mid - 1;
        }
    }
    return false;
}
}
