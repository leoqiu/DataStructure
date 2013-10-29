package LeetCode.ArrayIntegers;

/**
 * Created with IntelliJ IDEA.
 * User: leo
 * Date: 10/28/13
 *
 * http://oj.leetcode.com/problems/search-insert-position/
 *
 */


public class SearchInsertPosition {



    public int searchInsert(int[] A, int target) {


        int n = A.length;
        int left = 0;
        int right = n-1;

        while (left <= right) {

            int mid = left + (right-left)/2;

            if(target < A[mid])
                right = mid-1;

            if(target > A[mid])
                left = mid+1;

            if(target == A[mid])
                return mid;

        }


        return right+1;
    }

    public static void main (String[] args) {
        SearchInsertPosition s = new SearchInsertPosition();
        int[] A = {1,2,3,5,6,7};
        System.out.println(s.searchInsert(A, 6));

    }

}
