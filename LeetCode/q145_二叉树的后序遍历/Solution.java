package q145_二叉树的后序遍历;

import java.util.ArrayList;
import java.util.List;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/5/15 20:47
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        List<Integer> left = postorderTraversal(root.left);
        list.addAll(left);

        List<Integer> right = postorderTraversal(root.right);
        list.addAll(right);

        list.add(root.val);

        return list;
    }
}
