package com.company;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> results = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            int curr = i;
            while(curr + 1 != nums[curr]){
                int temp = nums[nums[curr] - 1];
                nums[nums[curr] - 1] = nums[curr];
                if(temp == nums[curr]) break;
                nums[curr] = temp;
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(i + 1 != nums[i]) results.add(i+1);
        }
        return results;
    }
}
