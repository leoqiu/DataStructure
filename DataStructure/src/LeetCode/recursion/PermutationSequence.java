package LeetCode.recursion;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 11/3/13
 *
 * http://oj.leetcode.com/problems/permutation-sequence/
 *
 */


public class PermutationSequence {


    public static int count = 0;
    public static String res;
    public String getPermutation(int n, int k) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(i+1);
        }

        char[] chars = sb.toString().toCharArray();
        int[] visits = new int[n];
        ArrayList<Character> permutation = new ArrayList<Character>();
        getIthString (chars, visits, 0, n, k, permutation);

        return res;
    }


    public static void getIthString (char[] chars, int[] visits, int start, int n, int k, ArrayList<Character> permutation) {

        if (permutation.size() == n) {
            count++;
            if(count == k) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < permutation.size(); i++)
                    sb.append(permutation.get(i));
                res = sb.toString();
            }
            return;
        } else {
            for (int i = start; i < chars.length; i++) {
                if(visits[i] == 0) {
                    permutation.add(chars[i]);
                    visits[i] = 1;
                    getIthString(chars, visits, start, n, k, permutation);
                    visits[i] = 0;
                    permutation.remove(permutation.size()-1);
                }
            }
        }
    }


    public static void main (String[] args) {
        PermutationSequence s = new PermutationSequence();

        System.out.print(s.getPermutation(9, 94626));

    }


}





















