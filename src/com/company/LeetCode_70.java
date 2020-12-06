package com.company;

public class LeetCode_70 {
    //爬楼梯
    public int climbStairs(int n) {
        int[] temp = new int[n + 1];
        if(n == 1) {
            return 1;
        } else if(n == 2) {
            return 2;
        } else {
            temp[1] = 1;
            temp[2] = 2;
            for(int i = 3; i <= n; i++) {
                temp[i] = temp[i - 1] + temp[i - 2];
            }
            return temp[n];
        }

    }
}
