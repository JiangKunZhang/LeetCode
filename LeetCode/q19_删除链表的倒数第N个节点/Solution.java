package q19_删除链表的倒数第N个节点;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/5/5 23:10
 *
 * 19. 删除链表的倒数第N个节点
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //先定义一个虚拟节点来保存头节点，万一只有一个节点，要删除倒数第一个，不会空指针异常
        ListNode newHead = new ListNode(-1);
        ListNode fast = newHead;
        ListNode slow = newHead;
        newHead.next = head;
        //快指针走n步
        while (n != 0) {
            fast = fast.next;
            n--;
        }
        //然后一起走，fast.next == null 时
        //slow就是要删除的节点的前一个结点
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return newHead.next;
    }
}
