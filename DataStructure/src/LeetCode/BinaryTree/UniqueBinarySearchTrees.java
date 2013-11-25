package LeetCode.BinaryTree;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 11/15/13
 *
 *
 *
 */


public class UniqueBinarySearchTrees {


    public int numTrees(int n) {

        if(n==1)
            return 1;

        ArrayList<Integer> dp = new ArrayList<Integer>();
        dp.add(1);
        dp.add(2);

        for (int i = 3; i <= n; i++) {

            int curNum = 2*dp.get(i-1-1);
            for (int j = 2; j <= i-1; j++) {
                int leftNum = j-1;
                int rightNum = i-1-leftNum;

                curNum = curNum + dp.get(leftNum-1)*dp.get(rightNum-1);
            }
            dp.add(curNum);
        }

        return dp.get(dp.size() - 1);
    }


    public static void main (String[] args) {

        UniqueBinarySearchTrees s = new UniqueBinarySearchTrees();
        System.out.print(s.numTrees(1));

    }





}
