package LeetCode.ArrayIntegers;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 11/11/13
 *
 * http://oj.leetcode.com/problems/subsets/
 *
 */


public class Subsets {


    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> solutions = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> solution = new ArrayList<Integer>();
        int[] visits = new int[S.length];
        Arrays.sort(S);

        for (int len = 1; len <= S.length; len++) {
            combineNum(S, 0, len, solution, solutions, visits, 0);
        }

        //add empty list []
        solutions.add(new ArrayList<Integer>());
        return solutions;
    }


    public void combineNum (int[] S, int begin, int k, ArrayList<Integer> solution, ArrayList<ArrayList<Integer>> solutions, int[] visits, int count) {
        if (count == k) {
            ArrayList<Integer> list = new ArrayList<Integer>(solution);
            solutions.add(list);
            return;
        }

        for (int i = begin; i < S.length; i++) {

            if(visits[i] == 0) {
                solution.add(S[i]);
                visits[i] = 1;
                combineNum(S, i, k, solution, solutions, visits, count+1);
                visits[i] = 0;
                solution.remove(solution.size()-1);
            }
        }
    }

    public static void main (String[] args) {

        int[] S ={1,2,3};
        Subsets s = new Subsets();
        //s.subsets(S);
        System.out.print(s.subsets(S));

    }

}
























