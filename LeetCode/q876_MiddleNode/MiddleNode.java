package q876_MiddleNode;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/4/26 0:02
 *
 * 876. 链表的中间结点
 *
 * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 *
 * 如果有两个中间结点，则返回第二个中间结点。
 *
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class MiddleNode {
    public ListNode middleNode(ListNode head) {
        //定义快慢节点
        ListNode fast = head;
        ListNode slow = head;
        //如果fast == null || fast.next == null就终止循环
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //返回slow
        return slow;
    }
}
