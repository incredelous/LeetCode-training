package com.company;

import java.util.Scanner;

public class LeetCode_717 {
    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        boolean result = false;
        while(i < bits.length) {
            if(i == bits.length - 1 && bits[i] == 0) {
                result = true;
                break;
            }
            if(bits[i] == 1) {
                i = i + 2;
            } else {
                i++;
            }
        }
        return result;
    }

    public int[] getArr() {
        Scanner scan = new Scanner(System.in);
        String arrayStr = scan.nextLine().split("=")[1];
        int arrayLen = arrayStr.split(",").length;
        int[] bits = new int[arrayLen];
        int j = 0;
        for(int i = 0; i < arrayStr.length(); i++) {
            if(arrayStr.charAt(i) == '1' || arrayStr.charAt(i) == '0') {
                bits[j] = arrayStr.charAt(i) - '0';
                j++;
            }
        }
        return bits;
    }
}
