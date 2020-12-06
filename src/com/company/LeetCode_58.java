package com.company;

import java.util.Stack;

public class LeetCode_58 {
/**
 * Copyright (C), 2019-2019, citi Group
 * Filename: LeetCode_58
 * Author: wyf
 * Date: 20190904 22:24
 * Description: 最后一个单词的长度
 * History:
 *
 */
public int lengthOfLastWord(String s) {
    if(s.length() == 0){ return 0;}
    int counter = 0;
    for(int i = s.length()-1; i >=0; i--) {
        if(s.charAt(i) == ' '){
            if(counter == 0) continue;
            else break;}
        else{counter++;}
    }
    return counter;
}
}
