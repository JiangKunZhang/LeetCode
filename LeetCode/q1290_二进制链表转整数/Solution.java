package q1290_二进制链表转整数;

import java.util.ArrayList;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/5/6 17:17
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    //方法1
    public int getDecimalValue(ListNode head) {
        int index = 0;
        //先存起来
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        while (head != null) {
            arrayList.add(head.val);
            index++;
            head = head.next;
        }
        //反着遍历
        int ans = 0;
        int pos = 0;
        while (index-- != 0) {
            ans += arrayList.get(index) * Math.pow(2,pos);
            pos++;
        }
        return ans;
    }

    //方法2
    public int getDecimalValue2(ListNode head) {
        //链表右移，相当于二进制数左移
        int ans = 0;
        while (head != null) {
            ans = ans * 2 + head.val;
            head = head.next;
        }
        return ans;
    }

}