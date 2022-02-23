package Tree.second;

import Tree.first.TreeNode;

public class IsValidBST {

    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    // 递归
    private boolean helper(TreeNode node, long min, long max) {
        if (node == null) return true;
        // 每一层都要判断大于左节点，小于右节点
        if (node.val < min || node.val > max) return false;
        // 左节点是否满足条件
        boolean leftRet = helper(node.left, min, node.val);
        // 右节点是否满足条件
        boolean rightRet = helper(node.right, node.val, max);
        return leftRet && rightRet;
    }

}
