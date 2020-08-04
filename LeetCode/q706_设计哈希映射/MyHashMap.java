package q706_设计哈希映射;


/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/5/30 23:15
 */
public class MyHashMap {

    static class Node {
        public int key;
        public int val;
        public Node next;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    public Node[] array;
    public int usedSize;
    /** Initialize your data structure here. */
    public MyHashMap() {
        this.array = new Node[10];
        this.usedSize = 0;
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = key % array.length;
        Node cur= this.array[index];
        while (cur != null) {
            if (cur.key == key) {
                cur.val = value;
                return;
            }
            cur = cur.next;
        }
        Node node = new Node(key,value);
        node.next = this.array[index];
        this.array[index] = node;
        this.usedSize++;
    }

    public double loadFactor() {
        return (this.usedSize * 1.0) / this.array.length;
    }

    public void resize() {
        Node[] newArray = new Node[this.array.length * 2];
        for (int i = 0; i < array.length; i++) {
            Node cur = array[i];
            while (cur != null) {
                int newIndex = cur.key % newArray.length;
                Node curNext = cur.next;
                cur.next = newArray[newIndex];
                newArray[newIndex] = cur;
                cur = curNext;
            }
        }
        this.array = newArray;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = key % array.length;
        Node cur = this.array[index];
        while (cur != null) {
            if (cur.key == key) {
                return cur.val;
            }
            cur = cur.next;
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        if (!contains(key)) {
            return;
        }
        int index = key % this.array.length;
        Node head = array[index];
        if (head.key == key) {
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

    public Node findPrev(Node head, int key) {
        Node prev = head;
        while (prev.next != null) {
            if (prev.next.key == key) {
                return prev;
            }else {
                prev = prev.next;
            }
        }
        return null;
    }

    public boolean contains(int key) {
        int index = key % this.array.length;
        Node cur = array[index];
        while (cur != null) {
            if (cur.key == key) {
                return true;
            }else {
                cur = cur.next;
            }
        }
        return false;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */