package Trie;

import java.util.*;

/**
 * 单词搜索 II
 * https://leetcode-cn.com/problems/word-search-ii/solution/dan-ci-sou-suo-ii-by-leetcode-solution-7494/
 *
 * @author 包成
 */
public class FindWords {

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        int x = board.length;
        int y = board[0].length;
        boolean[][] visited = new boolean[x][y];
        Set<String> ret = new HashSet<>();
        for (int i = 0; i < x; ++i) {
            for (int j = 0; j < y; ++j) {
                // 每个位置都当做起点试一次
                backtrack(board, visited, i, j, trie, ret);
            }
        }

        return new ArrayList<>(ret);
    }

    private void backtrack(char[][] board, boolean[][] visited, int x, int y, Trie trie, Set<String> ret) {
        // 递归结束
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) return;

        // 剪枝 同一个单词同一个单元格已访问过
        if (visited[x][y]) return;

        // 剪枝 前缀不匹配
        if (!trie.children.containsKey(board[x][y])) return;

        // 标记当前节点已访问
        visited[x][y] = true;
        trie = trie.children.get(board[x][y]);

        if (!"".equals(trie.word)) ret.add(trie.word);

        // 左移
        backtrack(board, visited, x - 1, y, trie, ret);
        // 右移
        backtrack(board, visited, x + 1, y, trie, ret);
        // 下移
        backtrack(board, visited, x, y - 1, trie, ret);
        // 上移
        backtrack(board, visited, x, y + 1, trie, ret);

        // 回溯
        visited[x][y] = false;
    }
    
    public static class Trie {
        public String word;
        public Map<Character, Trie> children;

        public Trie() {
            word = "";
            children = new HashMap<>();
        }

        public void insert(String word) {
            Trie node = this;
            for (char c : word.toCharArray()) {
                if (!node.children.containsKey(c)) {
                    node.children.put(c, new Trie());
                }
                node = node.children.get(c);
            }
            node.word = word;
        }
    }

    public static void main(String[] args) {
        FindWords findWords = new FindWords();
        char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words = {"oath","pea","eat","rain"};
        List<String> ret = findWords.findWords(board, words);
        ret.forEach(System.out::println);
    }

}
