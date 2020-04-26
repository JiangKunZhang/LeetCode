package q203_RemoveElements;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/4/24 23:20
 *
 * 203. 移除链表元素
 *
 * 删除链表中等于给定值 val 的所有节点。
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
 }
public class $203_RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        //如果链表为空，return
        if (head == null) {
            return null;
        }

        ListNode prev = head;//定义一个先驱
        ListNode cur = head;//定义一个要删除的节点
        //把除了头节点之外的要删除的节点先删除完
        while (cur != null) {
            if (cur.val == val) {
                prev.next = cur.next;
                cur = cur.next;
            }else {
                prev = cur;
                cur = cur.next;
            }
        }
        //判断头节点是不是要删除的
        if (head.val == val) {
            head = head.next;
        }
        return head;
    }
}
