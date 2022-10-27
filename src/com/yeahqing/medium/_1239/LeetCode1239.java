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
        Solution solution = new Solution2();
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
        // 使用哈希集合去重
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

class Solution2 extends Solution {
    @Override
    public int maxLength(List<String> arr) {
        int ans = 0;
        List<Integer> masks = new ArrayList<>();
        masks.add(0); // 空串

        for (String s : arr) {
            // 1. 判断字符串中有没有重复的字符
            int mask = 0;
            for (Character c : s.toCharArray()) {
                int ch = c - 'a';
                if ((mask & 1 << ch) != 0) {
                    mask = 0;
                    break;
                }
                // 没有重复字符，当前字符串就是可行解的一种
                mask |= 1 << ch;
            }
            // 有重复字符，直接跳过
            if (mask == 0) continue;
            // 2. 和前i项可行解做拼接，判断是否满足条件
            for (int i = 0; i < masks.size(); i++) {
                if ((mask & masks.get(i)) == 0) {
                    // 和空串拼接，就是将当前串添加到可行解中
                    masks.add(mask | masks.get(i));
                    ans = Math.max(ans, Integer.bitCount(mask | masks.get(i)));
                }
            }
        }
        return ans;
    }
}
