package q617_合并二叉树;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/5/22 12:37
 *
 * 对这两棵树同时进行前序遍历,并将对应的节点进行合并
 *
 * 在遍历时，如果两棵树的当前节点均不为空，我们就将它们的值进行相加，并对它们的左孩子和右孩子进行递归合并；
 * 如果其中有一棵树为空，那么我们返回另一颗树作为结果；
 * 如果两棵树均为空，此时返回任意一棵树均可（因为都是空）
 *
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;//如果一个为空，返回另一个
        if (t2 == null) return t1;
        t1.val = t1.val + t2.val;//否则两个相加
        //递归合并  前序遍历
        t1.left = mergeTrees(t1.left,t2.left);
        t1.right = mergeTrees(t1.right,t2.right);
        return t1;
    }
}
