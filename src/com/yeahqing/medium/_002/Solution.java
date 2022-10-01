package com.yeahqing.medium._002;

import com.yeahqing.structure.ListNode;

/**
 * @author YeahQing
 * @date 2022/9/29
 */
class Solution {
    /***
     * 2. 两数相加
     * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     * 来源：力扣（LeetCode）
     * @param l1 非空链表1
     * @param l2 非空链表2
     * @return l1 + l2
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode();
        ListNode cur = pre;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;
            int sum = a + b + carry;
            carry = sum / 10;
            sum %= 10;
            cur.next = new ListNode(sum);
            cur = cur.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry == 1) {
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }
}