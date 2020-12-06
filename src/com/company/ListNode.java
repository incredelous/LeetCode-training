package com.company;

//Definition for singly-linked list.
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public String toString() {
        ListNode now = this;
        StringBuilder str = new StringBuilder();
        while(now != null) {
            str.append(now.val);
            if(now.next != null) {
                str.append("->");
            }
            now = now.next;
        }
        return str.toString();
    }
}
