package com.yeahqing.medium._003;

import java.util.HashSet;

/**
 * @author YeahQing
 * @date 2022/10/1
 */
class Solution {
    /***
     * 3. 无重复字符的最长子串
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
     * @param s 字符串s
     * @return 无重复字符的最长子串的长度
     */
    public int lengthOfLongestSubstring(String s) {
        // 用数据结构HashSet集合,实现控制元素只能出现一次
        HashSet<Character> set = new HashSet<>();
        int j = -1, ans = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                // 移除集合中前一个元素, 因为判断的是i开始的子串
                set.remove(s.charAt(i-1));
            }
            // 从i+1到j可以保证没有重复的字符, 因此不需要每次重置j的位置
            while (j+1 < n && !set.contains(s.charAt(j+1))) {
                // 如果集合中没有这个字符，就把它加入到集合中
                set.add(s.charAt(j+1));
                j++;
            }
            // 当前集合的长度就是当前子串中不重复的最大子串长度
            // j - i + 1
            ans = Math.max(ans, set.size());
        }
        return ans;
    }
}
