package com.company;

import java.util.Stack;

public class LeetCode_43 {
    /**
     * Copyright (C), 2019-2019, citi Group
     * Filename: LeetCode_43
     * Author: wyf
     * Date: 20190816 23:50
     * Description: 字符串相乘
     * History:
     * 1. 平行乘法
     */

    public String add(String num1, String num2) {
        Stack<Integer> ret = new Stack<>();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int cn = 0;
        while(i >= 0 || j >= 0) {
            int a = Integer.parseInt(i >= 0 ? num1.substring(i, i + 1) : "0");
            int b = Integer.parseInt(j >= 0 ? num2.substring(j, j + 1) : "0");
            int t = a + b + cn;
            ret.push((t % 10));
            cn = t / 10;
            i--;
            j--;
        }
        if(cn == 1) {
            ret.push(1);
        }
        StringBuilder ret_sb = new StringBuilder();
        while(!ret.empty()) {
            ret_sb.append(ret.pop());
        }
        return ret_sb.toString();
    }

    public String multiply(String num1, String num2) {
        if(num1.length() == 0 || num2.length() == 0) {
            return "";
        }
        int cn = 0;
        String v = "0";
        for(int i = num2.length() - 1; i >= 0; i--) {
            Stack<Integer> temp = new Stack<Integer>();
            cn = 0;
            for(int j = num1.length() - 1; j >= 0; j--) {
                int a = Integer.parseInt(num2.substring(i, i + 1));
                int b = Integer.parseInt(num1.substring(j, j + 1));
                int t = a * b + cn;
                temp.push(t % 10);
                cn = t / 10;
            }
            if(cn > 0) {
                temp.push(cn);
            }
            StringBuilder temp_sb = new StringBuilder();
            while(!temp.empty()) {
                temp_sb.append(temp.pop());
            }
            int k = num2.length() - i - 1;
            while(k-- > 0) {
                temp_sb.append(0);
            }
            v = add(temp_sb.toString(), v);
        }
        int count_zero = 0;
        for(int i = 0; i < v.length(); i++) {
            if(v.charAt(i) == '0') {
                count_zero++;
            } else {
                break;
            }
        }
        v = v.substring(count_zero);
        if(v.length() == 0) {
            return "0";
        }
        return v;
    }
}
