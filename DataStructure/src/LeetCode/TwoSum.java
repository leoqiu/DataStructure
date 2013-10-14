package LeetCode;

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



}
