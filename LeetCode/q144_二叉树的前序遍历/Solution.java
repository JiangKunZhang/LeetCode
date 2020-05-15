package q144_二叉树的前序遍历;

import java.util.ArrayList;
import java.util.List;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/5/15 20:18
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        list.add(root.val);
        List<Integer> left = preorderTraversal(root.left);
        list.addAll(left);

        List<Integer> right = preorderTraversal(root.right);
        list.addAll(right);

        return list;
    }


        List<Integer> list = new ArrayList<>();
    public List<Integer> preorderTraversal2(TreeNode root) {
        if (root != null) {
            list.add(root.val);
            preorderTraversal2(root.left);
            preorderTraversal2(root.right);
        }
        return list;
    }
}
