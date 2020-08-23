package q662_二叉树最大宽度;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/5/22 11:43
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        LinkedList<Integer> list = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        list.add(1);
        int res = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();//层序遍历
            for (int i = size; i > 0; i--) {
                TreeNode top = queue.poll();
                int topIndex = list.removeFirst();
                if (top.left != null) {
                    queue.offer(top.left);
                    list.add(topIndex * 2);
                }
                if (top.right != null) {
                    queue.offer(top.right);
                    list.add(topIndex * 2 + 1);
                }
            }
            if (list.size() >= 2) {// list 中 size 为 1 的情况下，宽度也为 1，没有必要计算。
                res = Math.max(res, list.getLast() - list.getFirst() + 1);//宽度是 右 - 左 + 1
            }
        }
        return res;
    }
}
