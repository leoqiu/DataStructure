package LeetCode.recaps;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 12/10/13
 *
 * http://oj.leetcode.com/problems/combination-sum-ii/
 *
 */


public class CombinationSumTwo {

    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {

        ArrayList<ArrayList<Integer>> listOfIntegers = new ArrayList<ArrayList<Integer>>();

        if (num.length == 0)
            return listOfIntegers;

        ArrayList<Integer> solution = new ArrayList<Integer>();
        int[] visits = new int[num.length];

        return listOfIntegers;
    }

    private void findCombinations (ArrayList<ArrayList<Integer>> listOfIntegers, ArrayList<Integer> solution, int[] visits, int target, int[] num, int sum, int begin) {

        if(sum == target) {
            ArrayList<Integer> list = new ArrayList<Integer>(solution);
            listOfIntegers.add(list);
            return;
        }

        if (sum > target)
            return;

        for (int i = begin; i < num.length; i++) {

            if(num[i] <= target && visits[i] == 0) {

                if(i>0 && num[i] == num[i-1] && visits[i-1] == 0)
                    continue;

                sum = sum + num[i];
                solution.add(num[i]);
                visits[i] = 1;
                findCombinations(listOfIntegers, solution, visits, target, num, sum, i);
                visits[i] = 0;
                sum = sum - num[i];
                solution.remove(solution.size()-1);

            }

        }
    }


}





































