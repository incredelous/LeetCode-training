package com.company;

public class LeetCode_287 {
    public int findDuplicate(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            while(true){
                if(i != nums[i] - 1){
                    if(nums[nums[i] - 1] == nums[i]) return nums[i];
                    else{
                        int temp = nums[i];
                        nums[i] = nums[temp - 1];
                        nums[temp - 1] = temp;
                    }
                }
                else break;
            }
        }
        return 0;
    }
}
