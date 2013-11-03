package LeetCode.puzzle;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 11/1/13
 *
 * http://oj.leetcode.com/problems/jump-game/
 *
 */


public class JumpGame {


    public boolean canJump(int[] A) {

        int n = A.length;

        if(n==1)
            return true;

        int start = 0;
        int end = 0;
        int maxRange = 0;

        while (end < n) {

            end = start + A[start];

            for (int i = start; i <= end; i++) {
                int curRange = i + A[i];

                if(curRange >= n-1)
                    return true;

                if(curRange > maxRange){
                    start = i;
                    maxRange = curRange;
                }
            }

            if(end == maxRange)
                return false;
        }

        return false;
    }

    public static void main (String[] args) {

        //int[] A = {2,3,1,1,4,1,1,2,5,7,1,1,2,2,3,1,1,1,2};
        //int[] A = {2,3,1,1,4};
        //int[] A = {5,9,3,2,1,0,2,3,2,1,0,0};
        int[] A = {0,1};
        JumpGame s = new JumpGame();
        System.out.print(s.canJump(A));
    }

}
