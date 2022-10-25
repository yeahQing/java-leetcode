package com.yeahqing.jianzhioffer._1_038;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author YeahQing
 * @date 2022/10/25
 */
class Solution {

    List<Character> path;
    List<String> res;
    boolean[] visited;

    public String[] permutation(String s) {
        path = new ArrayList<>();
        res = new ArrayList<>();
        visited = new boolean[s.length()];
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        dfs(arr, 0);
        String[] ret = new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ret[i] = res.get(i);
        }
        return ret;
    }

    void dfs(char[] arr, int k) {
        // 字符数组的长度如果等于字符串的长度，就表示排列完了
        if (arr.length == k) {
            // 将path变成一个字符串，并添加到结果集中
            res.add(listToString(path));
            return;
        }
        // 遍历其他没有访问过的字符
        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && arr[i] == arr[i-1] && !visited[i-1])
                continue;
            if (!visited[i]) {
                visited[i] = true;
                path.add(arr[i]);
                dfs(arr, k+1);
                visited[i] = false;
                path.remove(path.size()-1);
            }
        }
    }

    String listToString(List<Character> path) {
        StringBuilder sb = new StringBuilder();
        for (Character c: path) {
            sb.append(c);
        }
        return sb.toString();
    }

}
