package q641_设计循环双端队列;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/5/15 23:30
 */
public class MyCircularDeque {
    public int[] elem;
    public int front;
    public int rear;
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        this.elem = new int[k + 1];
        front = 0;
        rear = 0;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        while (isFull()) {
            return false;
        }
        this.front = (this.front + this.elem.length - 1) % this.elem.length;
        this.elem[front] = value;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        while (isFull()) {
            return false;
        }
        this.elem[this.rear] = value;
        this.rear = (this.rear + 1) % this.elem.length;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        this.front = (this.front + 1) % this.elem.length;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        this.rear = (this.rear + this.elem.length - 1) % this.elem.length;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return this.elem[this.front];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        if (this.rear == 0) {
            return this.elem[this.elem.length - 1];
        }
        return this.elem[this.rear - 1];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        if (this.front == this.rear) {
            return true;
        }
        return false;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        if ((this.rear + 1) % this.elem.length == this.front) {
            return true;
        }
        return false;
    }
}
