package LeetCode.intervals;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 11/2/13
 *
 * http://oj.leetcode.com/problems/insert-interval/
 *
 */


public class InsertInterval {



    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {

        int n =intervals.size();

        if (n == 0) {
            intervals.add(newInterval);
            return intervals;
        }
        else {
            //[1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16]
            //insert on head
            Interval curI = intervals.get(0);
            if (newInterval.start <= curI.start) {
                intervals.add(0, newInterval);
                reMerge(0, intervals);
                return intervals;
            }

            //insert or merge on tail
            Interval nextI = intervals.get(n-1);
            if (newInterval.start >= nextI.start) {
                intervals.add(newInterval);
                reMerge(n-1, intervals);
                return intervals;
            }


            for (int i = 0; i < n-1; i++) {
                curI = intervals.get(i);
                nextI = intervals.get(i+1);

                if (newInterval.start >= curI.start && newInterval.start <= nextI.start) {
                    intervals.add(i+1, newInterval);
                    reMerge(i, intervals);
                    break;
                }

            }

        }

        return intervals;

    }

    private void reMerge (int start, ArrayList<Interval> intervals) {

        Interval pre = intervals.get(start);
        for (int i = start+1; i < intervals.size();) {

            Interval next = intervals.get(i);

            if(next.start >= pre.start && next.start <= pre.end) {
                Interval mergedI = new Interval(pre.start, Math.max(pre.end, next.end));
                //remove 2 elements
                intervals.remove(pre);
                intervals.remove(next);
                intervals.add(i-1, mergedI);
                pre = mergedI;
            } else {
                pre = next;
                i++;
            }

        }
    }

    public static void main (String[] args) {
        //[1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16]
        InsertInterval s = new InsertInterval();

        ArrayList<Interval> intervals = new ArrayList<Interval>();
        Interval i1 = new Interval(1,2);
        Interval i2 = new Interval(3,5);
        Interval i3 = new Interval(6,7);
        Interval i4 = new Interval(8,10);
        Interval i5 = new Interval(12,16);
        intervals.add(i1);
        intervals.add(i2);
        intervals.add(i3);
        intervals.add(i4);
        intervals.add(i5);

        Interval ii = new Interval(4,9);

        ArrayList<Interval> solution = s.insert(intervals, ii);

        for (int i = 0; i < solution.size(); i++) {

            System.out.println("(" + solution.get(i).start + "," + solution.get(i).end + ")");

        }
    }

}
























