package com.company;

import java.util.Stack;

public class LeetCode_739 {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++){
            if(stack.empty() || temperatures[i] <= temperatures[stack.peek()]){
                stack.push(i);
            }
            else{
                while(!stack.empty() && temperatures[i] > temperatures[stack.peek()]){
                    int temp = stack.pop();
                    ans[temp] = i - temp;
                }
                stack.push(i);
            }
        }
        return ans;
    }
}
