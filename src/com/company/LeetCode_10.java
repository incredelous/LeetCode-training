package com.company;

public class LeetCode_10 {
    //正则表达式匹配
    enum Result{
        True,
        False
    }
    Result[][] states;
    public boolean dp(int i, int j, String text, String pattern){
        if(states[i][j] != null){ return states[i][j] == Result.True; }
        boolean ans;
        if(j == pattern.length()){
            ans = i == text.length();
        }
        else{
            boolean firstMatch = (i < text.length()) && ((text.charAt(i) == pattern.charAt(j))||(pattern.charAt(j) == '.'));
            if(j+1 < pattern.length() && pattern.charAt(j+1) == '*'){
                ans = dp(i, j+2, text, pattern) ||
                        (firstMatch && dp(i+1, j, text, pattern));
            }
            else{
                ans = firstMatch && dp(i+1, j+1, text, pattern);
            }
        }
        states[i][j] = ans ? Result.True : Result.False;
        return ans;
    }

    public boolean isMatch(String s, String p) {
        states = new Result[s.length()+1][p.length()+1];
        return dp(0, 0, s, p);
    }
}
