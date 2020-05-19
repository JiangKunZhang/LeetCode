package q104_二叉树的最大深度;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/5/17 15:50
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //左子树深度 和 右子树深度 的最大值  + 1
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
