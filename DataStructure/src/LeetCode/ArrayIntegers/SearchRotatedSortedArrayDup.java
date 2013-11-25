package LeetCode.ArrayIntegers;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 11/12/13
 *
 *
 *
 */



public class SearchRotatedSortedArrayDup {

    public boolean search(int[] A, int target) {

        int n = A.length;
        int left = 0;
        int right = n-1;

        while (left <= right) {

            int mid = left + (right-left)/2;

            if(A[mid] == target)
                return true;

            if(A[left] < A[mid]) {

                if(target >= A[left] && target < A[mid])
                    right = mid-1;
                else
                    left = mid + 1;

            } else if (A[left] > A[mid]) {

                if(target > A[mid] && target <= A[right])
                    left = mid+1;
                else
                    right = mid-1;

            } else
                left++;
        }

        return false;
    }


    public static void main (String[] args) {

        SearchRotatedSortedArrayDup s = new SearchRotatedSortedArrayDup();
        //int[] A = {4, 5, 6, 7,0,  1, 2};
        int[] A = {1,3,5};
        System.out.print(s.search(A, 1));
    }

}








































