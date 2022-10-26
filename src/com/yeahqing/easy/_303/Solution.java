package com.yeahqing.easy._303;

public class Solution {
    public static void main(String[] args) {

    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 *
 * @author YeahQing
 * @date 2022/10/25
 * 区域和检索 - 数组不可变
 */
class NumArray {
    int[] sum;

    public NumArray(int[] nums) {
        int n = nums.length;
        sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        // sum数组存储nums数组中前n项的和
        return sum[right + 1] - sum[left];
    }
}