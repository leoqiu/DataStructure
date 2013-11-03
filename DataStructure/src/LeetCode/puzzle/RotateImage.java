package LeetCode.puzzle;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 10/31/13
 *
 * http://oj.leetcode.com/problems/rotate-image/
 *
 */


public class RotateImage {


    public void rotate(int[][] matrix) {

        int n = matrix.length-1;
        int[][] tmp = new int[n+1][n+1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                tmp[j][n-i] = matrix[i][j];
            }

        }
        matrix = tmp;
    }

    //do it in place
    public void rotate2(int[][] matrix) {





    }


    private void printArr (int[][] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                  System.out.print(arr[i][j] + " ");
            }
            System.out.println();

        }

    }

    public static void main (String[] args) {

//        int[][] matrix = {
//                {1,2,3,4,5},
//                {6,7,8,9,10},
//                {11,12,13,14,15},
//                {16,17,18,19,20},
//                {21,22,23,24,25}
//
//        };


        int[][] matrix = {
                {1,2},
                {3,4},

        };

        RotateImage s  = new RotateImage();
        s.rotate(matrix);

    }



}
