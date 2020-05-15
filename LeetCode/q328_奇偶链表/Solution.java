package q328_奇偶链表;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/5/8 13:37
 *
 * 328. 奇偶链表
 *
 * 构造两个链表，奇链表、偶链表
 * 遍历原来的链表 奇的插入奇链表 偶的插入偶链表
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode odd = new ListNode(-1);
        ListNode even = new ListNode(-1);
        ListNode oddTail = odd;
        ListNode evenTail = even;
        ListNode cur = head;
        int i = 0;
        while (cur != null) {
            ++i;
            if (i % 2 == 1) {
                oddTail.next = cur;
                oddTail = oddTail.next;

            }
            if (i % 2 == 0) {
                evenTail.next = cur;
                evenTail = evenTail.next;
            }
            cur = cur.next;
        }
        //偶链表插入奇链表后面
        oddTail.next = even.next;
        //偶链表的尾巴置为空
        evenTail.next = null;
        return odd.next;
    }
}
