package LeetCode;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: leo
 * Date: 10/16/13
 *
 *
 * http://oj.leetcode.com/problems/3sum-closest/
 *
 */



public class ThreeSumClosest {




    public int threeSumClosest(int[] num, int target) {


        int n = num.length;
//        if (n == 3)
//            return num[0] + num[1] + num[2];


        Arrays.sort(num);
        int minDis = Integer.MAX_VALUE;
        int res = 0;

        for (int i = 0; i < n-2; i++) {

            int first = num[i];
            int diff = target-first;
            int left = i+1;
            int right = n-1;



            while (left < right) {

                int twoSum = (num[left] + num[right]);
                int threeSum = first + twoSum;
                int curDis = Math.abs(target - threeSum);

                if (curDis < minDis) {
                    minDis = curDis;
                    res = threeSum;
                }

                if (diff >= 0) {

                    if (twoSum == diff) {
                        return target;
                    } else if (twoSum > diff) {
                        right--;
                    } else {
                        left++;
                    }

                } else {

                    if (twoSum == diff)
                        return target;
                    else if (twoSum < diff ) {
                        left++;
                    } else {
                        right--;
                    }

                }
            }



        }

        return res;
    }


    public static void main (String[] args) {

        ThreeSumClosest s = new ThreeSumClosest();
        int[] num = {-1, 2, 0};
        System.out.println(s.threeSumClosest(num, 1));

    }



}
