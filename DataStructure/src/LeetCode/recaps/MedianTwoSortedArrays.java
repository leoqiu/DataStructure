package LeetCode.recaps;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 12/2/13
 *
 * http://oj.leetcode.com/problems/median-of-two-sorted-arrays/
 *
 */


/*

Assumption: The inputs are right. i.e. k is in the range [0, len(a)+len(b)]

Base cases:

If length of one of the arrays is 0, the answer is kth element of the second array.
Reduction steps:

If mid index of a + mid index of b is less than k
If mid element of a is greater than mid element of b, we can ignore the first half of b, adjust k.
else ignore the first half of a, adjust k.
Else if k is less than sum of mid indices of a and b:
If mid element of a is greater than mid element of b, we can safely ignore second half of a
else we can ignore second half of b


 */



public class MedianTwoSortedArrays {


    public double findMedianSortedArrays(int A[], int B[]) {

        int m = A.length;
        int n = B.length;

        if( (m+n) %2 == 0)
            return (getKthElem(A, 0, m-1, B, 0, n-1, (m+n)/2) + getKthElem(A, 0, m-1, B, 0, n-1, (m+n)/2+1))/2;
        else
            return getKthElem(A, 0, m-1, B, 0, n-1, (m+n)/2+1);
    }

    private int getKthElem (int A[], int leftA, int rightA, int[] B, int leftB, int rightB, int k) {

        if(leftA == rightA)
            return B[k-1];
        if(leftB == rightB)
            return A[k-1];
        //?
        if(k <= 1) return Math.min(A[0], B[0]);

        int midA = leftA + (rightA-leftA)/2 + 1;
        int midB = leftB + (rightB-leftB)/2 + 1;
        if(midA + midB + 1 < k) {
            if(A[midA] > B[midB])
                return getKthElem(A, leftA, rightA, B, midB+1, rightB, k-midB-1);
            else
                return getKthElem(A, midA+1, rightA, B, leftB, rightB, k-midA-1);

        } else{
            if(A[midA] > B[midB])
                return getKthElem(A, leftA, midA-1, B, leftB, rightB, k);
            else
                return getKthElem(A, leftA, rightA, B, leftB, midB-1, k);
        }

    }

//    private int kthElem (int[] A, int[] B, int k) {
//
//        if(A.length == 0)
//            return B[k];
//        if (B.length == 0)
//            return A[k];
//
//        int midA = A.length/2;
//        int midB = B.length/2;
//
//        if(midA +midB < k) {
//            if(A[midA] > B[midB])
//                return kthElem(A, Arrays.copyOfRange(B, midB+1, B.), k-midB-1);
//
//        } else {
//
//
//        }
//
//    }

    public static void main (String[] args) {

        MedianTwoSortedArrays s = new MedianTwoSortedArrays();
        int[] A = {1,3,5,7,9,11,13,14,16};
        int[] B = {2,4,6,8,10,12,15,17,18};

         System.out.print(s.getKthElem(A, 0, A.length-1, B, 0, B.length-1, 16));
    }



}





























