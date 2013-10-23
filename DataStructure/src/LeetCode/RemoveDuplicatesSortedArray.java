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

        if(len == 0 || len == 1)
            return len;

        int dupCount = 0;

        for (int i = 0; i < len; i++) {

            int j = i+1;

            if (j < len && A[i] == A[j]) {
                int curI = j;
                while (A[i] == A[j]) {
                    j++;
                    dupCount++;

                    if(j == len)
                        break;
                }

                for (int k = j; k < len; k++) {

                    A[k-dupCount] = A[k];

                }

                len = len - dupCount;

                dupCount = 0;
                i = curI-1;
            }
        }

        return len;
    }


    public static void main (String[] args) {

        // int[] A = {1,2,3,4,4,4,5,6,7,7,7,7,7,8,9,10,11,11,11};
        int[] A = {1,1,2};
        RemoveDuplicatesSortedArray s = new RemoveDuplicatesSortedArray();
        s.removeDuplicates(A);
    }


}


































