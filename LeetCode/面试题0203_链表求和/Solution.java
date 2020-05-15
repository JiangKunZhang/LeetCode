package 面试题0203_链表求和;

import java.util.List;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/5/5 22:38
 */

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(-1);
        ListNode cur = newHead;
        int curry = 0;
        while (l1 != null || l2 != null) {
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;
            int sum = x + y + curry;
            curry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;

        }
        if (curry > 0) {
            cur.next = new ListNode(curry);
        }
        return newHead.next;
    }
}