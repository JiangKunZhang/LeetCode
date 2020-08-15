package q138_复制带随机指针的链表;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/5/28 19:11
 */

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return head;
        Map<Node,Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            map.put(cur,new Node(cur.val));
            cur = cur.next;
        }
        //说明新的节点和老的节点映射关系全部处理完成
        cur = head;
        //得到对应的映射关系
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }

        return map.get(head);
    }
}
