package q606_根据二叉树创建字符串;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/5/21 23:16
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {

    public void tree2strChild(TreeNode t, StringBuffer sb) {
        if (t == null) return;
        sb.append(t.val);
        if (t.left == null) {
            if (t.right == null) {
                return;
            }else {
                sb.append("()");
            }
        }else {
            sb.append("(");
            tree2strChild(t.left,sb);
            sb.append(")");
        }

        if (t.right == null) {
            return;
        }else {
            sb.append("(");
            tree2strChild(t.right,sb);
            sb.append(")");
        }
    }

    public String tree2str(TreeNode t) {
        StringBuffer sb = new StringBuffer();
        tree2strChild(t,sb);
        return sb.toString();
    }
}
