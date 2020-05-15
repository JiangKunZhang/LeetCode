package q94_二叉树的中序遍历;

import java.util.ArrayList;
import java.util.List;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/5/15 20:46
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        List<Integer> left = inorderTraversal(root.left);
        list.addAll(left);

        list.add(root.val);

        List<Integer> right = inorderTraversal(root.right);
        list.addAll(right);

        return list;
    }
}
