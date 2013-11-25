package LeetCode.string;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 11/7/13
 *
 * http://oj.leetcode.com/problems/simplify-path/
 *
 */



public class SimplifyPath {


    public String simplifyPath(String path) {

        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<String>();
        String[] strs = path.split("/");

        for (int i = 0; i < strs.length; i++) {

            String cur = strs[i];

            if(!cur.equals("")) {
                if(cur.equals("/") || cur.equals("."))
                    ;
                else if (!stack.isEmpty() && cur.equals(".."))
                    stack.pop();
                else if (stack.isEmpty() && cur.equals(".."))
                    ;
                else
                    stack.push(cur);
            }
        }

        for (int i = 0; i < stack.size(); i++) {
            String cur = stack.get(i);
            if(!cur.equals(""))
                sb.append("/").append(cur);
        }

        if(stack.isEmpty())
            return "/";
        else
            return sb.toString();

    }



    public static void main (String[] args) {

        String str = "/..";

        SimplifyPath s = new SimplifyPath();
        System.out.print(s.simplifyPath(str));

    }
}
