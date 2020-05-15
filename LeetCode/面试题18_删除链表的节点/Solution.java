package 面试题18_删除链表的节点;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/5/8 0:19
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode node = head;
        while (node.next != null) {
            if (val == node.next.val) {
                node.next = node.next.next;
                break;
            }else {
                node = node.next;
            }
        }
        if (val == head.val) {
            head = head.next;
        }
        return head;
    }
}
