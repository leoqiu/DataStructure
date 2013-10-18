package LeetCode;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 10/17/13
 *
 * http://oj.leetcode.com/problems/valid-parentheses/
 *
 */


public class ValidParentheses{

    public boolean isValid(String s) {


        if (s == null)
            return false;

        char[] chars = s.toCharArray();
        if (chars.length == 0)
            return true;

        Stack<Character> stack = new Stack<Character>();
        stack.push(chars[0]);

        for (int i = 1; i < chars.length; i++) {
            char curC = chars[i];
            if ( !stack.isEmpty() && ( (curC == '(' && stack.peek() == ')') || (curC == ')' && stack.peek() == '(')
                    || (curC == '[' && stack.peek() == ']') || (curC == ']' && stack.peek() == '[')
                    || (curC == '{' && stack.peek() == '}') || (curC == '}' && stack.peek() == '{')) ) {
                stack.pop();
            } else
                stack.push(curC);
        }

        if(stack.size() == 0)
            return true;
        else
            return false;
    }

    public static void main (String[] args) {
        ValidParentheses s = new ValidParentheses();

        String str = "()[]{}";
        System.out.print(s.isValid(str));

    }

}























