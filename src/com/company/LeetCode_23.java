package com.company;

public class LeetCode_23 {
    //合并K个排序列表
    public ListNode merge2Lists(ListNode list1, ListNode list2) {
        if(list1 == null) {
            return list2;
        }
        if(list2 == null) {
            return list1;
        }
        ListNode head = list1.val <= list2.val ? list1 : list2;
        ListNode now = head;
        if(list1.val <= list2.val) {
            list1 = list1.next;
        } else {
            list2 = list2.next;
        }
        while(list1 != null && list2 != null) {
            if(list1.val <= list2.val) {
                now.next = list1;
                now = now.next;
                list1 = list1.next;
            } else {
                now.next = list2;
                now = now.next;
                list2 = list2.next;
            }
        }
        if(list1 == null) {
            now.next = list2;
        } else {
            now.next = list1;
        }
        return head;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ret = null;
        for(int i = 0; i < lists.length; i++) {
            ret = merge2Lists(ret, lists[i]);
        }
        return ret;
    }
}
