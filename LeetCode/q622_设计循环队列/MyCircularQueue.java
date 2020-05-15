package q622_设计循环队列;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/5/14 18:15
 */
class MyCircularQueue {
    public int[] elem;
    public int front;
    public int rear;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        this.elem = new int[k];//k+1  在oj上跑的时候
        this.front = 0;
        this.rear = 0;

    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        this.elem[rear] = value;
        this.rear = (this.rear + 1) % this.elem.length;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        this.front = (this.front + 1) % this.elem.length;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return this.elem[front];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        int rear = this.rear == 0 ? this.elem.length - 1 : this.rear - 1;
        return this.elem[rear];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        if (this.front == this.rear) {
            return true;
        }
        return false;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        if ((this.rear + 1) % this.elem.length == this.front) {
            return true;
        }
        return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */