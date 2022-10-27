package com.yeahqing.medium._1239;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @FileName LeetCode1239.java
 * @Desc java-leetcode created by YeahQing
 * @Author YeahQing
 * @Date 2022/10/27 14:14
 */

public class LeetCode1239 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> testCase = new ArrayList<>(Arrays.asList("aa", "bb"));
        System.out.println(solution.maxLength(testCase));
    }
}

class Solution {
    int ans = 0;

    public int maxLength(List<String> arr) {
        List<Integer> masks = new ArrayList<Integer>();

        for (String s : arr) {
            Integer mask = 0;
            for (Character c : s.toCharArray()) {
                int ch = c - 'a';
                if ((mask & 1 << ch) != 0) {
                    mask = 0;
                    break;
                }
                mask = mask | 1 << ch;
            }
            if (mask > 0) {
                masks.add(mask);
            }
        }
        dfs(masks, 0, 0);
        return ans;
    }

    public void dfs(List<Integer> masks, int pos, int mask) {
        if (pos == masks.size()) {
            ans = Math.max(ans, Integer.bitCount(mask));
            return;
        }
        if ((mask & masks.get(pos)) == 0) {
            dfs(masks, pos + 1, mask | masks.get(pos));
        }
        dfs(masks, pos + 1, mask);
    }
}
