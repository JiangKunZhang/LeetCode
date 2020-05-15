package q445_两数相加2;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/5/7 23:41
 *
 * 445.两数相加 II
 *
 * 先反转要加的链表链表
 * 再求和
 * 再反转结果链表
 *
 * （如果不能逆序节点，那就用栈存起来）
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    private ListNode resverse(ListNode listNode) {
        ListNode prev = null;
        ListNode newHead = null;
        ListNode cur = listNode;
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newL1 = resverse(l1);
        ListNode newL2 = resverse(l2);
        ListNode newHead = new ListNode(-1);
        ListNode cur = newHead;
        int curry = 0;
        while (newL1 != null || newL2 != null) {
            int x = newL1 != null ? newL1.val : 0;
            int y = newL2 != null ? newL2.val : 0;
            int sum = x + y + curry;
            curry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (newL1 != null) newL1 = newL1.next;
            if (newL2 != null) newL2 = newL2.next;

        }
        if (curry > 0) {
            cur.next = new ListNode(curry);
        }
        return resverse(newHead.next);
    }
}
