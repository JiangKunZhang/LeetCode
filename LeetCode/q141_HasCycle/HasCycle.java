package q141_HasCycle;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/4/26 0:12
 *
 * 141. 环形链表
 *
 * 给定一个链表，判断链表中是否有环。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class HasCycle {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast ==slow) {
                return true;
            }
        }
        return false;
    }
}
