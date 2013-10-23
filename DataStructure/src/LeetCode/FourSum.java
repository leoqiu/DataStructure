package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: leo
 * Date: 10/16/13
 *
 *
 * http://oj.leetcode.com/problems/4sum/
 *
 * http://blog.unieagle.net/2012/08/28/leetcode%E9%A2%98%E7%9B%AE%EF%BC%9A4sum/
 *
 */


public class FourSum {




    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {

        int n = num.length;
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> listQuads = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < n-3; i++) {
            for (int j = i+1; j< n-2; j++) {

//                if (j > 1 && num[j] == num[j-1])
//                    continue;

                int first = num[i];
                int sec = num[j];
                int left = j+1;
                int right = n-1;


                while (left < right) {
                    int diff = target - (first+sec+num[left]+num[right]);

                    if (diff > 0)
                        left++;
                    else if (diff < 0)
                        right--;
                    else {

                        if (!isExits(first, sec, num[left], num[right], listQuads)) {
                            ArrayList<Integer> quad = new ArrayList<Integer>();
                            quad.add(first);
                            quad.add(sec);
                            quad.add(num[left]);
                            quad.add(num[right]);
                            listQuads.add(quad);
                       }

                        left++;
                        right--;

//                       while (left<right && num[left] == num[left-1])
//                           left++;
//                       while (left<right && num[right] == num[right+1])
//                           right--;
                    }
                }

            }
        }

        return listQuads;
    }

    private boolean isExits(int first , int sec, int third, int fourth, ArrayList<ArrayList<Integer>> listQuads) {

         int count = 0;
         for (int i = 0; i < listQuads.size(); i++) {

             ArrayList<Integer> integers = listQuads.get(i);
             if (integers.get(0) != first || integers.get(1) != sec || integers.get(2) != third || integers.get(3) != fourth )
                 count++;
         }

         if(count == listQuads.size())
             return false;
        else
             return true;

    }


    public static void main (String[] args) {
        FourSum s = new FourSum();
        //int[] num = {-3,-2,-1,0,0,1,2,3};
        //int[] num = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int[] num = {-1,0,1,2,-1,-4};
        System.out.println(s.fourSum(num, -1));

    }


}
