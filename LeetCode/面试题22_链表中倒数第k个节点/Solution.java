package 面试题22_链表中倒数第k个节点;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/5/8 0:08
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        //定义快慢指针
        ListNode fast = head;
        ListNode slow = head;
        //快的先走k-1步
        while (k-1 != 0) {
            fast = fast.next;
            k--;
        }
        //然后快慢一起走，当fast.next == null的时候，slow就是结果
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
