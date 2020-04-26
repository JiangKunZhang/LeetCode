package q21_MergeTwoLists;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/4/26 0:06
 *
 * 21. 合并两个有序链表
 *
 *将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode headA, ListNode headB) {
        //定义一个虚拟头节点，不动
        ListNode newHead = new ListNode(-1);
        //往后动，相当于尾巴
        ListNode temp = newHead;
        //都不为空就进入循环，插进去
        while (headA != null && headB != null) {
            if (headA.val < headB.val) {
                temp.next = headA;
                headA = headA.next;
                temp = temp.next;
            }else {
                temp.next = headB;
                headB = headB.next;
                temp = temp.next;
            }
        }
        //如果headA空了，把headB剩下的插进来
        if (headA == null) {
            temp.next = headB;
        }
        //如果headB空了，把headA剩下的插进来
        if (headB == null) {
            temp.next = headA;
        }
        //返回虚拟节点的下一个节点
        return newHead.next;
    }
}
