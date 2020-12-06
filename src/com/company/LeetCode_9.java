package com.company;

public class LeetCode_9 {
    //回文数
    public boolean isPalindrome_1(int x) {
        if(x < 0) {
            return false;
        } else {
            String str = String.valueOf(x);
            int i = 0;
            int j = str.length() - 1;
            while(j > i) {
                if(str.charAt(i) != str.charAt(j)) {
                    return false;
                }
                j--;
                i++;
            }
            return true;
        }
    }

    public boolean isPalindrome_2(int x) {
        if(x < 0) {
            return false;
        } else {
            int temp = x;
            int counter = 0;
            do {
                temp /= 10;
                counter++;
            } while(temp != 0);
            int i = 0;
            int j = counter;
            boolean res = false;
            while(j > i) {
                int left = x / ((int) Math.pow(10, j - 1));
                int right = x % (10 ^ i);
                if(left != right) {
                    break;
                }
                j--;
                i++;
            }
            if(j < i) {
                res = true;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome_3(11122111));
    }

    public static boolean isPalindrome_3(int x) {
        if(x < 0) return false;
        int cur = x;
        int bit = 0;
        while(cur > 0) {
            bit++;
            cur /= 10;
        }
        int temp = 1;
        for(int i = 1; i < bit; i++) {
            temp *= 10;
        }
        int highNum = x;
        int lowNum = x;
        for(int i = 0; i < bit / 2; i++) {
            int top = highNum / temp;
            int down = lowNum - lowNum / 10 * 10;

            if(top != down) return false;
            highNum = highNum - top * temp;
            lowNum = lowNum / 10;
            temp /= 10;
        }
        return true;
    }
}
