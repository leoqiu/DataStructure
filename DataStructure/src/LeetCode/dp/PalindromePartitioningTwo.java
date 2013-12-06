package LeetCode.dp;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 12/1/13
 * Time: 2:32 PM
 * To change this template use File | Settings | File Templates.
 */



public class PalindromePartitioningTwo {


    public int minCut(String s) {


        int len = s.length();
        int D[] = new int[len + 1];
        boolean[][] P = new boolean[len][len];
        //the worst case is cutting by each char
        for (int i = 0; i <= len; i++)
            D[i] = len - i;
        for (int i = 0; i < len; i++)
            for (int j = 0; j < len; j++)
                P[i][j] = false;
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || P[i + 1][j - 1])) {
                    P[i][j] = true;
                    D[i] = Math.min(D[i], D[j + 1] + 1);
                }
            }
        }
        return D[0] - 1;


    }




    public static void main (String[ ] args) {
        PalindromePartitioningTwo s = new PalindromePartitioningTwo();
        String str = "ababababababababababababcbabababababababababababa";

        System.out.print(s.minCut(str));

    }
}
