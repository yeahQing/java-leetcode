package com.yeahqing.structure;

import java.util.ArrayList;
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

    public static List<Interval> createTestData(String data) {
        List<Interval> list = new ArrayList<>();
        String[] d = data.substring(1, data.length() - 1).split("],\\[");
        for (String s : d) {
            String[] sub = s.split(",");
            // parseInt返回int, valueOf返回Integer
            list.add(new Interval(Integer.parseInt(sub[0]), Integer.parseInt(sub[1])));
        }
        return list;
    }

    public static void print(List<Interval> list) {
        if (list == null) {
            System.out.println("null");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (Interval interval : list) {
            sb.append("[")
                    .append(interval.start)
                    .append(",")
                    .append(interval.end)
                    .append("],");
        }
        System.out.println(sb.substring(0, sb.length() - 1));
    }

}
