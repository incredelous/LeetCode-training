package com.company;

import java.util.Stack;

public class LeetCode_67 {
/**
 * Copyright (C), 2019-2019, citi Group
 * Filename: LeetCode_67
 * Author: wyf
 * Date: 20190910 21:34
 * Description: 二进制求和
 * History:
 *
 */

    public String addBinary(String a, String b) {
        Stack<Integer> stack = new Stack<>();
        int i = a.length() - 1, j = b.length() - 1;
        int carry = 0;
        int left = 0, right = 0;
        while(i >= 0 || j >= 0){
            left = i >= 0 ? (int)a.charAt(i) - 48 : 0;
            right = j >= 0 ? (int)b.charAt(j) - 48 : 0;
            stack.push((left + right + carry) % 2);
            carry = (left + right + carry) / 2;
            i--;j--;
        }
        if(carry > 0){ stack.push(1);}
        StringBuilder sb = new StringBuilder();
        while(!stack.empty()){sb.append(stack.pop());}
        return sb.toString();
    }
}

