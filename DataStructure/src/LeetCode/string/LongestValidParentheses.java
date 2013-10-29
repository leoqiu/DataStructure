package LeetCode.string;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 10/28/13
 *
 * http://oj.leetcode.com/problems/longest-valid-parentheses/
 *
 */


public class LongestValidParentheses {

    public int longestValidParenthesesDP(String s) {


        char[] chars = s.toCharArray();
        int n = chars.length;
        boolean[][] dp = new boolean[n][n];
        int maxLen = 0;

        if (n < 2)
            return maxLen;

        for (int len = 1; len <= n; len++) {

            int i = 0;
            int j = i+len-1;

            while (j < n) {

                if(len%2 == 1)
                    dp[i][j] = false;
                else {

                    if( (len == 2) && (chars[i] == '(' && chars[j] == ')' ) ){
                        dp[i][j] = true;
                        maxLen = Math.max(maxLen, len);
                    } else if ( (dp[i+1][j-1] && (chars[i] == '(' && chars[j] == ')' ) ) || (j >= 4 && dp[i][j-2] && dp[i+2][j]) ) {
                        dp[i][j] = true;
                        maxLen = Math.max(maxLen, len);
                    } else {
                        dp[i][j] = false;
                    }
                }

                i++;
                j = i+len-1;

            }
        }

        return maxLen;
    }


    public int longestValidParenthesesStack(String s) {


        int maxLen = 0, last = -1;
        Stack<Integer> lefts = new Stack<Integer>();
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                lefts.push(i);
            } else {
                if (lefts.isEmpty()) {
                    // no matching left
                    last = i;
                } else {
                    // find a matching pair
                    lefts.pop();
                    if (lefts.isEmpty()) {//有一个完整的valid的group。计算该group的长度
                        maxLen = Math.max(maxLen, i - last);
                    } else {
                        //栈内还有‘(',一个最外层完整的group还没有匹配完成，
                        //但是通过查询下一个即将匹配还未匹配的"("的index来更新maxLen。

                        int tmp = lefts.peek();
                        maxLen = Math.max(maxLen, i - lefts.peek());
                    }
                }
            }
        }
        return maxLen;
    }


    public static void main (String[] args) {
        LongestValidParentheses s = new LongestValidParentheses();
        //String str = "(()()())(";
        String str = "(()";

        System.out.print(s.longestValidParenthesesStack(str));
    }
}






























