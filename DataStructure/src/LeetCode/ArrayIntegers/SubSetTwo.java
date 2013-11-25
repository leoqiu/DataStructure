package LeetCode.ArrayIntegers;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 11/15/13
 * Time: 10:19 AM
 * To change this template use File | Settings | File Templates.
 */


public class SubSetTwo {


    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {

        ArrayList<ArrayList<Integer>> solutions = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> solution = new ArrayList<Integer>();
        int[] visits = new int[num.length];
        Arrays.sort(num);

        for (int len = 1; len <= num.length; len++) {
            getSubsetsDup(num, 0, visits, len, 0, solutions, solution);
        }

        solutions.add(new ArrayList<Integer>());
        return solutions;
    }

    private void getSubsetsDup (int[] num, int begin, int[] visits, int len, int count, ArrayList<ArrayList<Integer>> solutions, ArrayList<Integer> solution) {

        if(count == len) {
            ArrayList<Integer> list = new ArrayList<Integer>(solution);
            solutions.add(list);
            return;
        }

        for (int i = begin; i < num.length; i++) {

            if(i>0 && num[i] == num[i-1] && visits[i-1] == 0)
                continue;

            if(visits[i] == 0) {
                visits[i] = 1;
                solution.add(num[i]);
                getSubsetsDup(num, i, visits, len, count+1, solutions, solution);
                solution.remove(solution.size()-1);
                visits[i] = 0;
            }
        }
    }

    public static void main (String[] args) {

        SubSetTwo s = new SubSetTwo();
        int[] num = {1,2,2};
        System.out.print(s.subsetsWithDup(num));
    }



}

































