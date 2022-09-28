package com.yeahqing.util;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.Scanner;

/**
 * @author YeahQing
 * @date 2022/9/28
 */
public class IOUtil {
    /***
     * 读取一行以正则表达式分割的数组，[1,2,3,4] "," or [1_2_3_4] "_" or [1 2 3 4] " "
     * @return int[]
     */
    public static int[] readNums(String regex) {
        Scanner scan = new Scanner(System.in);

        String[] arr = scan.nextLine().split(regex);

        int[] nums = new int[arr.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(arr[i]);
        }
        return nums;
    }

    /***
     * 读取一个整数n并返回一个nxn的二维数组
     * @param eq 是否是方阵，即行列是否相同
     * @return int[][]
     */
    public static int[][] readArr2D(boolean eq) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = eq ? n : scan.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scan.nextInt();
            }
        }
        return arr;
    }

    public static void readArr2DType2() {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T > 0) {
            T--;
            int m = scan.nextInt();
            int n = scan.nextInt();
            int[][] arr = new int[m][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = scan.nextInt();
                }
            }

            for (int[] row : arr)
                for (int v : row)
                    System.out.println(v);

        }
    }

}
