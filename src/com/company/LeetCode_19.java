package com.company;

public class LeetCode_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //删除链表的倒数第N个节点
        ListNode slow = head;
        ListNode fast = head;
        int counter = 0;
        while(fast != null && counter++ < n) {
            fast = fast.next;
        }
        if(fast == null && counter != n) {
            return null;
        }
        if(fast == null) {
            return head.next;
        }
        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        ListNode temp = slow.next;
        slow.next = temp.next;
        return head;
    }
}
