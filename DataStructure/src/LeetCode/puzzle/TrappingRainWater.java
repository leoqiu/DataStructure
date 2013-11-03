package LeetCode.puzzle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 10/30/13
 *
 * http://oj.leetcode.com/problems/trapping-rain-water/
 *
 * http://fisherlei.blogspot.com/2013/01/leetcode-trapping-rain-water.html
 */


public class TrappingRainWater {

    public int trap(int[] A) {

        int n = A.length;

        if(n == 0)
            return 0;

        int[] leftHighest = new int[n];
        int[] rightHighest = new int[n];
        int area = 0;

        leftHighest[0] = 0;
        for (int i = 1; i < n; i++)
            leftHighest[i] = Math.max(leftHighest[i-1], A[i-1]);

        rightHighest[n-1] = 0;
        for (int i = n-2; i >= 0; i--) {
            rightHighest[i] = Math.max(rightHighest[i+1], A[i+1]);
            int curArea = Math.min(leftHighest[i], rightHighest[i]) - A[i];
            if(curArea > 0)
                area = area + curArea;
        }

        return area;
    }

    public static void main (String[] args) {
        TrappingRainWater s = new TrappingRainWater();
        int[] A = {0,1,0,2,1,0,1,3,2,1,2,1};

        System.out.print(s.trap(A));
    }


}




















