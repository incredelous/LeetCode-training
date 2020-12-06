package com.company;

import java.util.Arrays;

public class LeetCode_42 {
    /**
     * Copyright (C), 2019-2019, citi Group
     * Filename: LeetCode_42
     * Author: wyf
     * Date: 20190811 20190811
     * Description: 接雨水
     * History:
     */

    public int calcWater(int[] array) {
        int left = 0, cv = 0, v = 0;
        for(int i = 1; i < array.length; i++) {
            if(array[i] >= array[left]) {
                v += (i - left - 1) * array[left] - cv;
                left = i;
                cv = 0;
            } else {
                cv += array[i];
            }
        }
        return v;
    }

    public int trap(int[] height) {
        /**
         * @Description:
         * 题解见：
         * https://leetcode-cn.com/problems/trapping-rain-water/solution/yu-tian-di-lun-yu-hou-shui-shen-by-user8973/
         * @params:
         * @return:
         */


        if(height.length < 1) {
            return 0;
        }
        int max_value = Integer.MIN_VALUE;
        int index = -1;
        for(int i = 0; i < height.length; i++) {
            if(height[i] > max_value) {
                max_value = height[i];
                index = i;
            }
        }
        int[] l_array = Arrays.copyOfRange(height, 0, index + 1);
        int[] r_array = new int[height.length - index + 1];
        r_array[0] = 0;
        int counter = 1;
        for(int i = height.length - 1; i >= index; i--) {
            r_array[counter++] = height[i];
        }
        return calcWater(l_array) + calcWater(r_array);
    }
}
