package q206_ReverseList;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/4/24 23:40
 *
 * 206. 反转链表
 *
 * 反转一个单链表。
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class ReverseList {
    public ListNode reverseList(ListNode head) {
        //定义四个节点，cur不为空的时候再定义curNext
        ListNode prev = null;
        ListNode cur = head;
        ListNode newHead = null;
        while (cur != null) {
            ListNode curNext = cur.next;
            //如果cur.next == null，就是新的头节点，保存下来
            if (cur.next == null) {
                newHead = cur;
            }
            cur.next = prev;//先把cur.next指向先驱
            prev = cur;//先驱挪到后面一个
            cur = curNext;//cur也往后挪一个

        }
        return newHead;
    }

}

