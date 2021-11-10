package com.company;

import java.util.Deque;
import java.util.LinkedList;

public class LeetCode_239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0) return null;
        Deque<Integer> deque = new LinkedList<>();
        for(int i = 0; i < k; i++){
            while(!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offer(i);
        }
        int n = nums.length - k + 1;
        int[] ans = new int[n];
        ans[0] = nums[deque.peekFirst()];
        for(int i = k; i < nums.length; i++){
            while(!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offer(i);
            if(deque.peekFirst() <= i - k){
                deque.pollFirst();
            }
            ans[i-k+1] = nums[deque.peekFirst()];
        }
        return ans;
    }
}
