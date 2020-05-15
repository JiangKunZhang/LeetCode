package q83_删除排序链表中的重复元素;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/5/9 18:30
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }

        return head;
    }
}
