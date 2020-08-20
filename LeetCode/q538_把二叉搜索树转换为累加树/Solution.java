package q538_把二叉搜索树转换为累加树;

import java.util.ArrayList;
import java.util.List;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/5/22 12:50
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public List<Integer> preOrder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        list.add(root.val);
        List<Integer> list1 = preOrder(root.left);
        list.addAll(list1);
        List<Integer> list2 = preOrder(root.right);
        list.addAll(list2);
        return list;
    }
    public void convertBSTChild(TreeNode root,List<Integer> list) {
        if (root == null) return;
        int res = 0;//res保存所有比root.val大的值
        for(int v : list) {
            if (v > root.val) res += v;
        }
        root.val = root.val + res;
        convertBSTChild(root.left,list);
        convertBSTChild(root.right,list);

    }
    public TreeNode convertBST(TreeNode root) {
        List<Integer> list = preOrder(root);
        convertBSTChild(root,list);
        return root;
    }
}
