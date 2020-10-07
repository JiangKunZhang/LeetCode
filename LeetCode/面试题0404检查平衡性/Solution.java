package 面试题0404检查平衡性;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/7/16 19:39
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return (Math.abs(getDeep(root.left) - getDeep(root.right)) <= 1) && isBalanced(root.left) && isBalanced(root.right);
    }

    public static int getDeep(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getDeep(root.left),getDeep(root.right)) + 1;
    }
}
