package LeetCode;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 10/14/13
 *
 * http://oj.leetcode.com/problems/two-sum/
 */

public class TwoSum {

    public int[] twoSum(int[] numbers, int target) {

        int n = numbers.length;
        int[] arr = new int[2];

        for (int i = 0; i < n; i++) {
            if (numbers[i] <= target) {

                for (int j = i+1; j<n; j++) {
                    if ( (numbers[i] + numbers[j]) == target) {
                        arr[0] = i + 1;
                        arr[1] = j + 1;
                        return arr;
                    }
                }

            }
        }

        return arr;
    }


    public int[] twoSumHash(int[] numbers, int target) {

        int n = numbers.length;
        int[] arr = new int[2];

        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();

        for (int i = 0; i < n; i++) {

            int curNum = numbers[i];
            int curDiff = target-curNum;

            if(!hash.containsKey(curNum)) {

                //check
                if(hash.containsKey(curDiff)) {
                    arr[0] = hash.get(curDiff) + 1;
                    arr[1] = i + 1;
                    return arr;
                } else         //hash
                    hash.put(curNum, i);
            } else {

                //check
                if(2*curNum == target){
                    arr[0] = hash.get(curNum) + 1;
                    arr[1] = i + 1;
                    return arr;
                } else
                    hash.put(curNum, i);
            }
        }

        return arr;
    }

    public static void main (String[] args) {

        TwoSum s = new TwoSum();
//        int target = 9;
//        int[] numbers = {2, 7, 11, 15};

        //hash table corner case
        int target = 8;
        int[] numbers = {2,1,9,4,4,56,90,3};
        int arr[] = s.twoSumHash(numbers, target);
        System.out.print(arr[0] + " - " + arr[1]);


    }



}



































