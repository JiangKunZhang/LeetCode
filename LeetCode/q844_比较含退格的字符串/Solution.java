package q844_比较含退格的字符串;

import java.util.Stack;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/5/15 22:57
 */
public class Solution {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (ch == '#') {
                if (!stack1.empty())
                    stack1.pop();
            }else {
                stack1.push(ch);
            }
        }
        for (int i = 0; i < T.length(); i++) {
            char ch = T.charAt(i);
            if (ch == '#') {
                if (!stack2.empty())
                    stack2.pop();
            }else {
                stack2.push(ch);
            }
        }
        //i.可以
        /*while (!stack1.empty() && !stack2.empty()) {
            if (stack1.peek() == stack2.peek()) {
                stack1.pop();
                stack2.pop();
            }else {
                return false;
            }
        }
        if (stack1.empty() && stack2.empty()) {
            return true;
        }
        return false;*/

        //2.也可以
        return String.valueOf(stack1).equals(String.valueOf(stack2));

    }
}
