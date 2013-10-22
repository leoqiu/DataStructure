package LeetCode;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 10/21/13
 *
 *
 * http://oj.leetcode.com/problems/remove-duplicates-from-sorted-array/
 *
 */
public class RemoveDuplicatesSortedArray{



    public int removeDuplicates(int[] A) {


        int len = A.length;
        int dupCount = 0;
        int allDupCount = 0;

        for (int i = 0; i < len; i++) {

            int j = i+1;

            if (j < len && A[i] == A[j]) {
                while (A[i] == A[j]) {
                    j++;
                    dupCount++;
                    allDupCount++;
                }

                for (int k = j; k < len; k++) {

                    A[k-dupCount] = A[k];

                }

                len = len - dupCount;

                dupCount = 0;
                i = j-1;
            }
        }
        int tmp = A.length - allDupCount;
        return len;
    }


    public static void main (String[] args) {

        int[] A = {1,2,3,4,4,4,5,6,7,7,7,7,7,8,9,10,11,11,11};
        RemoveDuplicatesSortedArray s = new RemoveDuplicatesSortedArray();
        s.removeDuplicates(A);
    }


}


































