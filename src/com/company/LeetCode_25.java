package com.company;

public class LeetCode_25 {
    //K 个一组翻转链表
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode end = dummy;
        while(end != null) {
            for(int i = 0; i < k; i++) {
                if(end == null) {
                    break;
                }
                end = end.next;
            }
            if(end == null) {
                break;
            }
            ListNode next = end.next;
            end.next = null;
            ListNode start = pre.next;
            pre.next = reverseLinkedList(start);
            start.next = next;
            pre = start;
            end = start;
        }
        return dummy.next;
    }

    public ListNode reverseLinkedList(ListNode start) {
        ListNode pre = null;
        ListNode now = start;
        while(now != null) {
            ListNode next = now.next;
            now.next = pre;
            pre = now;
            now = next;
        }
        return pre;
    }
}
