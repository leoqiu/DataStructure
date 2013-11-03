package LeetCode.recursion;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 10/30/13
 *
 * http://oj.leetcode.com/problems/combination-sum-ii/
 *
 */


public class CombinationSumB {


    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {


        ArrayList<ArrayList<Integer>> listOfIntegers = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> integers = new ArrayList<Integer>();
        //visit array
        int[] visits = new int[num.length];

        if(num.length == 0)
            return listOfIntegers;

        Arrays.sort(num);

        int sum = 0;
        combineNums (num, sum, target, 0, integers, listOfIntegers, visits);


        return listOfIntegers;
    }


    private void combineNums (int[] num, int sum, int target, int begin,
                              ArrayList<Integer> integers, ArrayList<ArrayList<Integer>> listOfIntegers, int[] visits) {

        if(sum == target) {
            ArrayList<Integer> list = new ArrayList<Integer>(integers);
            Collections.sort(list);
            listOfIntegers.add(list);
            return;
        }

        if(sum > target)
            return;

        for (int i = begin; i < num.length; i++ ) {

            if (num[i] <= target && visits[i] == 0) {

                if(i>0 && num[i] == num[i-1] && visits[i-1] == 0)
                    continue;

                integers.add(num[i]);
                visits[i] = 1;
                sum = sum + num[i];
                combineNums(num, sum, target, i, integers, listOfIntegers, visits);
                visits[i] = 0;
                sum = sum - num[i];
                integers.remove(integers.size() - 1);

            }

        }
    }


    public  static void main (String[] args) {

        CombinationSumB s = new CombinationSumB();
        int[] num = {1,7,6,1};
        //int[] num = {1};
        System.out.print(s.combinationSum2(num, 8));

    }


}






















