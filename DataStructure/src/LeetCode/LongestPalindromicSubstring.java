package LeetCode;

/**
 * Created with IntelliJ IDEA.
 * User: leo
 * Date: 10/15/13
 *
 *
 * http://oj.leetcode.com/problems/longest-palindromic-substring/
 */

public class LongestPalindromicSubstring {


    public String longestPalindrome(String s) {


        char[] chars = s.toCharArray();
        int n = chars.length;
        int[][] dpArr = new int[n][n];
        int maxLen = 0;
        int curLen;
        int left = 0;
        int right = 0;

        if(n==0)
            return null;


        for (int i = n-1; i >= 0; i--) {
            for (int j = n-1; j >= i; j--) {

                if (i == j) {
                    dpArr[i][j] = 1;
                    curLen = j-i+1;
                    if(maxLen < curLen) {
                        maxLen = curLen;
                        left = i;
                        right = j;
                    }
                } else if (j-i == 1) {

                    if(chars[i] == chars[j]) {
                        dpArr[i][j] = 1;
                        curLen = j-i+1;
                        if(maxLen < curLen) {
                            maxLen = curLen;
                            left = i;
                            right = j;
                        }
                    }

                }else {

                    if (dpArr[i+1][j-1] == 1 && chars[i] == chars[j]) {
                        dpArr[i][j] = 1;
                        curLen = j-i+1;
                        if(maxLen < curLen) {
                            maxLen = curLen;
                            left = i;
                            right = j;
                        }
                    }
                    else
                        dpArr[i][j] = 0;

                }

            }

        }

//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(dpArr[i][j] + " ");
//            }
//
//            System.out.println();
//        }

        return s.substring(left, right+1);
    }

    public static void main (String[] args) {

        LongestPalindromicSubstring s = new LongestPalindromicSubstring();
        //String str = "caabbaad";
        String str = "";

        System.out.println(s.longestPalindrome(str));



    }




}
