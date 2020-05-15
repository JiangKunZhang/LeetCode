package q155_最小栈;

import java.util.Stack;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/5/14 23:19
 */
public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.empty()) {
            minStack.push(x);
        }else {
            int top = minStack.peek();
            if (x <= top) {
                minStack.push(x);
            }
        }
    }

    public void pop() {
        if (!stack.empty()) {
            int temp = stack.pop();
            if (temp == minStack.peek()) {
                minStack.pop();
            }
        }
    }

    public int top() {
        if (stack.empty()) {
            return -1;
        }
        return stack.peek();
    }

    public int getMin() {
        if (minStack.empty()) {
            return -1;
        }
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
