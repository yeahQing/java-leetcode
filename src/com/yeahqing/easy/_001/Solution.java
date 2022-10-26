package com.yeahqing.easy._001;

import com.yeahqing.structure.Interval;

import java.util.Arrays;
import java.util.HashMap;

class Solution {
    /**
     * 1. 两数之和
     * @param nums 整数数组
     * @param target 数组中和为target的值
     * @return int[]
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{i, map.get(nums[i])};
            }
            // 找target-nums[i]是否存在
            map.put(target - nums[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int target = 9;
        int[] nums = Interval.createTestData("[2,7,11,15]");
        System.out.println(Arrays.toString(solution.twoSum(nums, target)));
    }
}
