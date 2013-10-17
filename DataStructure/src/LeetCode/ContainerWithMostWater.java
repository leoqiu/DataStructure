package LeetCode;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 10/16/13
 *
 * http://oj.leetcode.com/problems/container-with-most-water/
 *
 */
public class ContainerWithMostWater {


    //O(n^2)
    public int maxArea(int[] height) {

        int maxArea = 0;
        int n = height.length;

        for (int i = 0; i < n; i++) {

            int curHeight = height[i];
            int curWidth = 0;

            if(curHeight == 0)
                continue;

            for (int j = i+1; j < n; j++) {
                int nextHeight = height[j];
                if(nextHeight >= curHeight) {
                    curWidth++;
                    maxArea = Math.max(maxArea, curHeight*curWidth);
                } else {
                    curWidth = -1;
                }
            }
        }

        return maxArea;
    }

    public int maxArea2(int[] height) {

        int maxArea = 0;
        int n = height.length;
        int left = 0;
        int right = n-1;

        while (left < right) {

            if (height[left] < height[right]) {
                maxArea = Math.max(maxArea, height[left]*(right - left));
                left++;
            } else {
                maxArea = Math.max(maxArea, height[right]*(right - left));
                right--;
            }

        }

        return maxArea;
    }



    public static void main (String[] args) {
        ContainerWithMostWater s = new ContainerWithMostWater();
        int[] heights = {1,2,3,0,4,6,5};
        //int[] heights = {0,0,0,0,4,6,5};
        System.out.println(s.maxArea(heights));

    }

}







