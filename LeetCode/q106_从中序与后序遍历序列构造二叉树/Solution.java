package q106_从中序与后序遍历序列构造二叉树;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/5/21 18:23
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

    public int postIndex = 0;
    public TreeNode buildTreeChild(int[] inOrder, int[] postOrder,int inBegin,int inEnd) {
        if (inBegin > inEnd) return null;
        TreeNode root = new TreeNode(postOrder[postIndex]);
        int rootIndex = findIndexOfInorder(inOrder,inBegin,inEnd,postOrder[postIndex]);
        postIndex--;
        if (rootIndex == -1) return null;
        root.right = buildTreeChild(inOrder,postOrder,rootIndex+1,inEnd);
        root.left = buildTreeChild(inOrder,postOrder,inBegin,rootIndex-1);

        return root;
    }

    public int findIndexOfInorder(int[] inOrder, int inBegin, int inEnd, int val) {
        for (int i = inBegin; i <= inEnd; i++) {
            if (inOrder[i] == val) {
                return i;
            }
        }
        return -1;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null) return null;
        if (inorder.length <= 0 || postorder.length <= 0) return null;
        postIndex = inorder.length - 1;
        return buildTreeChild(inorder,postorder,0,inorder.length-1);
    }
}

public class Solution {

    public int postIndex = 0;
    public TreeNode buildTreeChild(int[] inorder, int[] postorder, int inBegin, int inEnd) {
        if (inBegin > inEnd) return null;//没有节点了
        TreeNode root = new TreeNode(postorder[postIndex]);
        //2、找到当前根节点，在中序遍历当中的位置
        int rootIndex = findIndexOfInOrder(inorder,inBegin,inEnd,postorder[postIndex]);
        if (rootIndex == -1) return null;
        postIndex--;
        //rootIndex右边的是右树
        root.right = buildTreeChild(inorder,postorder,rootIndex + 1,inEnd);
        //rootIndex左边的是左树
        root.left = buildTreeChild(inorder,postorder,inBegin,rootIndex - 1);
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

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null) return null;//数组为空
        if (inorder.length <= 0 || postorder.length <= 0) return null;//数组不为空但是，数组里面没东西
        postIndex = inorder.length - 1;
        TreeNode root = buildTreeChild(inorder,postorder,0,inorder.length - 1);
        return root;
    }
}
