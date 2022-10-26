package com.yeahqing.medium._105;

import com.yeahqing.structure.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author YeahQing
 * @date 2022/10/26
 */
public class Solution {
    Map<Integer, Integer> map;

    public static void main(String[] args) {
        Solution s = new Solution();
        s.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
    }

    /**
     * @param preorder 先序遍历序列
     * @param inorder  中序遍历序列
     * @return 根节点
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 先序遍历, 第一个元素即使根节点
        // 中序遍历，通过先序遍历定位，然后分成左右子树，递归重复以上操作
        // 这里使用哈希表存储中序遍历的值和其下标，
        // 因为二叉树中的节点值不重复，因此可以这么做。
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        int n = preorder.length;
        return dfs(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    public TreeNode dfs(int[] preorder, int[] inorder, int pLeft, int pRight, int mLeft, int mRight) {
        if (pLeft > pRight) return null;
        int mid = map.get(preorder[pLeft]);
        TreeNode root = new TreeNode(preorder[pLeft]);
        int leftLen = mid - mLeft;
        root.left = dfs(preorder, inorder, pLeft + 1, pLeft + leftLen, mLeft, mid - 1);
        root.right = dfs(preorder, inorder, pLeft + leftLen + 1, pRight, mid + 1, mRight);
        return root;
    }
}
