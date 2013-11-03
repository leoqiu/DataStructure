package LeetCode.intervals;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 11/1/13
 *
 *
 * http://oj.leetcode.com/problems/merge-intervals/
 *
 */






 class Interval implements Comparable{
     int start;
     int end;
     Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}



public class MergeIntervals {


    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {

        ArrayList<Interval> solution = new ArrayList<Interval>();

        //corner case { }
        if(intervals.size() == 0)
            return solution;

        //sort
        quicksort(0, intervals.size()-1, intervals);

        Interval pre = intervals.get(0);
        //corner case {(1,4) (1,4)}
        solution.add(pre);
        for (int i = 1; i < intervals.size(); i++) {
            Interval next = intervals.get(i);

            if (next.start >= pre.start && next.start <= pre.end) {
                Interval mergedI = new Interval(pre.start, Math.max(pre.end, next.end));
                solution.remove(solution.size()-1);
                solution.add(mergedI);
                pre = mergedI;

            } else {
                solution.add(next);
                pre = next;
            }


        }

        return solution;
    }


    private void quicksort(int low, int high, ArrayList<Interval> intervals) {
        int i = low, j = high;
        // Get the pivot element from the middle of the list
        Interval pivot = intervals.get(low + (high-low)/2);
        //int pivot = numbers[low];

        // Divide into two lists
        while (i <= j) {
            // If the current value from the left list is smaller then the pivot
            // element then get the next element from the left list
            while (intervals.get(i).start < pivot.start) {
                i++;
            }
            // If the current value from the right list is larger then the pivot
            // element then get the next element from the right list
            while (intervals.get(j).start > pivot.start) {
                j--;
            }

            // If we have found a values in the left list which is larger then
            // the pivot element and if we have found a value in the right list
            // which is smaller then the pivot element then we exchange the
            // values.
            // As we are done we can increase i and j
            if (i <= j) {
                Interval temp = intervals.get(i);
                intervals.set(i, intervals.get(j));
                intervals.set(j, temp);
                i++;
                j--;
            }
        }

        // Recursion
        if (low < j)
            quicksort(low, j, intervals);
        if (i < high)
            quicksort(i, high, intervals);
    }

    public static void main (String[] args) {
        MergeIntervals s = new MergeIntervals();

        ArrayList<Interval> intervals = new ArrayList<Interval>();
        Interval i1 = new Interval(1,4);
        Interval i2 = new Interval(5,6);
        Interval i3 = new Interval(17,21);
        Interval i4 = new Interval(14,16);
        Interval i5 = new Interval(13,19);
        intervals.add(i1);
        intervals.add(i2);
        intervals.add(i3);
        intervals.add(i4);
        intervals.add(i5);

        ArrayList<Interval> solution = s.merge(intervals);
        for (int i = 0; i < solution.size(); i++) {

            System.out.println("(" + solution.get(i).start + "," + solution.get(i).end + ")");

        }

    }

}























