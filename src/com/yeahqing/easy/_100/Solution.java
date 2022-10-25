package com.yeahqing.easy._100;

/**
 * @author YeahQing
 * @date 2022/10/25
 */

import com.yeahqing.structure.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 如果两个都为空，表示遍历完了子树吗，节点都没有左子树或者右子树
        if (p == null && q == null) return true;
        // 如果两个节点都不为空，则需要判断值是否相同
        // 相同则继续递归判断左子树和右子树
        if (p != null && q != null && p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        // 如果一个节点为空，一个节点不为空，则返回false
        return false;
    }
}
