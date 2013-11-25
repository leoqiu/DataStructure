package LeetCode.puzzle;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 11/22/13
 *
 * http://oj.leetcode.com/problems/triangle/
 *
 */






public class TriangleDP {

    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {

        if(triangle.size() == 0)
            return 0;

        ArrayList<Integer> pre = new ArrayList<Integer>();
        ArrayList<Integer> cur = new ArrayList<Integer>();

        pre.add(triangle.get(0).get(0));

        if(triangle.size() == 1)
            return pre.get(0);

        for (int i = 1; i < triangle.size(); i++) {
            ArrayList<Integer> curList = triangle.get(i);
            for (int j = 0; j < curList.size(); j++) {
                if(j == 0)
                    cur.add(pre.get(0) + curList.get(j));
                else if (j == curList.size()-1)
                    cur.add(pre.get(pre.size()-1) + curList.get(j));
                else
                    cur.add(Math.min(pre.get(j - 1) + curList.get(j), pre.get(j) + curList.get(j)));
            }
            pre = new ArrayList<Integer>(cur);
            cur.clear();
        }

        int min = pre.get(0);
        for (int i = 0; i < pre.size(); i++)
            min = Math.min(pre.get(i), min);

        return min;
    }

    public static void main (String[] args) {

        TriangleDP s = new TriangleDP();

        ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> l1 = new ArrayList<Integer>(); l1.add(2);
        ArrayList<Integer> l2 = new ArrayList<Integer>(); l2.add(3); l2.add(4);
        ArrayList<Integer> l3 = new ArrayList<Integer>(); l3.add(6); l3.add(5); l3.add(7);
        ArrayList<Integer> l4 = new ArrayList<Integer>(); l4.add(4); l4.add(1); l4.add(8); l4.add(3);
        triangle.add(l1);triangle.add(l2);triangle.add(l3);triangle.add(l4);


        System.out.print(s.minimumTotal(triangle));

    }


}
