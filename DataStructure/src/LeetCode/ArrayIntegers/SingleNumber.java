package LeetCode.ArrayIntegers;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 11/22/13
 *
 * http://oj.leetcode.com/problems/single-number/
 *
 */



public class SingleNumber {


    // ^ - bitwise exclusive OR
    // a ^ a = 0 and a ^ 0 = a
    public int singleNumber(int[] A) {
        int b = A[0];
        for (int i = 1; i < A.length; i++) {
            b = b^A[i];

        }

        return b;
    }


    public static void main (String[] args) {

        //int[] A = {1,2,3,4,3,1,2};
        //int[] A = {-1,2,3,4,3,-1,2,4,0};
        int[] A = {1,1,1,2,2,2,3,1,1,1,2,2,2};

        SingleNumber s = new SingleNumber();
        char b = 98;
        System.out.print(s.singleNumber(A));

    }

}

































