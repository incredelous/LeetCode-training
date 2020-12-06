package com.company;

public class LeetCode_7 {
    //整数反转
    public int reverse(int x) {
        int result = 0;
        if(x / 10 == 0) {
            return x;
        }
        do {
            int temp = x % 10;
            if(result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && temp > 7)) return 0;
            if(result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && temp < -8)) return 0;
            result *= 10;
            result += temp;
            x /= 10;
        } while(x != 0);
        return result;
    }
}
