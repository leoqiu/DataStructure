package LeetCode.test;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 10/23/13
 *
 *
 *
 */
public class MSSBQuestion {



    public boolean test (int[] arr, int num) {

        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();

        for (int i = 0; i < arr.length; i++) {

            int cur = arr[i];
            int diff = num - arr[i];

            if (cur != diff) {
                if (hash.containsKey(cur)) {
                    hash.put(cur, hash.get(cur)+1);
                } else {
                    hash.put(cur, 1);
                }

                if (hash.containsKey(diff)) {
                    hash.put(diff, hash.get(diff)+1);
                } else {
                    hash.put(diff, 1);
                }
            } else {
                if (hash.containsKey(cur)) {
                    hash.put(cur, hash.get(cur)+1);
                } else {
                    hash.put(cur, 1);
                }
            }

            if(hash.containsValue(2))
                return true;
        }

        return false;
    }













}








































