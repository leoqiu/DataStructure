package LeetCode.recursion;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 10/31/13
 *
 * http://oj.leetcode.com/problems/permutations-ii/
 *
 */


public class PermutationTwo {

    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {

        ArrayList<ArrayList<Integer>> listOfIntegers = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> integers = new ArrayList<Integer>();
        int[] visit = new int[num.length];

        Arrays.sort(num);
        permuteNums(num, 0, integers, listOfIntegers, visit);


        return listOfIntegers;
    }


    private void permuteNums (int[] num, int start, ArrayList<Integer> integers, ArrayList<ArrayList<Integer>> listOfIntegers, int[] visit) {

        if (integers.size() == num.length) {
            ArrayList<Integer> list = new ArrayList<Integer>(integers);
            listOfIntegers.add(list);
            return;
        }

        for (int i = 0; i < num.length; i++ ) {

            if(visit[i] == 0) {

                if(i>0 && num[i] == num[i-1] && visit[i-1] == 0)
                    continue;

                integers.add(num[i]);
                visit[i] = 1;
                permuteNums(num, i, integers, listOfIntegers, visit);
                visit[i] = 0;
                integers.remove(integers.size() - 1);
            }

        }

    }

    public static void main (String[] arg) {

        PermutationTwo s = new PermutationTwo();
        int[] num = {1,1,2};

        System.out.print(s.permuteUnique(num));

    }
}
