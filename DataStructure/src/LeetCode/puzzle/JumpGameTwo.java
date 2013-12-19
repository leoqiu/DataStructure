package LeetCode.puzzle;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 10/30/13
 *
 *  http://oj.leetcode.com/problems/jump-game-ii/
 *
 */


public class JumpGameTwo {



    public int jump(int[] A) {

        int start = 0;
        int end = 0;
        int jumps = 0;

        int n = A.length;

        if(n <= 1)
            return 0;

        while (end < n) {

            jumps++;
            int curMax = 0;

            for (int i = start; i <= end; i++) {

               if (A[i] + i >= n-1)
                   return jumps;

               if (i + A[i] > curMax)
                   curMax = i + A[i];
            }

            start = end+1;
            end = curMax;

            if(start > end)
                return -1;

System.out.println(start + "," +  end);

        }

        return 0;

    }




    public static void main (String[] args) {

        //int[] A = {2,3,1,1,4,1,1,2,5,7,1,1,2,2,3,1,1,1,2};
        //int[] A = {2,3,1,1,4};
        int[] A = {5,9,3,2,1,0,2,3,3,1,0,0,0};
        //int[] A = {0,1};
        JumpGameTwo s = new JumpGameTwo();
        System.out.print(s.jump(A));
    }

}
