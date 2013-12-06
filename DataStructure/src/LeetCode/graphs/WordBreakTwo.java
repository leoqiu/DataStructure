package LeetCode.graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 12/5/13
 * Time: 5:20 PM
 * To change this template use File | Settings | File Templates.
 */


public class WordBreakTwo {

    public ArrayList<String> wordBreak(String s, Set<String> dict) {


        int n = s.length();
        ArrayList<Interval> intervals = new ArrayList<Interval>();
        ArrayList<Interval> starts = new ArrayList<Interval>();
        ArrayList<Interval> ends = new ArrayList<Interval>();
        ArrayList<String> solutions = new ArrayList<String>();
        ArrayList<String> solution = new ArrayList<String>();

        for (int start = 0; start < n; start++) {
            for (int end = start; end < n; end++) {
                if(dict.contains(s.substring(start, end+1))) {
                    Interval interval = new Interval(start, end);
                    if(start == 0)
                        starts.add(interval);
                    if(end == n-1)
                        ends.add(interval);

                    intervals.add(interval);
                }
            }
        }


        for (int i = 0; i < starts.size(); i++) {
            for(int j = 0; j < ends.size(); j++) {

                allValidPath(starts.get(i), ends.get(j), s, intervals, solution, solutions);

            }
        }

        return solutions;
    }


    private void allValidPath (Interval start, Interval end, String s,
                               ArrayList<Interval> intervals, ArrayList<String> solution, ArrayList<String> solutions) {

        solution.add(s.substring(start.start, start.end + 1));

        if(start.start == end.start && start.end == end.end) {
            solutions.add(listToString(solution));
        }

        for (int i = 0; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            if(start.end+1 == cur.start)
                allValidPath(cur, end, s, intervals, solution, solutions);

        }

        solution.remove(solution.size()-1);
    }

    private String listToString (ArrayList<String> list) {

        StringBuilder sb = new StringBuilder("");

        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append(" ");
        }

        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    public static void main (String[] args) {

        WordBreakTwo wordBreakTwo = new WordBreakTwo();
//        String[] set = {"cat", "cats", "and", "sand", "dog"};
//        String s = "catsanddog";
        String[] set = {"aaaa","aaa"};
        String s = "aaaaaaa";
        Set<String> dict = new HashSet<String>();
        for(int i=0; i < set.length; i++) dict.add(set[i]);

        System.out.println(wordBreakTwo.wordBreak(s, dict));



    }


}






























