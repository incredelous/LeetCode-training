package com.company;

public class LeetCode_5 {
    //最长回文子串
    public String longestPalindrome(String s) {
        if(s.length() <= 1) {
            return s;
        }
        boolean[][] state = new boolean[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++) {
            state[i][i] = true;
        }
        int[] result = new int[2];
        int length = 1;
        for(int j = 1; j < s.length(); j++) {
            for(int i = 0; i < j; i++) {
                if(j == i + 1 || j == i + 2) {
                    state[i][j] = true && s.charAt(i) == s.charAt(j);
                } else {
                    if(s.charAt(i) == s.charAt(j)) {
                        state[i][j] = state[i + 1][j - 1];
                    } else {
                        state[i][j] = false;
                    }
                }
                if(j - i + 1 > length && state[i][j] == true) {
                    length = j - i + 1;
                    result[0] = i;
                    result[1] = j;
                }

            }
        }
        return s.substring(result[0], result[1] + 1);
    }
}
