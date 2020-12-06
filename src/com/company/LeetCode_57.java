package com.company;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class LeetCode_57 {
/**
 * Copyright (C), 2019-2019, citi Group
 * Filename: LeetCode_57
 * Author: wyf
 * Date: 20190903 23:12
 * Description: 插入区间
 * History:
 *
 */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ret = new ArrayList<int[]>();
        if(intervals.length == 0){ ret.add(newInterval); }
        int left_pos = Integer.MAX_VALUE, right_pos = Integer.MIN_VALUE;
        boolean occurs = false;
        for(int i = 0; i < intervals.length; i++) {
            if(intervals[i][1] < newInterval[0] || intervals[i][0] > newInterval[1]){
                if(intervals[i][0] > newInterval[1]){
                    if(i == 0) ret.add(newInterval);
                    else if(intervals[i-1][1] < newInterval[0]) ret.add(newInterval);
                }
                ret.add(intervals[i]);
                if(intervals[i][1] < newInterval[0]){
                    if(i == intervals.length - 1) ret.add(newInterval);
                }
            }
            else{
                if(intervals[i][1] >= newInterval[0]){
                    left_pos = Math.min(Math.min(intervals[i][0], newInterval[0]), left_pos);
                }
                if(intervals[i][0] <= newInterval[1]){
                    right_pos = Math.max(Math.max(intervals[i][1], newInterval[1]), right_pos);
                }
                if(i < intervals.length - 1){
                    if(intervals[i+1][0] > right_pos){ ret.add(new int[]{left_pos, right_pos});}
                }
                else{ ret.add(new int[]{left_pos, right_pos});}
            }
        }
        int[][] ret_d = new int[ret.size()][2];
        for(int i = 0; i < ret.size(); i++) ret_d[i] = ret.get(i);
        return ret_d;
    }

}
