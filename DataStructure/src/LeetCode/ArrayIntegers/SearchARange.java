package LeetCode.ArrayIntegers;

/**
 * Created with IntelliJ IDEA.
 * User: leo
 * Date: 10/28/13
 *
 *  http://oj.leetcode.com/problems/search-for-a-range/
 *
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 return [3, 4].
 */


public class SearchARange {


    public int[] searchRange(int[] A, int target) {


        int n = A.length;

        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;

        int left = 0;
        int right = n-1;

        int leftRange = -1;

        while (left <= right) {

            int mid = left + (right-left)/2;

            if (target < A[mid])
                right = mid-1;

            if (target > A[mid])
                left = mid+1;

            if ( (target == A[mid] && mid == 0) || (target == A[mid] && A[mid-1] < target) ) {
                leftRange = mid;
                break;
            }

            if (target == A[mid] && A[mid-1] == target)
                right = mid-1;


        }

        if (leftRange == -1)
            return res;

        left = leftRange;
        right = n -1;

        int rightRange = -1;
        while (left <= right) {

            int mid = left + (right-left)/2;

            if(target  < A[mid])
                right = mid - 1;

            if ( (target == A[mid] && mid == n-1) || (target == A[mid] && A[mid+1] > target) ) {
                rightRange = mid;
                break;
            }

            if ( (mid >= left && target == A[mid]) || (mid == 0 && target == A[mid]))  // corner case
                left = mid+1;

        }


        res[0] = leftRange;
        res[1] = rightRange;




        return res;
    }


    public static void main (String[] args) {

        int[] A = {1,2,2};

        SearchARange s = new SearchARange();
        int[] res = s.searchRange(A, 2);
        System.out.println(res[0] + ", " + res[1]);

    }


}























