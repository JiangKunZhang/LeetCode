package q682_棒球比赛;

import java.util.Stack;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/5/15 18:19
 */
public class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        for (String s : ops) {
            if (s.equals("+")) {
                int top = stack.pop();
                int newTop = top + stack.peek();
                stack.push(top);
                stack.push(newTop);
            }else if (s.equals("C")) {
                stack.pop();
            }else if (s.equals("D")) {
                stack.push(stack.peek() * 2);
            }else {
                stack.push(Integer.valueOf(s));
            }
        }
        int ret = 0;
        for (int r : stack) {
            ret += r;
        }
        return ret;
    }
}
