package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode_22 {
    //括号生成
    List<String> ret = new ArrayList<>();
    int brackets_pair;

    public boolean isValidFormat(StringBuilder bracketStr) {
        Stack stack = new Stack();
        for(int i = 0; i < bracketStr.length(); i++) {
            if(bracketStr.charAt(i) == '(') {
                stack.push('(');
            } else {
                if(stack.empty()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.empty();
    }

    public void backTrace(StringBuilder bracketStr, int n, int left_bracket, int right_bracket) {
        if(n == 0) {
            if(left_bracket == right_bracket && isValidFormat(bracketStr)) {
                ret.add(bracketStr.toString());
                return;
            }
        } else {
            for(int i = 0; i < 2; i++) {
                if(i == 0 && left_bracket < brackets_pair) {
                    bracketStr.append('(');
                    backTrace(bracketStr, n - 1, left_bracket + 1, right_bracket);
                    bracketStr.deleteCharAt(bracketStr.length() - 1);
                } else if(i == 1 && right_bracket < brackets_pair) {
                    bracketStr.append(')');
                    backTrace(bracketStr, n - 1, left_bracket, right_bracket + 1);
                    bracketStr.deleteCharAt(bracketStr.length() - 1);
                }
            }
        }
        return;
    }

    public List<String> generateParenthesis(int n) {
        StringBuilder bracketStr = new StringBuilder();
        bracketStr.append('(');
        brackets_pair = n;
        backTrace(bracketStr, 2 * n - 1, 1, 0);
        return ret;
    }
}
