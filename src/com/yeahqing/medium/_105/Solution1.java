package com.yeahqing.medium._105;

import com.yeahqing.structure.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @FileName Solution1.java
 * @Desc leetcode-105. 从前序与中序遍历序列构造二叉树
 * @Author YeahQing
 * @Date 2022/10/26 16:24
 */

class Solution1 {
    Map<Integer, Integer> map;
    int[] preArr, midArr;

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        solution1.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
    }

    /**
     * 使用前序和中序遍历构造二叉树
     *
     * @param preorder 前序遍历节点值数组
     * @param inorder  中序遍历节点值数组
     * @return 根节点root
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        preArr = Arrays.copyOf(preorder, n);
        midArr = Arrays.copyOf(inorder, n);
        // 使用哈希表存储中序遍历中节点的下标, 方便找到根节点，区分左右子树
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return dfs(0, n - 1, 0, n - 1);
    }

    public TreeNode dfs(int pLeft, int pRight, int mLeft, int mRight) {
        if (pLeft > pRight || mLeft > mRight) return null;
        // 找到当前根节点在前序遍历和中序遍历中的位置
        int rootIndex = map.get(preArr[pLeft]);
        TreeNode root = new TreeNode(midArr[rootIndex]);
        // 左子树的个数
        int leftTreeSize = rootIndex - mLeft;
        // 前序遍历中左子树的个数 = 根节点 + 左子树的个数
        root.left = dfs(pLeft + 1, pLeft + leftTreeSize, mLeft, rootIndex - 1);
        root.right = dfs(pLeft + leftTreeSize + 1, pRight, rootIndex + 1, mRight);
        return root;
    }

}
