package com.company;

public class LeetCode_60 {
/**
 * Copyright (C), 2019-2019, citi Group
 * Filename: LeetCode_60
 * Author: wyf
 * Date: 20190927 16:52
 * Description: 第k个排列
 * History:
 *
 */
int end;
int current = 0;
int num;
String ret;
public void backtrace(StringBuilder tmp){
    if(tmp.length() == num){
        if(++current >= end){ ret = tmp.toString(); return ;}
    }
    else{
        for(int i = 1; i <= num; i++) {
            if(tmp.indexOf(Integer.toString(i)) >= 0) continue;
            tmp.append(i);
            backtrace(tmp);
            if(current >= end) return ;
            tmp.deleteCharAt(tmp.length()-1);
        }
    }
    return ;
}

public String getPermutation_1(int n, int k) {
    //回溯法
    StringBuilder tmp = new StringBuilder();
    end = k;
    num = n;
    backtrace(tmp);
    return ret;
}

public String getPermutation(int n, int k) {
    StringBuilder ret = new StringBuilder();
    k = k - 1;
    int temp = 1;
    for(int i = 1; i <= n; i++) {
        temp *= i;
    }
    int pos = 0;
    int ind;
    while(pos < n){
        temp = temp / (n - pos++);
        ind = k / temp;
        int i = 0, val = 0;
        while(i <= ind){
            val++;
            if(ret.indexOf(Integer.toString(val)) >= 0) continue;
            i++;
        }
        ret.append(val);
        k = k % temp;
    }
    return ret.toString();
}
}
