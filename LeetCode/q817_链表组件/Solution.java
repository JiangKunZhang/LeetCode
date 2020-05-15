package q817_链表组件;

import java.util.HashSet;
import java.util.Set;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/5/6 15:37
 *
 * 我们对链表进行一次扫描，一个组件在链表中对应一段极长的连续节点，因此如果当前的节点在列表 G 中，并且下一个节点不在列表 G 中，
 * 我们就找到了一个组件的尾节点，可以将答案加 1。
 *
 * 例如，当链表为 0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7，G 为 [0, 2, 3, 5, 7] 时，
 * 我们扫描之后可以发现 0, 3, 5, 7 四个节点是组件的尾节点，那么答案就为 4。
 *
 *
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public int numComponents(ListNode head, int[] G) {
        Set<Integer> Gset = new HashSet<>();
        for (int x : G) {
            Gset.add(x);
        }
        ListNode cur = head;
        int ans = 0;
        while (cur != null) {
            if (Gset.contains(cur.val) && (cur.next == null || !Gset.contains(cur.next.val))) {
                ans++;
            }
            cur = cur.next;
        }
        return ans;
    }
}
