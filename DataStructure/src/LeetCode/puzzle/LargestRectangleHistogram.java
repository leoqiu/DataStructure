package LeetCode.puzzle;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 11/13/13
 *
 * http://oj.leetcode.com/problems/largest-rectangle-in-histogram/
 *
 */

/**
 * http://www.cnblogs.com/lichen782/p/leetcode_Largest_Rectangle_in_Histogram.html
 *
 * 维护一个递增的stack
 *
 */

public class LargestRectangleHistogram {


    public int largestRectangleArea(int[] height) {

        if(height.length == 0)
            return 0;

        int left = 0;
        int right = 0;
        int curMinHeight = height[0];
        int maxArea = -1;

        while (right < height.length) {

            int curLen = right-left+1;
            int curHeight = height[right];
            curMinHeight = Math.min(curHeight, curMinHeight);
            int curArea = curMinHeight*curLen;

            if(curArea > maxArea)
                maxArea = curArea;

        }


        return 0;
    }


}

















