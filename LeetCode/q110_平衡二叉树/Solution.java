package q110_平衡二叉树;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/5/17 17:08
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public boolean isBalanced(TreeNode root) {
        //root为空肯定是平衡的
        if (root == null) {
            return true;
        }
        //根节点左右子树的高度差 <= 1 && 左子树是平衡的 && 右子树是平衡的
        return (Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1) && isBalanced(root.left) && isBalanced(root.right);
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
    }
}
