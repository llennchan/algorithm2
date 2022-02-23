package BFSDFS.first;

import java.util.*;

/**
 * 二叉树的层序遍历
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 *
 * @author 包成
 */
public class LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return Collections.emptyList();

        List<List<Integer>> ret = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                // 只会poll到当前层
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if (poll.left != null) queue.offer(poll.left);
                if (poll.right != null) queue.offer(poll.right);
            }
            ret.add(list);
        }
        return ret;
    }

    public List<List<Integer>> levelOrderV2(TreeNode root) {
        Map<Integer, List<Integer>> map = new TreeMap<>(Integer::compareTo);
        _levelOrder(map, root, 0);
        List<List<Integer>> ret = new ArrayList<>();
        map.forEach((k, v) -> ret.add(v));
        return ret;
    }

    private void _levelOrder(Map<Integer, List<Integer>> map, TreeNode node, Integer level) {
        if (node == null) return;

        List<Integer> list = map.get(level);
        if (list == null) list = new ArrayList<>();
        list.add(node.val);
        map.put(level, list);

        _levelOrder(map, node.left, level + 1);
        _levelOrder(map, node.right, level + 1);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

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
    }

}
