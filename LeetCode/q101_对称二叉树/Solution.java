package q101_对称二叉树;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/5/17 17:42
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetricChild(root.left, root.right);
    }
    public boolean isSymmetricChild(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if ((left == null && right != null) || (left != null && right == null)) {
            return false;
        }

        //代码走到这里，左右子树都不空，看值是否相等，以技术否对称
        //值相同 && 左树的左 右树的右 && 左树的右 右树的左
        return (left.val == right.val) && isSymmetricChild(left.left, right.right) && isSymmetricChild(left.right, right.left);
    }
}
