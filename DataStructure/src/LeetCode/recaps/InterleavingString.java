package LeetCode.recaps;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 12/16/13
 *
 * http://oj.leetcode.com/problems/interleaving-string/
 *
 */

public class InterleavingString {


    public boolean isInterleave(String s1, String s2, String s3) {

        boolean[][] dp = new boolean[2][2];


        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[i].length; j++)
                System.out.print(dp[i][j]+" ");
            System.out.println();
        }

        return false;
    }



    public static void main (String[] args) {
        InterleavingString s = new InterleavingString();
        s.isInterleave("", "", "");


    }

}
