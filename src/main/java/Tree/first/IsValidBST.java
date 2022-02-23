package Tree.first;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 验证二叉搜索树
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 *
 * @author 包成
 */
public class IsValidBST {

    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean helper(TreeNode node, Long min, Long max) {
        if (node == null) return true;
        if (node.val <= min || node.val >= max) return false;
        return helper(node.left, min, node.val) && helper(node.right, node.val, max);
    }

    public boolean isValidBSTV2(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        long value = Long.MIN_VALUE;

        while (!stack.isEmpty() || root == null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if (root.val <= value) return false;
            value = root.val;
            root = root.right;
        }
        return true;
    }

    private long value = Long.MIN_VALUE;
    private boolean ret = true;

    private void inOrder(TreeNode node) {
        if (node == null || !ret) return;
        inOrder(node.left);
        if (node.val <= value) {
            ret = false;
            return;
        }
        value = node.val;
        inOrder(node.right);
    }

    public boolean isValidBSTV3(TreeNode root) {
        inOrder(root);
        return ret;
    }

    public static void main(String[] args) {
        double f = 111231.5585;
        BigDecimal b = new BigDecimal(f);
        System.out.println(b.setScale(2, RoundingMode.HALF_DOWN));
        System.out.println(new BigDecimal(137567).round(new MathContext(5, RoundingMode.HALF_EVEN)));
    }

}
