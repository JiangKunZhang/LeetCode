package q24_两两交换链表中的节点;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/5/9 15:04
 *
 * 1.firstNode（即 A） 和 secondNode（即 B） 分别遍历偶数节点和奇数节点，即两步看作一步
 * 2.交换两个节点：
 * 3.还需要更新 prevNode.next 指向交换后的头。
 * 迭代完成后得到最终的交换结果
 *
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode prev = newHead;
        while (head != null && head.next != null) {
            ListNode first = head;
            ListNode second = head.next;

            prev.next = second;//把新的节点连起来
            first.next = second.next;//first和second互换
            second.next = first;

            prev = first;//prev往后移
            head = first.next;//head往后走两个
        }
        return newHead.next;
    }
}
