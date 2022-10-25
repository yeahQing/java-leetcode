package com.yeahqing.medium._621;

import java.util.HashMap;
import java.util.Map;

/**
 * @author YeahQing
 * @date 2022/10/24
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.leastInterval(new char[]{'A','A','A','A','A','A','B','C','D','E','F','G'}, 2));
    }

    public int leastInterval(char[] tasks, int n) {
        Map<Character, Task> m = new HashMap<>();
        for (Character c : tasks) {
            if (!m.containsKey(c))
                m.put(c, new Task());
            else {
                Task task = m.get(c);
                task.total++;
            }
        }
        int time = 0;
        for (int i = 0; i < tasks.length; i++) {
            int minNextValidTime = Integer.MAX_VALUE;
            for (Character c : m.keySet()) {
                if (m.get(c).total > 0)
                    minNextValidTime = Math.min(minNextValidTime, m.get(c).nextValidTime);
            }
            time = Math.max(time, minNextValidTime);
            char best = 'a';
            for (Character c : m.keySet()) {
                if (m.get(c).total >= 0 && m.get(c).nextValidTime <= time) {
                    if (best == 'a' || m.get(c).total > m.get(best).total) {
                        best = c;
                    }
                }
            }
            m.get(best).total -= 1;
            m.get(best).nextValidTime =  time + n + 1;
            time++;
        }
        return time;
    }
}

class Task {
    int total;
    int nextValidTime;

    public Task() {
        total = 1;
        nextValidTime = 0;
    }

}
