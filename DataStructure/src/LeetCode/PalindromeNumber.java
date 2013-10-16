package LeetCode;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 10/15/13
 *
 * http://oj.leetcode.com/problems/palindrome-number/
 */


public class PalindromeNumber {


    public boolean isPalindrome(int x) {

        int n = String.valueOf(x).length();
        int curZeroNums = n-1;

        if (x < 0)
            return false;

        if (n%2 == 0) {

            while (curZeroNums >= 1) {

                int divisor = (int)Math.pow(10, curZeroNums);
                int left = x / divisor;
                int right = x % 10;

                if(left != right)
                    return false;

                x = (x - left*divisor - right) / 10;
                curZeroNums = curZeroNums - 2;
            }


        } else {

            while (curZeroNums >= 2) {

                int divisor = (int)Math.pow(10, curZeroNums);
                int left = x / divisor;
                int right = x % 10;

                if(left != right)
                    return false;

                x = (x - left*divisor - right) / 10;
                curZeroNums = curZeroNums - 2;
            }

        }

        return true;
    }

    public boolean isPalindrome2(int x) {

        if (x < 0)
            return false;

        char[] chars = String.valueOf(x).toCharArray();

        int n = chars.length;
        int left = 0;
        int right = n-1;

        while (left < right) {

            if (chars[left] != chars[right])
                return false;

            left++;
            right--;

        }


        return true;
    }


    public static void main (String[] args) {
        PalindromeNumber s = new PalindromeNumber();
        System.out.println(s.isPalindrome2(1290550921));
    }

}














