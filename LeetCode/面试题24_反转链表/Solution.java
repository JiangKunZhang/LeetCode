package 面试题24_反转链表;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/5/8 0:15
 *
 * 面试题24. 反转链表
 *
 *定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode newHead = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode curNext = cur.next;
            if (cur.next == null) {
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return newHead;
    }
}
