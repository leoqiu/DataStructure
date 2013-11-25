package LeetCode.puzzle;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 11/21/13
 *
 * http://oj.leetcode.com/problems/triangle/
 *
 */



public class Triangle {

    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {


        min(triangle, 0, 0, 0);

        return min;
    }

    static int min = Integer.MAX_VALUE;
    private void min (ArrayList<ArrayList<Integer>> triangle, int level, int which, int sum) {

        if (level == triangle.size()) {
            min = Math.min(min, sum);
            return;
        }

        sum = sum + triangle.get(level).get(which);
        min(triangle, level+1, which, sum);
        min(triangle, level+1, which+1, sum);

    }

    public static void main (String[] args) {

        Triangle s = new Triangle();

        ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> l1 = new ArrayList<Integer>(); l1.add(2);
        ArrayList<Integer> l2 = new ArrayList<Integer>(); l2.add(3); l2.add(4);
        ArrayList<Integer> l3 = new ArrayList<Integer>(); l3.add(6); l3.add(5); l3.add(7);
        ArrayList<Integer> l4 = new ArrayList<Integer>(); l4.add(4); l4.add(1); l4.add(8); l4.add(3);
        triangle.add(l1);triangle.add(l2);triangle.add(l3);triangle.add(l4);


        System.out.print(s.minimumTotal(triangle));
    }

}










































