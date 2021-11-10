package com.company;

public class LeetCode_397 {
    public int integerReplacement(int n) {
        return dfs(n);
    }

    public int dfs(int n){
        if(n == 1) return 0;
        if(n % 2 == 0) return 1 + dfs(n / 2);
        else return 1 + Math.min(dfs(n+1), dfs(n-1));
    }
}
