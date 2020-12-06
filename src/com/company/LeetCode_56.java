package com.company;

import java.util.*;

public class LeetCode_56 {
/**
 * Copyright (C), 2019-2019, citi Group
 * Filename: LeetCode_56
 * Author: wyf
 * Date: 20190902 22:30
 * Description: 合并区间
 * History:
 *
 */
    private class IntervalComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] a, int[] b) {
            return a[0] < b[0] ? -1 : a[0] == b[0] ? 0 : 1;
        }
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new IntervalComparator());
        LinkedList<int[]> merged = new LinkedList<int[]>();
        for(int i = 0; i < intervals.length; i++) {
            if(merged.isEmpty() || merged.getLast()[1] < intervals[i][0]) merged.add(intervals[i]);
            else{
                merged.getLast()[1] = Math.max(merged.getLast()[1], intervals[i][1]);
            }
        }
        int[][] ret = new int[merged.size()][2];
        for(int i = 0; i < merged.size(); i++) ret[i] = merged.get(i);
        return ret;
    }
}
