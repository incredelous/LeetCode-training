package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trie {
/**
 * Copyright (C), 2019-2019, citi Group
 * Filename: Trie LeetCode_208
 * Author: wyf
 * Date: 20191003 13:27
 * Description: 实现Trie(前缀树)
 * History:
 *
 */
    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
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

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode now = root;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(!now.containsKey(ch)) return false;
            now = now.next[ch - 'a'];
        }
        return now.getIsEnd();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode now = root;
        for(int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if(!now.containsKey(ch)) return false;
            now = now.next[ch - 'a'];
        }
        return true;
    }

    public static void main(String[] args){
        String word = "apple";
        String prefix = "app";
        Trie obj = new Trie();
        obj.insert(word);
        boolean param_2 = obj.search(word);
        boolean param_3 = obj.startsWith(prefix);
    }
}
