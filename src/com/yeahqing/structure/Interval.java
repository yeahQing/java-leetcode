package com.yeahqing.structure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author YeahQing
 * @date 2022/9/28
 */
public class Interval {
    public int start;
    public int end;

    public Interval() {
        start = 0;
        end = 0;
    }

    public Interval(int s, int e) {
        start = s;
        end = e;
    }

    /***
     * 输入一维字符串数组，返回整型数组
     * @param data "[1, 2, 3, 4]"
     * @return int[]
     */
    public static int[] createTestData(String data) {
        List<Integer> list = new ArrayList<>();
        String[] d = data.substring(1, data.length() - 1).split(",");
        for (String s : d) {
            // parseInt返回int, valueOf返回Integer
            list.add(Integer.valueOf(s));
        }
        int[] nums = new int[list.toArray().length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) list.toArray()[i];
        }
        return nums;
    }

    public static void print(List<Integer> list) {
        if (list == null) {
            System.out.println("null");
            return;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<Integer> iterator = list.stream().iterator();
        if (iterator.hasNext()) {
            sb.append("[").append(iterator.next());
        }
        while (iterator.hasNext()) {
            Integer val = iterator.next();
            sb.append(",").append(val);
        }
        sb.append("]");
        System.out.println(sb);
    }

}
