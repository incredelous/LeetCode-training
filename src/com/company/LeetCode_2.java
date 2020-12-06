package com.company;

public class LeetCode_2 {
    //两数相加
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        int pointer1;
        int pointer2;
        if(l1 == null) {
            return l2;
        } else if(l2 == null) {
            return l1;
        } else {
            ListNode result = new ListNode(0);
            ListNode head = result;
            do {
                pointer1 = l1.val;
                pointer2 = l2.val;
                result.val = (pointer1 + pointer2 + carry) % 10;
                if(pointer1 + pointer2 + carry >= 10) {
                    carry = 1;
                } else {
                    carry = 0;
                }
                l1 = l1.next;
                l2 = l2.next;
                if(l1 == null || l2 == null) {
                    break;
                }
                result.next = new ListNode(0);
                result = result.next;
            } while(true);
            if(l1 == null && l2 == null) {
                if(carry == 1) {
                    result.next = new ListNode(1);
                }
                return head;
            } else if(l1 == null) {
                ListNode l2_head = l2;
                int pointer;
                do {
                    pointer = l2.val;
                    l2.val = (pointer + carry) % 10;
                    if(pointer + carry >= 10) {
                        carry = 1;
                    } else {
                        carry = 0;
                    }
                    if(l2.next == null && carry == 1) {
                        l2.next = new ListNode(0);
                    }
                    l2 = l2.next;
                } while(l2 != null);
                if(carry == 1) {
                    l2.next = new ListNode(1);
                }
                result.next = l2_head;
                return head;
            } else {
                ListNode l1_head = l1;
                int pointer;
                do {
                    pointer = l1.val;
                    l1.val = (pointer + carry) % 10;
                    if(pointer + carry >= 10) {
                        carry = 1;
                    } else {
                        carry = 0;
                    }
                    if(l1.next == null && carry == 1) {
                        l1.next = new ListNode(0);
                    }
                    l1 = l1.next;
                } while(l1 != null);
                result.next = l1_head;
                return head;
            }
        }
    }
}
