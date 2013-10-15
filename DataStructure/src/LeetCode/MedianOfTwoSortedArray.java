package LeetCode;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 10/14/13
 *
 * http://oj.leetcode.com/problems/median-of-two-sorted-arrays/
 *
 *
 * A median is only defined on ordered one-dimensional data, and is independent of any distance metric.
 * A geometric median, on the other hand, is defined in any number of dimensions.Also a median can be
 * regarded the "middle number" in a set of values and in the case of having even number of values such
 * as (3,4,5,6) the median will be the two middle values added together and divided by 2, [ i.e (4+5)/2 ]
 *
 */

public class MedianOfTwoSortedArray {



    public double findMedianSortedArrays(int A[], int B[]) {

        int m = A.length;
        int n = B.length;
        int[] F = new int[m+n];

        int count = 0;
        int curA = 0;
        int curB = 0;

        if ( (m+n)%2 == 0 ) {

            int index2 = (m+n) / 2;

            while (curA < m && curB < n) {

                if (A[curA] <= B[curB]) {
                    F[count] = A[curA];
                    curA++;
                }else {
                    F[count] = B[curB];
                    curB++;
                }


                if (count == index2)
                    return (double) (F[count] + F[count-1])/2;

                count++;
            }

            if (curA == m) {
                for (int i = curB; i < n; i++) {
                    F[count] = B[i];
                    if (count == index2 )
                        return (double) (F[count] + F[count-1])/2;
                    count++;
                }
            } else {
                for (int i = curA; i < m; i++) {
                    F[count] = A[i];
                    if (count == index2 )
                        return (double) (F[count] + F[count-1])/2;
                    count++;
                }
            }

        } else {

            int index = (m+n-1)/2;

            while (curA < m && curB < n) {

                if (A[curA] <= B[curB]) {
                    F[count] = A[curA];
                    curA++;
                }else {
                    F[count] = B[curB];
                    curB++;
                }

                if (count == index )
                    return (double) F[count];

                count++;
            }

            if (curA == m) {
                for (int i = curB; i < n; i++) {
                    F[count] = B[i];
                    if (count == index )
                        return (double) F[count];
                    count++;
                }
            } else {
                for (int i = curA; i < m; i++) {
                    F[count] = A[i];
                    if (count == index )
                        return (double) F[count];
                    count++;
                }
            }

        }

        return 0;
    }


    public static void main (String[] args) {

        int[] A = {1,2};
        int[] B = {1,2,3};

        MedianOfTwoSortedArray s = new MedianOfTwoSortedArray();
        System.out.println(s.findMedianSortedArrays(A, B));

    }

}
























