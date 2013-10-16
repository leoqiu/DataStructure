package LeetCode;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 10/15/13
 *
 * http://oj.leetcode.com/problems/reverse-integer/
 */

public class ReverseInteger {

    public int reverse(int x) {
        String res = "";
        if (x>0) {

            String str = String.valueOf(x);


            int n = str.length();
            for (int i = n-1; i >= 0; i--) {
                res += str.charAt(i);
            }

            return Integer.parseInt(res);
        } else if (x<0) {
            String str = String.valueOf(-x);


            int n = str.length();
            for (int i = n-1; i >= 0; i--) {
                res += str.charAt(i);
            }

            return -Integer.parseInt(res);
        } else
            return 0;
    }

    public static void main (String[] args) {

        ReverseInteger s = new ReverseInteger();

        System.out.println(s.reverse(-321));

    }


}

























