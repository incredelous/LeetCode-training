package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.List;

public class LeetCode_71 {
/**
 * Copyright (C), 2019-2019, citi Group
 * Filename: LeetCode_71
 * Author: wyf
 * Date: 20190920 22:55
 * Description: 简化路径
 * History:
 *
 */
public String simplifyPath(String path) {
    String[] filenames = path.split("/");
    List<String> ret = new ArrayList<>();
    for(int i = 0; i < filenames.length; i++) {
        if(filenames[i].equals(".") || filenames[i].equals("")) continue;
        else if(filenames[i].equals(".."))
            if(ret.size() > 0) ret.remove(ret.size() - 1);
        else ret.add(filenames[i]);
    }
    StringBuilder ret_sb = new StringBuilder();
    if(ret.size() == 0) return "/";
    for(int i = 0; i < ret.size(); i++) {
        ret_sb.append("/");
        ret_sb.append(ret.get(i));
    }
    return ret_sb.toString();
}
}
