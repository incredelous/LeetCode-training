package com.company;

public class LeetCode_38 {
    //报数
    public String countAndSay(int n) {
        StringBuilder rb = new StringBuilder();
        int i = 1;
        rb.append(1);
        while(i < n) {
            String ret = rb.toString();
            rb = new StringBuilder();
            int j = 1;
            int last = 0;
            while(j < ret.length()) {
                if(ret.charAt(j) == ret.charAt(last)) {
                } else {
                    rb.append(j - last);
                    rb.append(ret.charAt(last));
                    last = j;
                }
                j++;
            }
            rb.append(j - last);
            rb.append(ret.charAt(last));
            i++;
        }
        return rb.toString();
    }
}
