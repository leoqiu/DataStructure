package LeetCode.ArrayIntegers;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 11/12/13
 *
 * http://oj.leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 *
 */



public class RemoveDuplicatesSortedArray {


    public int removeDuplicates(int[] A) {


        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
        ArrayList<Integer> solution = new ArrayList<Integer>();

        for (int i = 0; i < A.length; i++) {

            int cur = A[i];
            if(hash.containsKey(cur)) {
                if(hash.get(cur) < 2) {
                    solution.add(cur);
                    hash.put(cur, hash.get(cur)+1);
                }
            }else {
                solution.add(cur);
                hash.put(cur, 1);
            }
        }

        for (int i = 0; i < solution.size(); i++) {
            A[i] = solution.get(i);
        }

        return solution.size();
    }

    public static void main (String[] args) {

        RemoveDuplicatesSortedArray s = new RemoveDuplicatesSortedArray();
        int[] A = {1,2};
        s.removeDuplicates(A);
    }

}




























































