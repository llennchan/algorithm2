package BFSDFS.second;

import java.util.*;

public class LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return Collections.emptyList();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        List<List<Integer>> ret = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node != null) {
                    list.add(node.val);
                    if (node.left != null) queue.offer(node.left);
                    if (node.right != null) queue.offer(node.right);
                }
                size--;
            }
            ret.add(list);
        }

        return ret;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        List<TreeNode> nodes;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public List<TreeNode> getNodes() {
            return nodes;
        }

        public void setNodes(List<TreeNode> nodes) {
            this.nodes = nodes;
        }
    }

    public static void main(String[] args) {
        LevelOrder order = new LevelOrder();
        List<String> strings = order.generateParenthesis(3);
        strings.forEach(System.out::println);
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }
        if (open < max) {
            cur.append('(');
            backtrack(ans, cur, open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(')');
            backtrack(ans, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

}
