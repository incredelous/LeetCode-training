package com.company;

public class TrieNode {
/**
 * Copyright (C), 2019-2019, citi Group
 * Filename: TrieNode
 * Author: wyf
 * Date: 20191004 0:29
 * Description: TrieNode
 * History:
 *
 */
    private boolean isEnd;
    TrieNode[] next = new TrieNode[26];

    public void TrieNode(){}

    public void put(char ch, TrieNode node){
        next[ch - 'a'] = node;
    }

    public boolean containsKey(char ch){
        return next[ch - 'a'] != null;
    }

    public void setEnd(){
        isEnd = true;
    }

    public boolean getIsEnd(){
        return isEnd;
    }
}
