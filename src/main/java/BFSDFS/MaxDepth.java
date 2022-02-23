package BFSDFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 包成
 */
public class MaxDepth {

    public int maxDepth(TreeNode root) {
        // 不存在节点了, 返回0
        if (root == null) return 0;
        // 左边的深度
        int left = maxDepth(root.left);
        // 右边的深度
        int right = maxDepth(root.right);
        // 取最大值 + 1
        return Math.max(left, right) + 1;
    }

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (left == 0) return right + 1;
        if (right == 0) return left + 1;
        return Math.min(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        MaxDepth maxDepth = new MaxDepth();
        System.out.println(maxDepth.minDepth(root));
    }

    public int maxDepthV2(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (queue.peek() != null) {
            depth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) queue.offer(poll.left);
                if (poll.right != null) queue.offer(poll.right);
            }
        }
        return depth;
    }

    public static class TreeNode {
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
