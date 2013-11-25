package LeetCode.puzzle;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 11/21/13
 *
 * http://oj.leetcode.com/problems/pascals-triangle/
 *
 */



public class PascalTriangle {


    public ArrayList<ArrayList<Integer>> generate(int numRows) {

        ArrayList<ArrayList<Integer>> solution = new ArrayList<ArrayList<Integer>>();
        if(numRows == 0)
            return solution;

        ArrayList<Integer> first = new ArrayList<Integer>(); first.add(1); solution.add(first);
        if(numRows == 1)
            return solution;

        ArrayList<Integer> second = new ArrayList<Integer>(); second.add(1); second.add(1); solution.add(second);
        if(numRows == 2)
            return solution;


        ArrayList<Integer> pre = second;
        for (int i = 3; i <= numRows; i++) {
            ArrayList<Integer> cur = new ArrayList<Integer>();
            cur.add(1);
            for (int j = 1; j < i-1; j++) {
                 cur.add(pre.get(j-1) + pre.get(j));
            }
            cur.add(1);
            solution.add(cur);
            pre = cur;
        }

        return solution;
    }


    public static void main (String[] args) {
        PascalTriangle s = new PascalTriangle();
        System.out.print(s.generate(5));

    }



}


































