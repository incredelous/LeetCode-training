package com.company;

public class LeetCode_50 {
    /**
     * Copyright (C), 2019-2019, citi Group
     * Filename: LeetCode_50
     * Author: wyf
     * Date: 20190821 21:24
     * Description: Pow(x, n)
     * History:
     */
    public double myPow(double x, int n) {
        long ln = n;
        if(ln < 0) {
            x = 1.0 / x;
            ln = -ln;
        }
        double ret = 1.0;
        double temp = x;
        while(ln != 0) {
            long b = ln & 1;
            ln >>= 1;
            if(b > 0) {
                ret *= temp;
            }
            temp *= temp;
        }
        return ret;
    }
}
