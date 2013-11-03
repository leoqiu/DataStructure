package LeetCode.recursion;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 10/31/13
 *
 * http://oj.leetcode.com/problems/permutations/
 */



public class Permutations {


    public ArrayList<ArrayList<Integer>> permute(int[] num) {

        ArrayList<ArrayList<Integer>> listOfIntegers = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> integers = new ArrayList<Integer>();
        int[] visit = new int[num.length];

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
                integers.add(num[i]);
                visit[i] = 1;
                permuteNums(num, i, integers, listOfIntegers, visit);
                visit[i] = 0;
                integers.remove(integers.size() - 1);
            }

        }

    }

    public static void main (String[] arg) {

        Permutations s = new Permutations();
        int[] num = {1,2,3};

        System.out.print(s.permute(num));

    }


}























