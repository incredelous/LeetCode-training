package com.company;

public class LeetCode_12 {
    //整数转罗马数字
    public String intToRoman(int num) {
        String roman = "";
        while(num != 0) {
            if(num / 1000 != 0) {
                roman += 'M';
                num -= 1000;
            } else if(num / 500 != 0) {
                if(num / 900 != 0) {
                    roman += "CM";
                    num -= 900;
                } else {
                    roman += 'D';
                    num -= 500;
                }
            } else if(num / 100 != 0) {
                if(num / 400 != 0) {
                    roman += "CD";
                    num -= 400;
                } else {
                    roman += 'C';
                    num -= 100;
                }
            } else if(num / 50 != 0) {
                if(num / 90 != 0) {
                    roman += "XC";
                    num -= 90;
                } else {
                    roman += 'L';
                    num -= 50;
                }
            } else if(num / 10 != 0) {
                if(num / 40 != 0) {
                    roman += "XL";
                    num -= 40;
                } else {
                    roman += 'X';
                    num -= 10;
                }
            } else if(num / 5 != 0) {
                if(num / 9 != 0) {
                    roman += "IX";
                    num -= 9;
                } else {
                    roman += 'V';
                    num -= 5;
                }
            } else if(num / 1 != 0) {
                if(num / 4 != 0) {
                    roman += "IV";
                    num -= 4;
                } else {
                    roman += 'I';
                    num -= 1;
                }
            }
        }
        return roman;
    }
}
