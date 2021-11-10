package com.company;

import java.util.ArrayList;
import java.util.List;

public class Zhijiang_1 {
/**
 * Copyright (C), 2019-2021, citi Group
 * Filename: Zhijiang_1
 * Author: wyf
 * Date: 20210513 21:30
 * Description: 
 * History:
 *
 */
    public void getZeroOneNumber(int k){
        List<Integer> intList = new ArrayList<>();
        if(k == 1) System.out.print(0);
        else{
            k--;
            while(k != 0){
                int byteInt = k & 1;
                k = k >> 1;
                intList.add(byteInt);
            }
            for(int i = intList.size() - 1; i >= 0; i--){
                System.out.print(intList.get(i));
            }

        }
    }

}
