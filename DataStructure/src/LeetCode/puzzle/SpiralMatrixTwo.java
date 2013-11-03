package LeetCode.puzzle;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 11/2/13
 *
 * http://oj.leetcode.com/problems/spiral-matrix-ii/
 *
 */


public class SpiralMatrixTwo {

    private void printArr (int[][] arr, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                  System.out.print(arr[i][j] + "   ");

            }
            System.out.println();
            System.out.println();
        }
    }

    public int[][] generateMatrix(int n) {

        int[][] solution = new int[n][n];

        if(n==0)
            return solution;

        //init
        int count = 0;
        int totalNum = n*n;


        int startI = 0;
        int startJ = 0;
        int curI = startI;
        int curJ = startJ;

        while (true) {

            //up
            while (curJ < n) {

                solution[curI][curJ]  = count+1;
                curJ++;
                count++;

                if (count == totalNum)
                    return solution;
            }
            curJ--;
            curI++;

            //right
            while (curI < n) {
                solution[curI][curJ]  = count+1;
                curI++;
                count++;

                if (count == totalNum)
                    return solution;
            }
            curI--;
            curJ--;

            //bottom
            while (curJ >= startJ) {
                solution[curI][curJ]  = count+1;
                curJ--;
                count++;

                if (count == totalNum)
                    return solution;
            }
            curJ++;
            curI--;

            //left
            while (curI > startI) {
                solution[curI][curJ]  = count+1;
                curI--;
                count++;

                if (count == totalNum)
                    return solution;
            }

            startI++;
            startJ++;
            curI = startI;
            curJ = startJ;
            n--;
        }

    }


    public static void main (String[ ] args) {

        SpiralMatrixTwo s = new SpiralMatrixTwo();
        int n = 5;
        int[][] res = s.generateMatrix(n);
        s.printArr(res, n);

    }

}




















