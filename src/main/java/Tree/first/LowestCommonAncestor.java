package Tree.first;

/**
 * 二叉树的最近公共祖先
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 *
 * @author 包成
 */
public class LowestCommonAncestor {

    private TreeNode ret;

    public boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        boolean left = dfs(root.left, p, q);
        boolean right = dfs(root.right, p, q);
        if ((left && right) || (root.val == p.val || root.val == q.val) && (left || right)) {
            ret = root;
        }
        return left || right || root.val == p.val || root.val == q.val;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.dfs(root, p, q);
        return this.ret;
    }

}
