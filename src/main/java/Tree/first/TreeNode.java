package Tree.first;

/**
 * @author 包成
 */
public class TreeNode {

    public long val;
    public TreeNode left;
    public TreeNode right;
    TreeNode() {}
    TreeNode(long val) { this.val = val; }
    TreeNode(long val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
