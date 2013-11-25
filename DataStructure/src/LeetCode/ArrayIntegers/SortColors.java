package LeetCode.ArrayIntegers;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 11/7/13
 *
 *
 *
 */


public class SortColors {




    public void sortColors(int[] A) {

        int redSt = 0, bluSt = A.length - 1;
        int i = 0;
        while (i < bluSt + 1) {
            if (A[i] == 0) {
                int tmp = A[i];
                A[i] = A[redSt];
                A[redSt] = tmp;
                redSt++;
                i++;
                continue;
            }
            if (A[i] == 2) {
                int tmp = A[i];
                A[i] = A[bluSt];
                A[bluSt] = tmp;
                bluSt--;
                continue;
            }
            i++;
        }
    }

    public static void main (String[] args) {

        int[] A ={1,1,1,0,1,2,0,1,1,2};
        SortColors s = new SortColors();
        s.sortColors(A);
    }

}
