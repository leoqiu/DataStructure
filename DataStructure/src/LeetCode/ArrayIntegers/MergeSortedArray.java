package LeetCode.ArrayIntegers;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 11/13/13
 *
 *
 *
 */



public class MergeSortedArray {



    public void merge(int A[], int m, int B[], int n) {


        int curA = m-1;
        int curB = n-1;
        int count = m+n-1;

        while (curA >= 0 && curB >= 0) {

            if(A[curA] >= B[curB]) {
                A[count] = A[curA];
                curA--;
            } else {
                A[count] = B[curB];
                curB--;
            }

            count--;
        }

        while (curB >= 0) {
            A[count] = B[curB];
            curB--;
            count--;
        }

    }

}


























