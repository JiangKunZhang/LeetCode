package q100_相同的树;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/5/17 16:11
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if ((p == null && q != null) || (p != null && q == null)) return false;
        if (p == null && q == null) return true;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);//代码走到这里说明q p的 val 都相同 比较左右子树
    }
}
