package LeetCode.ArrayIntegers;

/**
 * Created with IntelliJ IDEA.
 * User: leo
 * Date: 10/28/13
 *
 *
 *  http://oj.leetcode.com/problems/search-in-rotated-sorted-array/
 *
 *  (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 *
 *  Solution
 *
 *  http://blog.csdn.net/zjull/article/details/11781437
 *
 */



public class SearchRotatedSortedArray {




    public int search(int[] A, int target) {

        int n = A.length;

        int left = 0;
        int right = n-1;

        if (n <= 2) {
            for (int i = 0; i < n; i++) {

                if (A[i] == target)
                    return i;
            }

            return -1;
        }

        if(A[left] < A[right]) {
            return binarySearch(A, target, 0, n-1);
        } else {
            //find separator
            int sepIndex = -1;
            while (left < right) {

                int middle = (left+right)/2;

                if (A[middle] < A[middle+1] && A[middle] < A[middle-1]) {
                    sepIndex = middle;
                    break;
                }

                if (A[middle] > A[middle+1] && A[middle] > A[middle-1]) {
                    sepIndex = middle+1;
                    break;
                }


                if (A[middle] > A[0] && A[middle] > A[n-1])
                    left = middle;
                else if (A[middle] < A[0] && A[middle] < A[n-1])
                    right = middle;
            }


            //the first half
            if (target >= A[0] && target <= A[sepIndex-1]) {
                return binarySearch(A, target, 0, sepIndex-1);
            //sec half
            } else if (target <= A[n-1] && target >= A[sepIndex]) {
                return binarySearch(A, target, sepIndex, n-1);
            } else
                return -1;

        }

    }

    private int binarySearch (int[] A, int target, int left, int right) {


        while (left <= right) {
            // Key is in a[lo..hi] or not present.
            int mid = left + (right - left) / 2;
            if (target < A[mid])
                right = mid - 1;
            else if (target > A[mid])
                left = mid + 1;
            else
                return mid;
        }
        return -1;

    }


    public static void main (String[] args) {

        SearchRotatedSortedArray s = new SearchRotatedSortedArray();


        //int[] A = {4,5,6,7,8,9,10,1,2,3};
        int[] A = {1,3,5};
        System.out.println(s.search(A, 0));

    }


}































