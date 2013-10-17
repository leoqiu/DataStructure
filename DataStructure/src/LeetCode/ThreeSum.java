package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 10/16/13
 *
 * http://oj.leetcode.com/problems/3sum/
 *
 */


public class ThreeSum {



    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {

        ArrayList<ArrayList<Integer>> listOfIntegers = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        int n = num.length;

        if (n < 3)
            return listOfIntegers;


        for (int i = 0; i <= n-3; i++) {

            // improved!!!
            // remove all zeros possibility
            if (i > 0 && num[i] == num[i - 1]) continue;

            int first = num[i];
            int left = i+1;
            int right = n-1;

            while (left < right) {

                if(num[left] + num[right] > -first)
                    right--;
                else if (num[left] + num[right] < -first)
                    left++;
                else {
                    ArrayList<Integer> integers = new ArrayList<Integer>();
                    integers.add(first);
                    integers.add(num[left]);
                    integers.add(num[right]);

                    listOfIntegers.add(integers);
                    left++;
                    right--;

                    //improved!!!
                    while(left<right && num[left]==num[left-1]) left++;
                    while(left<right && num[right]==num[right+1])  right--;
                    // improved!!!
                }

            }
        }

        return listOfIntegers;
    }


    public static void main (String[] args) {

        ThreeSum s = new ThreeSum();
        //int[] num = {-2,0,1,1,2};
        int[] num = {0,0,0,0,0,0,0,0,0};
        System.out.println(s.threeSum(num));

    }

}





















