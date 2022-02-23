package Tree.first;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉搜索树的最近公共祖先
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 *
 * @author 包成
 */
public class LowestCommonAncestorV2 {

    // 循环处理
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ret = root;
        while (true) {
            if (ret.val > p.val && ret.val > q.val) {
                ret = ret.left;
            } else if (ret.val < p.val && ret.val < q.val) {
                ret = ret.right;
            } else {
                break;
            }
        }
        return ret;
    }

    // 递归处理
    public TreeNode lowestCommonAncestorV2(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) return lowestCommonAncestorV2(root.left, p, q);
        if (root.val < p.val && root.val < q.val) return lowestCommonAncestorV2(root.right, p, q);
        return root;
    }

    public TreeNode lowestCommonAncestorV3(TreeNode root, TreeNode p, TreeNode q) {
        Queue<TreeNode> parentQueue_p = parentQueue(root, p);
        Queue<TreeNode> parentQueue_q = parentQueue(root, q);
        TreeNode ret = root;
        while (!parentQueue_p.isEmpty() && !parentQueue_q.isEmpty()) {
            TreeNode poll_p = parentQueue_p.poll();
            TreeNode poll_q = parentQueue_q.poll();
            if (poll_p.val == poll_q.val) {
                ret = poll_p;
            }
        }
        return ret;
    }

    private Queue<TreeNode> parentQueue(TreeNode root, TreeNode target) {
        Queue<TreeNode> queue = new LinkedList<>();
        while (root.val != target.val) {
            queue.offer(root);
            if (root.val > target.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        queue.offer(root);
        return queue;
    }

}
