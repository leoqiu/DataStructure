package LeetCode.dp;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 12/1/13
 *
 * http://oj.leetcode.com/problems/palindrome-partitioning/
 *
 */







public class PalindromePartitioning {


    private void print (int[][] dp) {
        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[i].length; j++)
                System.out.print(dp[i][j] + " ");
            System.out.println();
        }
    }

    class Interval {

        int start;
        int end;

        public Interval (int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public ArrayList<ArrayList<String>> partition(String s) {

        int n = s.length();
        int[][] dp = new int[n][n];
        ArrayList<Interval> intervals = new ArrayList<Interval>();
        ArrayList<Interval> starts  = new ArrayList<Interval>();
        ArrayList<Interval> ends = new ArrayList<Interval>();
        //ArrayList<Interval> middles  = new ArrayList<Interval>();

        ArrayList<String> solution = new ArrayList<String>();
        ArrayList<ArrayList<String>> solutions = new ArrayList<ArrayList<String>>();


        for (int i = n-1; i>=0; i--) {
            for (int j = i; j<n; j++) {
                if(i == j) {
                    dp[i][j] = 1;
                    intervals.add(new Interval(i, j));
                    continue;
                }

                if(j-i == 1 && s.charAt(i) == s.charAt(j)){
                    dp[i][j] = 1;
                    intervals.add(new Interval(i, j));
                    continue;
                }

                if(dp[i+1][j-1] == 1 && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 1;
                    intervals.add(new Interval(i, j));
                    continue;
                }
            }
        }

        for (int i = 0; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            if(cur.start == 0)
                starts.add(cur);
            if(cur.end == n-1)
                ends.add(cur);
        }

        for (int i = 0; i < starts.size(); i++) {
            for (int j = 0; j < ends.size(); j++) {
                allPossiblePaths(starts.get(i), ends.get(j), intervals, solutions, solution, s);
            }
        }

        return solutions;

    }

    private void allPossiblePaths (Interval start, Interval end, ArrayList<Interval> intervals,
                                   ArrayList<ArrayList<String>> solutions, ArrayList<String> solution, String s) {

        solution.add(s.substring(start.start, start.end+1));

        if(start.start == end.start && start.end == end.end) {
            ArrayList<String> list = new ArrayList<String>(solution);
            solutions.add(list);
        }

        for (int i = 0; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            if(start.end+1 == cur.start)
                allPossiblePaths(cur, end, intervals, solutions, solution, s);
        }

        solution.remove(solution.size()-1);
    }


    public static void main (String[ ] args) {
        PalindromePartitioning s = new PalindromePartitioning();
        //String str = "ababababababababababababcbabababababababababababa";
        String str = "abababcbabababa";

        System.out.print(s.partition(str));

    }




}






























