package com.company;

public class LeetCode_464 {
    //我能赢吗(不放回)
    //解答错误
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if(desiredTotal == 0) {
            return true;
        } else return desiredTotal % (maxChoosableInteger + 1) != 0;
    }
}
