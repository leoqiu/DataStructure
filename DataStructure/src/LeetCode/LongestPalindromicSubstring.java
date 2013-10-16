package LeetCode;

/**
 * Created with IntelliJ IDEA.
 * User: leo
 * Date: 10/15/13
 *
 *
 * http://oj.leetcode.com/problems/longest-palindromic-substring/
 *
 * Solutions:
 * http://gongxuns.blogspot.com/2012/12/solution1-on2-on2-public-class-solution.html
 */

public class LongestPalindromicSubstring {

    //use int[][] as DP array
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

        if(n==2 && chars[0] == chars[1])
            return s;

        for (int i = n-1; i >= 0; i--) {
            for (int j = n-1; j >= i; j--) {

                if (i == j) {
                    dpArr[i][j] = 1;

                } else if (j-i == 1) {
                    curLen = j-i+1;
                    if(chars[i] == chars[j])
                        dpArr[i][j] = 1;
                    if(dpArr[i][j] == 1 && maxLen < curLen) {
                        maxLen = curLen;
                        left = i;
                        right = j;
                    }

                }else {
                    curLen = j-i+1;
                    if (dpArr[i+1][j-1] == 1 && chars[i] == chars[j]) {
                        dpArr[i][j] = 1;

                        if( maxLen < curLen) {
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

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(dpArr[i][j] + " ");
            }

            System.out.println();
        }

        return s.substring(left, right+1);
    }

    //use boolean[][] as DP array
    public String longestPalindrome3(String s) {

        char[] chars = s.toCharArray();
        int n = chars.length;
        boolean[][] dpArr = new boolean[n][n];
        int maxLen = 0;
        int curLen;
        int left = 0;
        int right = 0;

        if(n==0)
            return null;

        if(n==2 && chars[0] == chars[1])
            return s;

        for (int i = n-1; i >= 0; i--) {
            for (int j = n-1; j >= i; j--) {

                if (i == j) {
                    dpArr[i][j] = true;

                } else if (j-i == 1) {
                    curLen = j-i+1;
                    dpArr[i][j] = chars[i] == chars[j];
                    if(dpArr[i][j] && maxLen < curLen) {
                        maxLen = curLen;
                        left = i;
                        right = j;
                    }

                }else {
                    curLen = j-i+1;
                    if (dpArr[i+1][j-1] == true && chars[i] == chars[j]) {
                        dpArr[i][j] = true;

                        if(dpArr[i][j] && maxLen < curLen) {
                            maxLen = curLen;
                            left = i;
                            right = j;
                        }
                    }
                    else
                        dpArr[i][j] = false;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(dpArr[i][j] + " ");
            }

            System.out.println();
        }

        return s.substring(left, right+1);
    }


    public String longestPalindrome2(String s) {

        boolean[][] isPalindrome = new boolean[s.length()][s.length()];

        for(int j=0;j<s.length();j++){
            for(int i=0;i<s.length();i++){
                if(i+j>=s.length())
                    continue;
                if(j==0)
                    isPalindrome[i][i+j]=true;
                else if(j==1)
                    isPalindrome[i][i+j]=(s.charAt(i+j)==s.charAt(i));
                else
                    isPalindrome[i][i+j]=(s.charAt(i+j)==s.charAt(i)) && isPalindrome[i+1][i+j-1];
            }
        }

        for (int i = 0; i < s.length(); i++) {
            for  (int j = 0; j < s.length(); j++)
                System.out.print(isPalindrome[i][j]);

            System.out.println();
        }

        String res = "";
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                if(isPalindrome[i][j])
                    if(res.length()<j-i+1)
                        res=s.substring(i,j+1);
            }
        }
        return res;
    }


    public static void main (String[] args) {

        LongestPalindromicSubstring s = new LongestPalindromicSubstring();
        //String str = "caabbaad";
        String str = "ccd";

        System.out.println(s.longestPalindrome(str));

    }




}
