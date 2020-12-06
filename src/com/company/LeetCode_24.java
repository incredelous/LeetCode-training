package com.company;

public class LeetCode_24 {
    //两两交换链表中的节点
    public ListNode swapPairs(ListNode head) {
        ListNode p1 = head;
        if(p1 == null) {
            return p1;
        }
        ListNode p2 = head.next;
        if(p2 == null) {
            return p1;
        }
        ListNode ret = p2;
        p1.next = p2.next;
        p2.next = p1;
        ListNode last = p1;
        p1 = p1.next;
        if(p1 != null) {
            p2 = p1.next;
        }
        while(p1 != null && p2 != null) {
            last.next = p2;
            p1.next = p2.next;
            p2.next = p1;
            last = p1;
            p1 = p1.next;
            if(p1 != null) {
                p2 = p1.next;
            }
        }
        return ret;
    }
}
