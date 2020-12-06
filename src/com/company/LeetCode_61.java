package com.company;

public class LeetCode_61 {
/**
 * Copyright (C), 2019-2019, citi Group
 * Filename: LeetCode_61
 * Author: wyf
 * Date: 20190907 22:23
 * Description: 旋转链表
 * History:
 *
 */
public ListNode rotateRight(ListNode head, int k) {
    if(head == null) return head;
    ListNode now = head;
    int length = 1;
    while(now.next != null){now = now.next; length++; }
    int steps = k % length;
    if(steps == 0){ return head; }
    ListNode end = now;
    end.next = head;
    now = head;
    for(int i = 0; i < length - steps; i++) {
        now = now.next;
    }
    head = now.next;
    now.next = null;
    return head;
}
}
