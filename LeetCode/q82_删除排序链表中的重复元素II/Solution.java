package q82_删除排序链表中的重复元素II;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/5/9 23:24
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode newHead = new ListNode(-1);//定义虚拟节点
        ListNode temp = newHead;//保存尾部
        ListNode cur = head;
        //遍历完整个链表
        while (cur != null) {
            //如果重复
            if (cur.next != null &&(cur.val == cur.next.val)) {
                //如果连续重复
                while (cur.next != null &&(cur.val == cur.next.val)) {
                    cur = cur.next;
                }
                //把重复的节点也删掉，重复的节点不保留
                cur = cur.next;//多走一步
            }else {//否则不重复就往temp后面插
                temp.next = cur;
                temp = cur;
                cur = cur.next;
            }
        }
        //手动把最后的尾巴置为空
        temp.next = null;
        //返回头节点
        return newHead.next;
    }
}
