package q897_递增顺序查找树;

import java.util.ArrayList;
import java.util.List;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/5/22 12:22
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {

    //中序遍历拿到数组
    public List<Integer> inOrder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        List<Integer> listLeft = inOrder(root.left);
        list.addAll(listLeft);
        list.add(root.val);
        List<Integer> listRight = inOrder(root.right);
        list.addAll(listRight);
        return list;
    }

    public TreeNode increasingBST(TreeNode root) {
        List<Integer> list = inOrder(root);
        if (list.size() <= 0) return null;
        TreeNode newRoot = new TreeNode(list.get(0));
        TreeNode cur = newRoot;
        for (int i = 1; i < list.size(); i++) {//构造新的树
            cur.right = new TreeNode(list.get(i));
            cur = cur.right;
        }
        cur.right = null;
        return newRoot;
    }
}
