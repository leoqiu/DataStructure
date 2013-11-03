package LeetCode.puzzle;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 11/1/13
 *
 * http://oj.leetcode.com/problems/spiral-matrix/
 *
 */



public class SpiralMatrix {


    public ArrayList<Integer> spiralOrder(int[][] matrix) {

        ArrayList<Integer> solution = new ArrayList<Integer>();
        int count = 0;

        int curI = 0;
        int curJ = 0;
        int startI = 0;
        int startJ = 0;

        int curRowNum = matrix.length;

        if(curRowNum == 0)
            return solution;

        int curColNum = matrix[0].length;
        int total = curColNum*curRowNum;

        while (true) {
            //up
            while (curJ < curColNum) {
                solution.add(matrix[curI][curJ]);
                curJ++;
                count++;
                if(count == total)
                    return solution;
            }
            curJ--;

            //right
            curI++;
            while (curI < curRowNum) {
                solution.add(matrix[curI][curJ]);
                curI++;
                count++;
                if(count == total)
                    return solution;
            }

            //bottom
            curI--;
            curJ--;
            while (curJ >= startJ) {
                solution.add(matrix[curI][curJ]);
                curJ--;
                count++;
                if(count == total)
                    return solution;
            }
            curJ++;

            //left
            curI--;
            while (curI > startI) {
                solution.add(matrix[curI][curJ]);
                curI--;
                count++;
                if(count == total)
                    return solution;
            }

            startI++;
            startJ++;
            curI = startI;
            curJ = startJ;
            curRowNum--;
            curColNum--;
        }

    }

    public void spiral(int[][] matrix, int i, int j, int n, ArrayList<Integer> solution) {

    }

    public static void main (String[] args) {

//        int[][] matrix = {
//                {1,2,3,4,5},
//                {6,7,8,9,10},
//                {11,12,13,14,15},
//                {16,17,18,19,20}
//        };

        int[][] matrix = {
                {1}
        };
        SpiralMatrix s = new SpiralMatrix();
        System.out.print(s.spiralOrder(matrix));


    }

}































