package q725_分隔链表;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/5/8 13:13
 *
 * 725. 分隔链表
 *
 * 长度/k 一块先放这么多
 * 如果有余数
 * 余数从头开始，一块加一个
 *
 * 如果链表有 NN 个结点，则分隔的链表中每个部分中都有 n/kn/k 个结点，且前 N\%kN%k 部分有一个额外的结点。我们可以用一个简单的循环来计算 NN。
 *
 * 现在对于每个部分，我们已经计算出该部分有多少个节点：width + (i < remainder ? 1 : 0)。我们创建一个新列表并将该部分写入该列表。
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    //长度/k 一块先放这么多
    //如果有余数
    //余数从头开始，一块加一个
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode cur = root;
        int length = 0;
        while (cur != null) {
            cur = cur.next;
            length++;
        }
        int width = length / k;//一块几个
        int range = length % k;//余数，余下的就是一块一个
        cur = root;
        ListNode[] listNodes = new ListNode[k];//每个元素都是头节点
        for (int i = 0; i < k; i++) {//k块
            ListNode head = new ListNode(-1);
            ListNode node = head;
            for (int j = 0; j < width+(i < range ? 1 : 0); j++) {//每块的个数
                node.next = new ListNode(cur.val);
                node = node.next;
                if (cur != null) cur = cur.next;
            }
            listNodes[i] = head.next;
        }
        return listNodes;
    }
}
