package q705_设计哈希集合;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/5/30 22:01
 */
public class MyHashSet {
    static class Node {
        public int val;
        public Node next;
        public Node(int val) {
            this.val = val;
        }
    }
    public Node[] array;
    public int usedSize;
    /** Initialize your data structure here. */
    public MyHashSet() {
        this.array = new Node[10];
        this.usedSize = 0;
    }

    public void add(int key) {
        int index = key % this.array.length;
        for (Node cur = array[index]; cur != null; cur = cur.next) {
            if(cur.val == key) {
                return;
            }
        }
        Node node = new Node(key);
        node.next = array[index];
        array[index] = node;
        this.usedSize++;
        if (loadFactor() > 0.75) {
            resize();
        }

    }

    public void resize() {
        Node[] newArray = new Node[this.array.length * 2];
        for (int i = 0; i < this.array.length; i++) {
            Node cur = this.array[i];
            while (cur != null) {
                Node curNext = cur.next;
                int newIndex = cur.val % newArray.length;
                cur.next = newArray[newIndex];
                newArray[newIndex] = cur;
                cur = curNext;
            }
        }
        this.array = newArray;
    }

    public double loadFactor() {
        return (this.usedSize * 1.0) / this.array.length;
    }

    public void remove(int key) {
        if (!contains(key)) return;
        int index = key % this.array.length;
        Node head = array[index];
        if (head.val == key) {
            this.array[index] = this.array[index].next;
            this.usedSize--;
            return;
        }
        Node prev = findPrev(head,key);
        if (prev == null) {
            return;
        }
        prev.next = prev.next.next;
        this.usedSize--;
    }

    public Node findPrev(Node head, int val) {
        Node prev = head;
        while (prev.next != null) {
            if (prev.next.val == val) {
                return prev;
            }else {
                prev = prev.next;
            }
        }
        return null;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index = key % this.array.length;
        Node cur = this.array[index];
        while (cur != null) {
            if (cur.val == key) {
                return true;
            }else {
                cur = cur.next;
            }
        }
        return false;
    }

}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */