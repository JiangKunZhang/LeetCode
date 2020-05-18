package q102_二叉树的层序遍历;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/5/18 19:15
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new LinkedList<>();
        if(root == null) return ret;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            //1、求当前队列的大小  size
            int size = queue.size();
            //2、while(size > 0)  -->
            //把每层的节点都放进List中
         List<Integer> rowList = new LinkedList<>();
            while (size > 0) {
                TreeNode cur = queue.poll();
                rowList.add(cur.val);
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
                size--;
            }
            ret.add(rowList);
        }
        return ret;
    }
}