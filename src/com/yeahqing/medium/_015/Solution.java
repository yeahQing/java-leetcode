package com.yeahqing.medium._015;

import java.util.*;

/**
 * @author YeahQing
 * @date 2022/10/25
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        // -4 -1 -1 0 1 2
        // 双指针
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int k = n-1;
            for (int j = i+1; j < n; j++) {
                if (j > i+1 && nums[j] == nums[j-1]) continue;
                while (k > j && nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                }
                if (k == j) break;
                if (nums[i] + nums[j] + nums[k] == 0) {
                    List<Integer> ret = new ArrayList<>();
                    ret.add(nums[i]);
                    ret.add(nums[j]);
                    ret.add(nums[k]);
                    ans.add(ret);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.threeSum(new int[]{-1,0,1,2,-1,-4});
    }

}
