package com.yeahqing.jianzhioffer._2_001;

/**
 * @author YeahQing
 * @date 2022/9/28
 */
class Solution {
    /***
     * 剑指 Offer II 001. 整数除法
     * 给定两个整数 a 和 b ，求它们的除法的商 a/b ，要求不得使用乘号 '*'、除号 '/' 以及求余符号 '%'。
     * 注意：
     * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8以及truncate(-2.7335) = -2
     * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31,2^31−1]。本题中，如果除法结果溢出，则返回 2^31−1
     * @param a 整数a
     * @param b 整数b
     * @return a/b
     */
    public int divide(int a, int b) {
        int MIN = Integer.MIN_VALUE, MAX = Integer.MAX_VALUE;
        int MIN_LIMIT = MIN >> 1; // -1073741824
        if(a == MIN && b == -1) return MAX; // 特判
        boolean isPos = (a >= 0 || b <= 0) && (a <= 0 || b >= 0);
        if(a > 0) a = -a;
        if(b > 0) b = -b;
        int ans = 0; // 最终的商
        while(a <= b) {
            int d = b, c = 1; // d为当前除数，c为当前商
            while(d >= MIN_LIMIT && d + d >= a) { // 通过第一个条件防止d + d溢出
                d += d; // 当前除数倍增，也可以用 d <<= 1;
                c += c; // 当前商倍增，也可以用 c <<= 1;
            }
            a -= d; // a剩余部分
            ans += c; // 累计当前商
        }
        return isPos ? ans : -ans;
    }
}