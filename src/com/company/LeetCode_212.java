package com.company;

import java.util.*;

public class LeetCode_212 {
/**
 * Copyright (C), 2019-2019, citi Group
 * Filename: LeetCode_212
 * Author: wyf
 * Date: 20191001 22:52
 * Description: 单词搜索II
 * History:
 *
 */
Map<Character, List> pos_mat = new HashMap<>();
List prefix_list = new ArrayList();
    public boolean isNeighbor(int[] now,int[] next){
        if(Math.abs(now[0] - next[0]) == 1 && now[1] == next[1] ) return true;
        else if(Math.abs(now[1] - next[1]) == 1 && now[0] == next[0] ) return true;
        else return false;
    }
    public boolean Search(String word, int cur, int[] now_pos, List<int[]> tmp, boolean search_prefix){
        boolean status = false;
        if(cur >= word.length()) {
            if(search_prefix) prefix_list.add(new ArrayList<int[]>(tmp));
            return true;
        }
        else{
            char now_val = word.charAt(cur);
            if(pos_mat.containsKey(now_val)){
                for(int i = 0; i < pos_mat.get(now_val).size(); i++) {
                    int[] pos = (int[])pos_mat.get(now_val).get(i);
                    if(tmp.contains(pos)) continue;
                    if(cur == 0 || isNeighbor(now_pos, pos)) {
                        tmp.add(pos);
                        status = Search(word, cur+1, pos, tmp, search_prefix) || status;
                        tmp.remove(pos);
                    }
                    else status = status || false;
                }
            }
            else return false;
        }
        return status;
    }
    public String findCommonPrefix(String[] words){
        if(words.length == 1) return "";
        StringBuilder sb = new StringBuilder();
        int length = words[0].length();
        for(int i = 0; i < length; i++) {
            char c = words[0].charAt(i);
            for(int j = 1; j < words.length; j++) {
                if(i >= words[j].length() || words[j].charAt(i) != c) return sb.toString();
            }
            sb.append(c);
        }
        return sb.toString();
    }

public List<String> findWords(char[][] board, String[] words) {
    if(words.length == 0) return new ArrayList<>();
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
    List<String> rets = new ArrayList<>();
    String prefix = findCommonPrefix(words);
    if(prefix.length() == 0){
        for(int i = 0; i < words.length; i++) {
            if(Search(words[i], 0, new int[]{-1, -1}, new ArrayList<>(), false)) rets.add(words[i]);
        }
        return rets;
    }
    boolean prefix_ret = Search(prefix, 0, new int[]{-1, -1}, new ArrayList<>(), true);
    if(!prefix_ret) return rets;
    for(int i = 0; i < words.length; i++) {
        for(int j = 0; j < prefix_list.size(); j++) {
            List<int[]> pre_list = new ArrayList<>((List<int[]>)prefix_list.get(j));
            if(Search(words[i], prefix.length(), pre_list.get(pre_list.size() - 1), pre_list, false)) {
                rets.add(words[i]);
                break;
            }
        }
    }
    return rets;
}
}
