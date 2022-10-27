package com.yeahqing.medium._1239;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @FileName LeetCode1239.java
 * @Desc java-leetcode created by YeahQing
 * @Author YeahQing
 * @Date 2022/10/27 14:14
 */

public class LeetCode1239 {
    public static void main(String[] args) {
        Solution solution = new Solution1();
        List<String> testCase = new ArrayList<>(Arrays.asList("un", "iq", "ue"));
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

class Solution1 extends Solution {
    @Override
    public int maxLength(List<String> arr) {
        List<HashSet<Character>> all = new ArrayList<>();
        all.add(new HashSet<>());
        int ans = 0;
        for (String str : arr) {
            for (int i = 0; i < all.size(); i++) {
                HashSet<Character> s = all.get(i);
                // 用一个哈希集合中的元素去构建新的哈希集合
                HashSet<Character> tmp = new HashSet<>(all.get(i));
                for (Character c : str.toCharArray()) {
                    tmp.add(c);
                }
                // 当前集合中的字符串和当前字符串没有重复
                if (tmp.size() == s.size() + str.length()) {
                    all.add(tmp);
                    ans = Math.max(ans, tmp.size());
                }
            }
        }
        return ans;
    }
}
