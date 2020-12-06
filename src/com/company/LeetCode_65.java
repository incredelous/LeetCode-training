package com.company;

public class LeetCode_65 {
/**
 * Copyright (C), 2019-2019, citi Group
 * Filename: LeetCode_65
 * Author: wyf
 * Date: 20190909 22:37
 * Description: 有效数字
 * History:
 *
 */

char[] valid_char = new char[]{'0', '1', '2', '3','4', '5', '6', '7', '8', '9', 'e', '+', '-', '.', ' '};

public int isValid(char c){
    for(int i = 0; i < valid_char.length; i++) {
        if(c == valid_char[i]) return i;
    }
    return -1;
}

public boolean isNumber(String s) {
    /*
    0: start
    1: start space
    2: symbol
    3: number
    4: dot
    5: e
    6: space
    7: end
     */
    int status = 0;
    int pos = -1;
    for(int i = 0; i < s.length(); i++) {
        pos = isValid(s.charAt(i));
        if(pos < 0){ return false;}
        else{
            if(pos < 10){
                if(status <= 3) status = Math.max(status, 3);
                else if(status <= 5) status = Math.max(status, 6);
                else if(status == 6) ;
                else return false;
            }
            else if(pos == 10){
                if(status < 5){
                    if(i > 0 && isValid(s.charAt(i-1)) < 10) status = Math.max(status, 5);
                    else return false;
                }
                else return false;
            }
            else if(pos == 11 || pos == 12){
                if(status < 2){ status = Math.max(status, 2); }
                else if(status == 5){ if(i > 0 && isValid(s.charAt(i-1)) == 10) status = Math.max(status, 2);}
                else return false;
            }
            else if(pos == 13){
                if(status < 4){
                    if(i == 0) status = 4;
                    else if(i > 0 && isValid(s.charAt(i-1)) < 10) status = Math.max(status, 4);
                    else return false;
                }
                else return false;
            }
            else{
                if(status <= 1){ status = Math.max(status, 1); }
                else if(status >= 3){ status = Math.max(status, 7); }
                else return false;
            }
        }
    }
    if(status > 2) return true;
    else return false;
}

    public static void main(String[] args) {

        String[] test = new String[]{"", " - ", "+", "1 a 0", "3 1", "1.2.3", "1e2e3", "1e+3",
                "4.", ".1", "4e3.4", "-2", "+3", "1234", "2-", "3+",
                "0", " 0.1 ", "abc", "2e10", " -90e3   ", " 1e", "e3", " 6e-1",
                " 99e2.5 ", "53.5e93", " --6 ", "-+3", "95a54e53", ".", "e", " ", "6e ", "   . "};
        for(int i = 0; i < test.length; i++) {
            System.out.println(test[i] + '\t' + new LeetCode_65().isNumber(test[i]));
        }
    }
}
