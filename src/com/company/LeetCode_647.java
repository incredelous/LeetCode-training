package com.company;

public class LeetCode_647 {
    public int countSubstrings(String s) {
        int num = 0;
        for(int i = 0; i < s.length(); i++){
            for(int j = 0;j < 2; j++){
                int l = i;
                int r = i + j;
                while(l >= 0 && r < s.length() && s.charAt(l--) == s.charAt(r++)) num++;
            }
        }
        return num;
    }
}
