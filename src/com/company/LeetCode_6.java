package com.company;

import java.util.ArrayList;
import java.util.List;


public class LeetCode_6 {
    //Z字形变换
    public String convert(String s, int numRows) {
        if(numRows == 1) {
            return s;
        }
        List<StringBuilder> rows = new ArrayList<>();
        for(int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }
        int curRow = 0;
        boolean goDown = true;
        for(int i = 0; i < s.length(); i++) {
            rows.get(curRow).append(s.charAt(i));
            curRow += goDown ? 1 : -1;
            if(curRow == 0 || curRow == numRows - 1) {
                goDown = !goDown;
            }
        }
        StringBuilder ret = new StringBuilder();
        for(StringBuilder row : rows) {
            ret.append(row);
        }
        return ret.toString();
    }
}
