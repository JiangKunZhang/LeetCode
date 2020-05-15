package q150_逆波兰表达式求值;

import java.util.Stack;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/5/15 17:00
 */
public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String s = tokens[i];
            if ( !s.equals("+") && !s.equals("-") && !s.equals("*") && !s.equals("/")) {
                stack.push(s);
            }else {
                if (!stack.empty()) {
                    int s2 = Integer.valueOf(stack.pop());
                    int s1 = Integer.valueOf(stack.pop());
                    int result = 0;
                    switch (s) {
                        case "+" : result = s1 + s2; break;
                        case "-" : result = s1 - s2; break;
                        case "*" : result = s1 * s2; break;
                        case "/" : result = s1 / s2; break;

                    }
                    stack.push(String.valueOf(result));
                }
            }
        }
        return Integer.valueOf(stack.peek());
    }

    public int evalRPN2(String[] tokens) {
        Stack<Integer> numStack = new Stack<>();
        Integer op1, op2;
        for (String s : tokens) {
            switch (s) {
                case "+":
                    op2 = numStack.pop();
                    op1 = numStack.pop();
                    numStack.push(op1 + op2);
                    break;
                case "-":
                    op2 = numStack.pop();
                    op1 = numStack.pop();
                    numStack.push(op1 - op2);
                    break;
                case "*":
                    op2 = numStack.pop();
                    op1 = numStack.pop();
                    numStack.push(op1 * op2);
                    break;
                case "/":
                    op2 = numStack.pop();
                    op1 = numStack.pop();
                    numStack.push(op1 / op2);
                    break;
                default:
                    numStack.push(Integer.valueOf(s));
                    break;
            }
        }
        return numStack.pop();
    }

}
