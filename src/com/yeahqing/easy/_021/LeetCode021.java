package com.yeahqing.easy._021;

import com.yeahqing.structure.ListNode;

/**
 * @FileName LeetCode021.java
 * @Desc java-leetcode created by YeahQing
 * @Author YeahQing
 * @Date 2022/10/28 6:42
 */

public class LeetCode021 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = new ListNode();
        ListNode l2 = new ListNode();
        ListNode ret = solution.mergeTwoLists(l1, l2);
        System.out.println(ret.val);
    }
}

/**
 * <p>Definition for singly-linked list.</p>
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    /**
     * 递归解法
     *
     * @param list1 有序链表1
     * @param list2 有序链表2
     * @return 合并后的链表头节点
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }
        list2.next = mergeTwoLists(list1, list2.next);
        return list2;
    }
}

class Solution1 extends Solution {
    /**
     * 迭代解法
     *
     * @param list1 有序链表1
     * @param list2 有序链表2
     * @return 合并后的链表头节点
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode preHead = new ListNode(-1);
        ListNode pre = preHead;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                pre.next = list1;
                list1 = list1.next;
            } else {
                pre.next = list2;
                list2 = list2.next;
            }
            pre = pre.next;
        }
        pre.next = list1 != null ? list1 : list2;
        return preHead.next;
    }
}


