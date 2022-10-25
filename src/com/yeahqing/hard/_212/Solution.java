package com.yeahqing.hard._212;

import java.util.*;

/**
 * @author YeahQing
 * @date 2022/10/25
 * leetcode-212 单词搜索 II
 * 回溯法+前缀树
 */
public class Solution {

    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        Set<String> ans = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, trie, i, j, ans);
            }
        }

        return new ArrayList<String>(ans);
    }

    public void dfs(char[][] board, Trie now, int i, int j, Set<String> ans) {
        if (!now.children.containsKey(board[i][j])) {
            return;
        }

        char ch = board[i][j];
        board[i][j] = '#';
        now = now.children.get(ch);

        if (now.isWord) {
            ans.add(now.word);
        }

        for (int[] dir : dirs) {
            int i1 = i + dir[0], j1 = j + dir[1];
            if (i1 >= 0 && i1 < board.length && j1 >= 0 && j1 < board[0].length) {
                dfs(board, now, i1, j1, ans);
            }
        }
        board[i][j] = ch;
    }

}

class Trie {

    String word;
    Map<Character, Trie> children;
    boolean isWord;

    public Trie() {
        word = "";
        children = new HashMap<>();
        isWord = false;
    }

    public void insert(String word) {
        Trie cur = this;
        for (Character c : word.toCharArray()) {
            if (!cur.children.containsKey(c)) {
                cur.children.put(c, new Trie());
            }
            cur = cur.children.get(c);
        }
        cur.isWord = true;
        cur.word = word;
    }
}
