package com.company;

public class LeetCode_84 {
/**
 * Copyright (C), 2019-2019, citi Group
 * Filename: LeetCode_84
 * Author: wyf
 * Date: 20191019 11:42
 * Description: 柱状图中最大的矩形
 * History:
 *
 */
public int caculateMaxArea(int[] heights, int start, int end){
    if(start > end) return 0;
    int minHeight = heights[start];
    int minPos = start;
    for(int i = start + 1; i <= end; i++) {
        if(heights[i] < minHeight){
            minHeight = heights[i];
            minPos = i;
        }
    }
    return Math.max( minHeight * (end - start + 1), Math.max(caculateMaxArea(heights, start, minPos-1), caculateMaxArea(heights, minPos+1, end)));
}
public int largestRectangleArea(int[] heights) {
    //分治法
    return caculateMaxArea(heights, 0, heights.length - 1);
}
}
