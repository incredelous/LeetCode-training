package com.company;

import java.util.Stack;

public class LeetCode_32 {
    //最长有效括号
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);
        int longest_path = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if(stack.empty()) {
                    stack.push(i);
                }
                /*防止栈为空，导致peek()函数出错；
                  通过pop和push函数保证栈中至少有一个元素；
                  不会出现单一的')'被算到有效字符串中的情况，因为每次pop和push操作会更新')'字符的索引
                */
                int dist = i - stack.peek();// 当前元素与栈弹出元素后的栈顶元素做差
                /*不能与栈顶元素直接做差，无法解决()()的问题*/
                if(dist > longest_path) {
                    longest_path = dist;
                }
            }
        }
        return longest_path;
    }

//    public boolean isValidSequence(String s){
//        List<Character> stack = new ArrayList<Character>();
//        for (int i = 0; i < s.length(); i++) {
//            if(stack.size() == 0 && s.charAt(i) == ')'){ return false;}
//            if(stack.size() > s.length() / 2){ return false; }
//            if(stack.size() > 0 && s.charAt(i) == ')'){ stack.remove(stack.size()-1);}
//            else{ stack.add(s.charAt(i)); }
//        }
//        return stack.size() == 0 ? true : false;
//    }
}
