package com.yeahqing.structure;

/**
 * @author YeahQing
 * @date 2022/10/25
 */
public class TreeNode {
    public int val;
    public TreeNode left, right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
