package LeetCode.puzzle;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 11/21/13
 *
 * http://oj.leetcode.com/problems/pascals-triangle-ii/
 *
 */


public class PascalTriangleTwo {


    public ArrayList<Integer> getRow(int rowIndex) {

        ArrayList<Integer> pre = new ArrayList<Integer>();

        if(rowIndex == 0) {
            pre.add(1);
            return pre;
        }

        if (rowIndex == 1) {
            pre.add(1); pre.add(1);
            return pre;
        }

        pre.add(1); pre.add(1);
        for (int i = 2; i <= rowIndex; i++) {
            ArrayList<Integer> cur = new ArrayList<Integer>();
            cur.add(1);
            for (int j = 1; j < i; j++) {
                cur.add(pre.get(j-1) + pre.get(j));
            }
            cur.add(1);
            pre = cur;
        }

        return pre;

    }

    public static void main (String[] args) {
        PascalTriangleTwo s = new PascalTriangleTwo();
        System.out.print(s.getRow(2));

    }

}

















