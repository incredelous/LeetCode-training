package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode_17 {
    Map<String, String> map = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};
    ArrayList ret = new ArrayList();

    public void iterate(String combination, String next_digits) {
        if(next_digits.length() == 0) {
            ret.add(combination);
        } else {
            String num = next_digits.substring(0, 1);
            String letters = map.get(num);
            for(int i = 0; i < letters.length(); i++) {
                combination += letters.substring(i, i + 1);
                iterate(combination, next_digits.substring(1));
                combination = combination.substring(0, combination.length() - 1);
            }
        }
    }

    public List<String> letterCombinations(String digits) {
        if(digits.length() != 0) {
            iterate("", digits);
        }
        return ret;
    }
}
