package 面试题0203_删除中间节点;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/5/5 20:42
 *
 * 面试题 02.03. 删除中间节点
 *
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    //方法：直接删除下一个结点。表面删除当前节点，实际删除下一个结点
    public void deleteNode(ListNode node) {
        //将下一个结点的值赋给当前节点，当前节点的下一个结点为下下一个结点
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
