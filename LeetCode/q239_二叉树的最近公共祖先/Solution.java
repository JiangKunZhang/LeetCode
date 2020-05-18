package q239_二叉树的最近公共祖先;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/5/18 23:54
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        //因为是递归，使用函数后可认为左右子树已经算出结果，这句话要记住，道出了递归的精髓
        TreeNode left = lowestCommonAncestor(root.left,p ,q);
        TreeNode right = lowestCommonAncestor(root.right,p ,q);

        if (left != null && right != null) {
            return root;//如果 left 和 right 都非空，因为只给了 pp 和 qq 两个结点，都非空，说明一边一个，因此 root 是他们的最近公共祖先
        }else if (left != null) {
            return left;//此时若 right 为空，那最终结果只要看 left；若 left 为空，那最终结果只要看 right
        }else {
            return right;
        }
    }
}
