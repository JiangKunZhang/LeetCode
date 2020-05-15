package q707_设计链表;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/5/7 22:51
 */

class Node {
    int data;
    Node next;
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class MyLinkedList {
    Node head = null;

    private int size() {
        int size = 0;
        Node cur = this.head;
        while (cur != null) {
            size++;
            cur = cur.next;
        }
        return size;
    }

    /** Initialize your data structure here. */
    public MyLinkedList() {
        this.head = null;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        //index合法性判断
        if (index >= this.size() || index < 0) {
            return -1;
        }
        Node cur = head;
        while (index != 0) {
            cur = cur.next;
            index--;
        }
        return cur.data;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node node = new Node(val);
        //如果链表空
        if (this.head == null) {
            this.head = node;
            return;
        }
        node.next = this.head;
        this.head = node;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node node = new Node(val);
        //如果链表空
        if (this.head == null) {
            this.head = node;
            return;
        }
        Node cur = this.head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
    }

    //找前驱
    private Node searchPrev(int index) {
        Node cur = this.head;
        while (index-1 != 0) {
            cur = cur.next;
            index--;
        }
        return cur;
    }

    /** Add a node of value val before the index-th node in the linked list.
     * If index equals to the length of linked list, the node will be appended to the end of linked list.
     * If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        //index合法性判断
        if (index > this.size() || index < 0) {
            return;
        }
        //头插
        if (index == 0) {
            addAtHead( val);
            return;
        }
        //尾插
        if (index == this.size()) {
            addAtTail(val);
            return;
        }

        Node node = new Node(val);
        Node cur = searchPrev(index);//找前驱
        node.next = cur.next;//插入
        cur.next = node;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        //index合法性判断
        if (index < 0 || index >= this.size()) {
            return;
        }
        Node cur = this.head;
        //如果删除的是头节点
        if (index == 0) {
            this.head = this.head.next;
            return;
        }
        //找前驱
        while (index-1 != 0) {
            cur = cur.next;
            index--;
        }
        //删除
        cur.next = cur.next.next;
    }

    public void display() {
        Node cur = this.head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
