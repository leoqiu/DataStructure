package LeetCode.recursion;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 11/11/13
 *
 * http://oj.leetcode.com/problems/combinations/
 *
 */


public class Combinations {



    public ArrayList<ArrayList<Integer>> combine(int n, int k) {

        ArrayList<ArrayList<Integer>> solutions = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> solution = new ArrayList<Integer>();
        int[] visits = new int[n];

        combineNum(n, k, 0, solution, solutions, visits, 0);


        return solutions;
    }


    public void combineNum (int n, int k, int begin, ArrayList<Integer> solution, ArrayList<ArrayList<Integer>> solutions, int[] visits, int count) {

        if (count == k) {
            ArrayList<Integer> list = new ArrayList<Integer>(solution);
            solutions.add(list);
            return;
        }

        for (int i = begin; i < n; i++) {

            if(visits[i] == 0) {

                solution.add(i+1);
                visits[i] = 1;
                combineNum(n, k, i, solution, solutions, visits, count+1);
                visits[i] = 0;
                solution.remove(solution.size()-1);
            }

        }
    }

    public static void main (String[] args) {

        Combinations s = new Combinations();
        System.out.print(s.combine(4, 2));

    }


}





















































