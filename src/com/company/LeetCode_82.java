package com.company;

public class LeetCode_82 {
/**
 * Copyright (C), 2019-2019, citi Group
 * Filename: LeetCode_82
 * Author: wyf
 * Date: 20191014 22:10
 * Description: 删除排序链表中的重复元素 II
 * History:
 *
 */
public ListNode deleteDuplicates(ListNode head) {
    while(head == null || head.next == null) return head;
    ListNode now = head;
    ListNode last = null;
    while(now.next != null){
        if(now.val == now.next.val){
            int tmp = now.val;
            while(now != null && now.val == tmp){ now = now.next; }
            if(last != null) last.next = now;
            else head = now;
            if(now == null) break;
        }
        else{
            last = now;
            now = now.next;
        }
    }
    return head;
}
}
