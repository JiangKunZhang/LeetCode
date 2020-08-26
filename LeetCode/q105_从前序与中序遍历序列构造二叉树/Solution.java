package q105_从前序与中序遍历序列构造二叉树;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/5/21 17:19
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public int preIndex = 0;
    public TreeNode buildTreeChild(int[] preorder, int[] inorder, int inBegin, int inEnd) {
        if (inBegin > inEnd) return null;//没有节点了
        TreeNode root = new TreeNode(preorder[preIndex]);
        //2、找到当前根节点，在中序遍历当中的位置
        int rootIndex = findIndexOfInOrder(inorder,inBegin,inEnd,preorder[preIndex]);
        if (rootIndex == -1) return null;
        preIndex++;
        //rootIndex左边的是左树
        root.left = buildTreeChild(preorder,inorder,inBegin,rootIndex - 1);
        //rootIndex右边的是右树
        root.right = buildTreeChild(preorder,inorder,rootIndex + 1,inEnd);
        return root;
    }

    public int findIndexOfInOrder(int[] inorder, int inBegin, int inEnd, int val) {
        for (int i = inBegin; i <= inEnd; i++) {
            if (inorder[i] == val) {
                return i;
            }
        }
        return -1;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) return null;//数组为空
        if (preorder.length <= 0 || inorder.length <= 0) return null;//数组不为空但是，数组里面没东西
        TreeNode root = buildTreeChild(preorder,inorder,0,inorder.length - 1);
        return root;
    }
}
