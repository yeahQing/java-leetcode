package com.yeahqing.medium._105;

import com.yeahqing.structure.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @FileName Solution2.java
 * @Desc leetcode-105. 从前序与中序遍历序列构造二叉树, 使用栈和指针解决
 * @Author YeahQing
 * @Date 2022/10/26 17:16
 */

class Solution2 {
    Deque<TreeNode> stack;

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        solution2.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        int index = 0, i = 0;
        stack = new LinkedList<>();
        TreeNode root = new TreeNode(preorder[i++]);
        stack.push(root);
        while (!stack.isEmpty() && i < n) {
            TreeNode topNode = stack.peek();
            TreeNode newNode = new TreeNode(preorder[i++]);
            if (topNode.val != inorder[index]) {
                topNode.left = newNode;
            } else {
                TreeNode tmp = stack.pop();
                index++;
                while (!stack.isEmpty() && stack.peek().val == inorder[index]) {
                    tmp = stack.pop();
                    index++;
                }
                tmp.right = newNode;
            }
            stack.push(newNode);
        }
        return root;
    }

}
