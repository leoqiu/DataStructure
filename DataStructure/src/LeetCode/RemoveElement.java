package LeetCode;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 10/22/13
 *
 * http://oj.leetcode.com/problems/remove-element/
 *
 */


public class RemoveElement {



    public int removeElement(int[] A, int elem) {


        int len = A.length;

        if (len == 0 || (len == 1 && A[0] != elem))
            return len;


        for (int i = 0; i < len; i++) {

            if (A[i] == elem) {

                int j = i;
                int curI = i;

                int count = 1;
                while (j < len-1 && A[j] == A[j+1]) {

                    count++;
                    j++;

                    if(j == len)
                        break;

                }

                for (int k = j+1; k < len; k++) {

                    A[k-count] = A[k];

                }


                len = len - count;
                i = curI;
            }

        }

        return len;
    }


    public static void main (String[] args) {

       int[] A = {1,2,3,4,4,4,5,6,7,7,7,7,7,8,9,10,11,11,11,4, 13,12, 4, 4};
        //int[] A = {1,1,2};
        RemoveElement s = new RemoveElement();
        s.removeElement(A, 4);


    }











}
