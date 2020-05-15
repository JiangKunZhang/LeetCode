package q234_回文链表;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/5/9 23:43
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public boolean isPalindrome(ListNode head) {
        //如果链表为空那么是回文
        if (head == null) {
            return true;
        }
        //如果只有一个节点那么就是回文
        if (head.next == null) {
            return true;
        }
        //找到中间节点slow
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //从slow开始进行反转链表
        ListNode cur = slow.next;
        while (cur != null) {
            ListNode curNext = cur.next;
            cur.next = slow;
            slow = cur;
            cur = curNext;
        }
        //从前往后，从后往前走，中间没return就说明都相等
        while (head != slow) {
            //不相等return false
            if (head.val != slow.val) {
                return false;
            }
            //判断偶数情况
            if (head.next == slow) {
                return true;
            }
            //slow往前走，head往后走
            head = head.next;
            slow = slow.next;
        }
        return true;
    }
}
