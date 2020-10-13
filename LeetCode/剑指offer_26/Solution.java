package 剑指offer_26;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/7/23 22:41
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        if (isSubTree(A, B)) {//从起始位置先比较一下
            return true;
        }
        if (isSubStructure(A.left, B)) {//在左子树中找
            return true;
        }
        if (isSubStructure(A.right, B)) {//在右子树中找
            return true;
        }
        return false;
    }

    public static boolean isSubTree(TreeNode a, TreeNode b) {
        if (b == null) {//说明子树已经比较完了
            return true;
        }
        if (a == null) {//子树还没比较完，自己就完了，false，root1为空，说明root2不是你的子结构
            return false;
        }
        if (a.val != b.val) {
            return false;
        }
        return isSubTree(a.left, b.left) && isSubTree(a.right, b.right);
    }
}
