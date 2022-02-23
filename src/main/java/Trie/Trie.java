package Trie;

/**
 * 实现 Trie (前缀树)
 * https://leetcode-cn.com/problems/implement-trie-prefix-tree/
 *
 * @author 包成
 */
public class Trie {

    private Trie[] children;
    private boolean isEnd;

    /** Initialize your data structure here. */
    public Trie() {
        // 前缀树哪些英文小写字母有数据
        children = new Trie[26];
        // 表示完整的单词
        isEnd = false;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie node = this;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                // 当前层该英文单词有数据
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie trie = _prefixNode(word);
        return trie != null && trie.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie trie = _prefixNode(prefix);
        return trie != null;
    }

    private Trie _prefixNode(String prefix) {
        Trie node = this;
        for (int i = 0; i < prefix.length(); ++i) {
            char c = prefix.charAt(i);
            int index = c - 'a';
            if (node.children[index] == null) return null;

            node = node.children[index];
        }
        return node;
    }

}
