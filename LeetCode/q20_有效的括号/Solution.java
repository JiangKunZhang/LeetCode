package q20_有效的括号;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/5/14 16:06
 */
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            }else {
                //1、判断栈是否为空
                if(stack.empty()) {
                    System.out.println("右括号多！");
                    return false;
                }
                //先拿到栈顶元素的括号
                char ch2 = stack.peek();
                if(ch2 == '(' && ch == ')'  || ch2 == '[' && ch == ']'
                        || ch2 == '{' && ch == '}') {
                    stack.pop();
                }else {
                    System.out.println("左右括号不匹配");
                    return false;
                }
            }
        }
        if (!stack.empty()) {
            System.out.println("左括号多！");
            return false;
        }
        return true;
    }
}
