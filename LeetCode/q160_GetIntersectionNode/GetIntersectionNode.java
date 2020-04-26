package q160_GetIntersectionNode;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/4/26 0:09
 *
 * 160.相交链表
 *
 * 编写一个程序，找到两个单链表相交的起始节点。
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //先定义两个节点，假设pL为长的，pS为短的
        ListNode pL = headA;
        ListNode pS = headB;
        int lenA = 0;
        int lenB = 0;
        ListNode cur = pL;//cur用来保存每个头节点
        //计算pL长度
        while (cur != null) {
            lenA++;
            cur = cur.next;
        }
        cur = pS;//cur用来保存每个头节点
        //计算pL长度
        while (cur != null) {
            lenB++;
            cur = cur.next;
        }
        //判断之前假设的长短是否正确，不正确就进行调换
        int len = lenA - lenB;//计算长的长多少
        if (len < 0) {
            len = lenB - lenA;//计算长的长多少
            pL = headB;
            pS = headA;
        }
        //让长的链表先往后走，走到一样长
        while (len != 0) {
            pL = pL.next;
            len--;
        }
        //此时在同一起跑线，一起往后走
        while (pL != pS && pL != null && pS != null) {
            pL = pL.next;
            pS = pS.next;
        }
        //判断上一个循环结束是因为什么，如果两个都不为空，就是说明两个相等，返回;
        if (pL != null && pS != null) {
            return pL;
        }
        //否则就是两个链表不相交
        return null;
    }
}
