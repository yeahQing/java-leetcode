package com.yeahqing.medium._003;

/**
 * @author YeahQing
 * @date 2022/10/4
 */
class Solution2 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        int[] idx = new int[256];
        int offset = 1;
        int nextIdx = 1;
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (idx[c] < offset) {
                idx[c] = nextIdx++;
            } else {
                // hit a duplicated char
                int len = nextIdx - offset;
                if (len > maxLength) {
                    maxLength = len;
                }
                offset = idx[c] + 1;
                idx[c] = nextIdx++;
            }
        }
        int len = nextIdx - offset;
        if (len > maxLength) {
            maxLength = len;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int ret = solution2.lengthOfLongestSubstring("abcabcbb");
        System.out.println(ret);
    }
}
