package com.company;

public class WordDictionary {
/**
 * Copyright (C), 2019-2019, citi Group
 * Filename: WordDictionary LeetCode_211
 * Author: wyf
 * Date: 20191005 16:17
 * Description: 添加与搜索单词 - 数据结构设计
 * History:
 *
 */
    private TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode now = root;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(now.containsKey(ch)){
                now = now.next[ch - 'a'];
            }
            else{
                now.put(ch, new TrieNode());
                now = now.next[ch - 'a'];
            }
        }
        now.setEnd();
    }

    private boolean backTraceSearch(TrieNode now, String word, int pos){
        if(pos >= word.length()){
            return now.getIsEnd() ? true : false;
        }
        else{
            boolean flag = false;
            char ch = word.charAt(pos);
            if(ch == '.'){
                for(int i = 0; i < now.next.length; i++) {
                    if(now.next[i] != null){
                        flag = flag || backTraceSearch(now.next[i], word, pos+1);
                    }
                }
            }
            else{
                if(now.containsKey(ch)){
                    now = now.next[ch - 'a'];
                    flag = flag || backTraceSearch(now, word, pos+1);
                }
                else flag = flag || false;
            }
            return flag;
        }
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        TrieNode now = root;
        if(word.indexOf(".") >= 0) return backTraceSearch(root, word, 0);
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(now.containsKey(ch)){
                now = now.next[ch - 'a'];
            }
            else return false;
        }
        return now.getIsEnd() ? true : false;
    }
}
