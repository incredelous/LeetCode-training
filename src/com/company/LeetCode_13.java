package com.company;

public class LeetCode_13 {
    //罗马数字转整数
    public int romanToInt(String s) {
        int[] num_indexs = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman_indexs = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        int i = 0;
        int num = 0;
        while(i < s.length()) {
            for(int j = 0; j < roman_indexs.length; j++) {
                if(roman_indexs[j].length() == 1 && roman_indexs[j].equals(String.valueOf(s.charAt(i)))) {
                    num += num_indexs[j];
                    i++;
                    break;
                } else if(roman_indexs[j].length() == 2 && roman_indexs[j].equals(s.substring(i, i + 2 >= s.length() ? s.length() : i + 2))) {
                    num += num_indexs[j];
                    i += 2;
                    break;
                }
            }
        }
        return num;
    }
}
