package com.yeahqing.medium._173;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YeahQing
 * @date 2022/10/21
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
public class Solution {
    public static void main(String[] args) {
//        BSTIterator obj = new BSTIterator(root);
//        int param_1 = obj.next();
//        boolean param_2 = obj.hasNext();
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class BSTIterator {

    private final List<Integer> arr;
    private int index;

    public BSTIterator(TreeNode root) {
        index = 0;
        // 中序遍历
        arr = new ArrayList<Integer>();
        // 使用数组保存中序遍历的结果
        inorder(root);
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        arr.add(root.val);
        inorder(root.right);
    }

    public int next() {
        return arr.get(index++);
    }

    public boolean hasNext() {
        return index < arr.size();
    }
}
