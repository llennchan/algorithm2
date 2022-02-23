package Tree.second;

import Tree.first.TreeNode;

public class LowestCommonAncestor {

    private TreeNode ret;

    public boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;

        boolean leftRet = dfs(root.left, p, q);
        boolean rightRet = dfs(root.right, p, q);

        // 左节点和右节点都命中了目标节点 or 节点本身命中了其中一个并且(左节点或者右节点命中了)
        if ((leftRet && rightRet) || (root.val == p.val || root.val == q.val) && (leftRet || rightRet)) {
            ret = root;
        }

        // 定义节点本身是p or q, 或者左节点是p or q, 或者右节点是p or q
        return root.val == p.val || root.val == q.val || leftRet || rightRet;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ret;
    }

}
