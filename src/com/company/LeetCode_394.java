package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode_394 {

    public String decodeString(String s){
        List<String> stack = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch >= 'a' && ch <= 'z'){
                stack.add(String.valueOf(ch));
            }
            else if(ch == ']'){
                int cur = stack.size() - 1;
                while(!stack.get(cur).equals("[")){
                    cur--;
                }
                List<String> temp = new ArrayList<>(stack.subList(cur+1, stack.size()));
                int number = Integer.parseInt(stack.get(--cur));
                stack = stack.subList(0, cur);
                for(int j = 0; j < number; j++){
                    stack.addAll(List.copyOf(temp));
                    cur++;
                }
            }
            else if(ch >= '1' && ch <= '9'){
                int start = i;
                while(s.charAt(i) != '['){i++;}
                int number = Integer.parseInt(s.substring(start, i));
                stack.add(String.valueOf(number));
                stack.add(String.valueOf(s.charAt(i)));
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < stack.size(); i++){
            sb.append(stack.get(i));
        }
        return sb.toString();
    }
}
