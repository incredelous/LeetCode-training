package com.company;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_68 {
/**
 * Copyright (C), 2019-2019, citi Group
 * Filename: LeetCode_68
 * Author: wyf
 * Date: 20190917 21:32
 * Description: 文本左右对齐
 * History:
 *
 */
public String reFormatLeftAlignRight(String[] words, int start, int end, int whiteLeft){
    StringBuilder sb = new StringBuilder();
    int whiteNum = whiteLeft / (end - start);
    int rest = whiteLeft % (end - start);
    int count = 0;
    for(int i = start; i <= end; i++) {
        sb.append(words[i]);
        if(i < end){
            count = 0;
            while(count < whiteNum){
                sb.append(' ');
                count++;
            }
            if(rest-- > 0){ sb.append(' '); }
        }
    }
    return sb.toString();
}

public String reFormatLeftAlign(String[] words, int start, int end, int whiteLeft){
    StringBuilder sb = new StringBuilder();
    for(int i = start; i <= end; i++) {
        sb.append(words[i]);
        if(whiteLeft-- > 0) sb.append(' ');
    }
    int count = 0;
    while(count < whiteLeft){
        sb.append(' ');
        count++;
    }
    return sb.toString();
}

public List<String> fullJustify(String[] words, int maxWidth) {
    List<String> ret = new ArrayList<String>();
    int cur = 0;
    int start = 0;
    int whiteSpace = 0;
    for(int i = 0; i < words.length; i++) {
        if(cur + words[i].length() <= maxWidth){
            cur += words[i].length() + 1;
            if(cur <= maxWidth) whiteSpace += 1;
            else cur--;
        }
        else{
            if(i - start == 1) ret.add(reFormatLeftAlign(words, start, i-1, maxWidth-cur+whiteSpace));
            else{
                ret.add(reFormatLeftAlignRight(words, start, i-1, maxWidth-cur+whiteSpace));
            }
            start = i;
            whiteSpace = 0;
            cur = words[i].length() + 1;
            if(cur <= maxWidth) whiteSpace += 1;
            else cur--;
        }
    }
    ret.add(reFormatLeftAlign(words, start, words.length-1, maxWidth-cur+whiteSpace));
    return ret;
}
}
