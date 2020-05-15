package q61_旋转链表;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/5/8 11:11
 *
 * 先将链表连成环
 * 然后断开找到新的头和尾
 *
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        if (head.next == null) return head;
        int n = 1;
        ListNode node = head;
        //计算链表长度并找到尾节点
        while (node.next != null) {
            n++;
            node = node.next;
        }
        node.next = head;//首尾相连
        ListNode newHead = head;
        ListNode newTail = head;
        //新的链表头是第 (n - k % n) 个节点
        //（n - k % n - 1）是尾巴
        for (int i = 0; i < n-k%n-1; i++) {
            newTail = newTail.next;
        }
        newHead = newTail.next;//保存新的头节点
        newTail.next = null;//设置为尾节点
        return newHead;
    }
}
