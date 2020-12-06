package com.company;

public class LeetCode_69 {
/**
 * Copyright (C), 2019-2019, citi Group
 * Filename: LeetCode_69
 * Author: wyf
 * Date: 20190920 22:06
 * Description: x的平方根
 * History:
 *
 */
public int mySqrt(int x) {
    int i = 1;
    while(i*i < x){
        i *= 2;
        if(i*i <= 0){ i = 46340; break;}
    }
    if(i == 46340){
        if(i * i < x) return i;
    }
    if(i * i == x) return i;
    int start = i / 2;
    int end = i;
    int mid;
    while(start < end){
        mid = (start + end) / 2;
        if(mid * mid <= x && (mid+1) * (mid+1) > x) return mid;
        else if(mid * mid > x){ end = mid; }
        else{ start = mid;}
    }
    return -1;
}
}
