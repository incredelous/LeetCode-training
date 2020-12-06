package com.company;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_77 {
/**
 * Copyright (C), 2019-2019, citi Group
 * Filename: LeetCode_77
 * Author: wyf
 * Date: 20190929 19:58
 * Description: 组合
 * History:
 *
 */
List ret = new ArrayList();
int nn;
int kk;
public void Search(List<Integer> tmp, int pos, int last){
    if(pos >= kk){ ret.add(tmp.toArray());}
    else{
        for(int i = last+1; i <= nn; i++) {
            tmp.add(i);
            Search(tmp, pos+1, i);
            tmp.remove(pos);
        }
    }
}
public List<List<Integer>> combine(int n, int k) {
    nn = n;
    kk = k;
    List<Integer> tmp = new ArrayList<>();
    Search(tmp, 0, 0);
    return ret;
}

}
