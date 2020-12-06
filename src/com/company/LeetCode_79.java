package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode_79 {
/**
 * Copyright (C), 2019-2019, citi Group
 * Filename: LeetCode_79
 * Author: wyf
 * Date: 20190929 21:30
 * Description: 单词搜索
 * History:
 *
 */
Map<Character, List> pos_mat = new HashMap<>();
public boolean isNeighbor(int[] now,int[] next){
    if(Math.abs(now[0] - next[0]) == 1 && now[1] == next[1] ) return true;
    else if(Math.abs(now[1] - next[1]) == 1 && now[0] == next[0] ) return true;
    else return false;
}
public boolean Search(String word, int cur, int[] now_pos, List<int[]> tmp){
    boolean status = false;
    if(cur >= word.length()) return true;
    else{
        char now_val = word.charAt(cur);
        if(pos_mat.containsKey(now_val)){
            for(int i = 0; i < pos_mat.get(now_val).size(); i++) {
                int[] pos = (int[])pos_mat.get(now_val).get(i);
                if(tmp.contains(pos)) continue;
                if(cur == 0 || isNeighbor(now_pos, pos)) {
                    tmp.add(pos);
                    status = status || Search(word, cur+1, pos, tmp);
                    if(status) return status;
                    tmp.remove(pos);
                }
                else status = status || false;
            }
        }
        else return false;
    }
    return status;
}

public boolean exist(char[][] board, String word) {
    if(word.length() == 0) return true;
    for(int i = 0; i < board.length; i++) {
        for(int j = 0; j < board[0].length; j++) {
            if(pos_mat.containsKey(board[i][j])){
                pos_mat.get(board[i][j]).add(new int[]{i,j});
            }
            else{
                pos_mat.put(board[i][j], new ArrayList());
                pos_mat.get(board[i][j]).add(new int[]{i,j});
            }
        }
    }
    return Search(word, 0, new int[]{-1, -1}, new ArrayList<int[]>());
}
}
