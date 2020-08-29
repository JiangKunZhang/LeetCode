package q236_二叉树的最近公共祖先;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/5/21 0:21
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        if (left != null && right != null) {
            return root;
        }else if (left != null) {
            return left;
        }else {
            return right;
        }
    }
}
