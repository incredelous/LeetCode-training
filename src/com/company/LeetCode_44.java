package com.company;

public class LeetCode_44 {
    /**
     * Copyright (C), 2019-2019, citi Group
     * Filename: LeetCode_44
     * Author: wyf
     * Date: 20190818 15:53
     * Description: 通配符匹配
     * History:
     */
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] state = new boolean[m + 1][n + 1];
        state[0][0] = true;
        for(int i = 1; i <= n; i++) {
            state[0][i] = state[0][i - 1] && p.charAt(i - 1) == '*';
        }
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    state[i][j] = state[i - 1][j - 1];
                }
                if(p.charAt(j - 1) == '*') {
                    state[i][j] = state[i - 1][j] || state[i][j - 1];
                }
            }
        }
        return state[m][n];
    }
}
