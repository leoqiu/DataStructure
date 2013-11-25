package LeetCode.dp;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 11/3/13
 *
 * http://oj.leetcode.com/problems/unique-paths/
 *
 *
 * DP
 */


public class UniquePaths {



    public static int pathNum = 0;
    public int uniquePaths(int m, int n) {

        int endX = m-1;
        int endY = n-1;

        int startX = 0;
        int startY = 0;

        probePaths(startX, startY, endX, endY, m, n);

        return pathNum;
    }

    private void probePaths (int startX, int startY, int endX, int endY, int m, int n) {

        if(startX == endX && startY == endY) {
            pathNum++;
            return;
        }

        if (startX < m-1)
            probePaths(startX+1, startY, endX, endY, m, n);

        if (startY < n-1)
            probePaths(startX, startY+1, endX, endY, m, n);

    }

    public int uniquePathsDP (int m, int n) {

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if(i == 0 || j == 0)
                    dp[i][j] = 1;
                else
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }

    public static void main (String[] args) {

        UniquePaths s = new UniquePaths();
        System.out.print(s.uniquePaths(3, 7));
    }


}






















