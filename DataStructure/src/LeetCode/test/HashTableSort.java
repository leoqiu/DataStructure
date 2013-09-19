package LeetCode.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: leo
 * Date: 9/18/13
 * Time: 10:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class HashTableSort {


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
        HashTableSort hs = new HashTableSort();
        hs.getLongestSequence(array);
    }
}
