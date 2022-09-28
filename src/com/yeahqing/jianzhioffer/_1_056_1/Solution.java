package com.yeahqing.jianzhioffer._1_056_1;

import com.yeahqing.structure.Interval;

import java.util.Arrays;

/**
 * @author YeahQing
 * @date 2022/9/28
 */
class Solution {
    /**
     * 剑指 Offer 56 - I. 数组中数字出现的次数 middle
     * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
     * @param nums = [4,1,4,6]
     * @return int[]
     */
    public int[] singleNumbers(int[] nums) {
        // 1. 所有值做异或，只出现一次的两个数字异或一定不为0
        int num = 0;
        for (int n : nums) {
            // num = a ^ b, a和b表示只出现一次的两个数字
            num ^= n;
        }
        // 2. 找到最低位的1
        int div = 1;
        while ((div & num) == 0) {
            div <<= 1; // 从最低位开始判断num哪一位为1
        }
        // 3. 按照这一位将原数组分组，就是把a和b分别分到两组，之后进行异或就可以得到两个只出现一次的数字
        int a = 0, b = 0;
        for (int n : nums) {
            // 同样的数字与的结果一定是相同的，也就是会分到同一个组
            if ((div & n) == 0) {
                a ^= n;
            } else {
                b ^= n;
            }
        }
        return new int[]{a, b};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = Interval.createTestData("[4,1,4,6]");
        int[] ret = solution.singleNumbers(nums);
        System.out.println(Arrays.toString(ret));
    }
}