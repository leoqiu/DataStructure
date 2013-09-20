package LeetCode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 9/18/13
 *
 *  Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

    For example,
    Given [100, 4, 200, 1, 3, 2, 99],
    The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

    Your algorithm should run in O(n) complexity.
 *
 *
 *
 * http://oj.leetcode.com/problems/longest-consecutive-sequence/
 *
 *
 * [2147483646,-2147483647,0,2,2147483644,-2147483645,2147483645]
 *
 *
 * Algorithm core : hashtable
 *
 */
public class LongestConsecutiveSequence {

    private int getCurMin (HashMap<Integer, Integer> hash) {

        int min = Integer.MAX_VALUE;

        Iterator<Map.Entry<Integer,Integer>> it = hash.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry<Integer, Integer> entry = it.next();
            int key = entry.getKey();

            if (key < min)
                min = key;
        }

        return min;

    }

    private void getLongestSequence (int[] array) {
        int n = array.length;

        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if(array[i] < min)
                min = array[i];
            if(array[i] > max)
                max = array[i];
            hash.put(array[i], 1);
        }

        int p = 0;
        int curValue = min;
        int curCount = 0;
        int maxCount = 0;

        while (p < n) {

            while (hash.containsKey(curValue)) {

                hash.remove(curValue);
                curCount++;
                curValue++;
                p++;

            }


            curValue = getCurMin(hash);

            if(curCount > maxCount)
                maxCount = curCount;

            curCount = 0;

            if (curValue > max)
                break;
        }

        System.out.print(maxCount);

    }


    public static void main (String[] args) {

        int[] array = {100, 4, 200, 1, 98, 3, 2, 99};
        LongestConsecutiveSequence ls = new LongestConsecutiveSequence();
        ls.getLongestSequence(array);
    }


}



















