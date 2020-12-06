package com.company;

public class LeetCode_29 {
    //两数相除

    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        int flag = 0;
        if(dividend >> 31 == divisor >> 31) {
            flag = 1;
        }
        long ldivided = Math.abs((long) dividend);
        long ldivisior = Math.abs((long) divisor);
        int counter = 0;
        while(ldivided >= ldivisior) {
            counter++;
            ldivisior <<= 1;
        }
        int ret = 0;
        while(counter > 0) {
            counter--;
            ldivisior >>= 1;
            if(ldivided >= ldivisior) {
                ret += 1 << counter;
                ldivided -= ldivisior;
            }
        }
        if(flag == 0) {
            ret = -ret;
        }
        return -(1 << 31) <= ret && ret <= (1 << 31) - 1 ? ret : (1 << 31) - 1;
    }
}
