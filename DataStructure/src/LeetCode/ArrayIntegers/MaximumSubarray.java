package LeetCode.ArrayIntegers;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 11/1/13
 *
 *  http://oj.leetcode.com/problems/maximum-subarray/
 *
 */


public class MaximumSubarray {


    public int maxSubArray2(int[] A) {

        int n = A.length;
        int[][] dp = new int[n][n];
        int maxSum = A[0];

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if(i == j){
                    dp[i][j] = A[i];
                }else {
                    dp[i][j] = dp[i][j-1] + A[j];
                }
                maxSum = Math.max(maxSum, dp[i][j]);
            }

        }

       return maxSum;
    }


    public int maxSubArray(int[] A) {

        int n = A.length;
        int maxSum = A[0];
        int curSum = A[0];

        for (int i = 1; i < n; i++) {


            curSum = curSum + A[i];
            maxSum = Math.max(Math.max(curSum, maxSum), A[i]);

            if (curSum < A[i])
                curSum = A[i];

        }

        return maxSum;
    }


    public static void main (String[] args) {

        MaximumSubarray s = new MaximumSubarray();
        //int[] A = {-2, 1, -3, 4, -1, 2, 1, -5,4};
        int[] A = {-2, 1};
        System.out.print(s.maxSubArray(A));

    }

}






















