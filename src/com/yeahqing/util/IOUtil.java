package com.yeahqing.util;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.Scanner;

/**
 * @author YeahQing
 * @date 2022/9/28
 */
public class IOUtil {
    public static int[] readNums() {
        Scanner scan = new Scanner(System.in);
        String[] arr = scan.nextLine().split(",");
        int[] nums = new int[arr.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(arr[i]);
        }
        return nums;
    }
}
