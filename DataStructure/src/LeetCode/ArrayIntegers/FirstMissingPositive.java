package LeetCode.ArrayIntegers;

import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 10/30/13
 *
 * http://oj.leetcode.com/problems/first-missing-positive/
 *
 */


public class FirstMissingPositive {

    public int firstMissingPositive(int[] A) {

        if (A.length == 0)
            return 1;

        HashSet<Integer> hash = new HashSet<Integer>();

        int minElm = Integer.MIN_VALUE;
        boolean isFirstMinFound = false;
        for (int i = 0; i < A.length; i++) {

            if(A[i] > 0 && !isFirstMinFound) {
                 minElm = A[i];
                isFirstMinFound = true;
            } else if(A[i] > 0 && isFirstMinFound){
                minElm = Math.min(minElm, A[i]);
            }

        }

        if(minElm == Integer.MIN_VALUE || minElm > 1)
            return 1;

        for (int i = 0; i < A.length; i++)
            if(A[i] >= 0)
                hash.add(A[i]);

        while (true) {

            if (hash.contains(minElm))
                minElm++;
            else
                break;
        }

        return minElm;

    }

    public static void main (String[] args) {
        FirstMissingPositive s = new FirstMissingPositive();
        int[] A = {1000, -1};
        System.out.print(s.firstMissingPositive(A));

    }


}
