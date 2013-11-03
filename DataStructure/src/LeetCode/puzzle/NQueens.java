package LeetCode.puzzle;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 11/1/13
 *
 * http://oj.leetcode.com/problems/n-queens/
 *
 */


public class NQueens {

    public ArrayList<String[]> solveNQueens(int n) {

        ArrayList<String[]> res = new ArrayList<String[]>();

        //chess board
        int[][] board = new int[n][n];
        placeQueen(board, 0, n, res);

        return res;
    }

    private void placeQueen (int[][] board, int row, int n,  ArrayList<String[]> res) {

        if (row == n) {
            //print2(getValidBoard(board, n), n);
            res.add(getValidBoard(board, n));
            return;
        } else {

                for (int col = 0; col < n; col++) {

                    if (canBeInserted(board, row, col, n)){
                        board[row][col] = 1;
                        placeQueen(board, row+1, n, res);
                    }

                    board[row][col] = 0;
                }
        }
    }

    private String[] getValidBoard(int[][] board, int n) {

        String[] solution = new String[n];
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 0)
                    sb.append('.');
                else
                    sb.append('Q');
            }
            solution[i] = sb.toString();
        }
        return solution;
    }


    private boolean canBeInserted (int[][] board, int row, int col, int n) {

        for (int i = 0; i < col; i++)
            if(board[row][i] == 1)
                return false;

        for (int i = 0; i < row; i++)
            if (board[i][col] == 1)
                return false;

        int i = row - 1;
        int j = col - 1;

        while (i >= 0 && i < n && j>=0 && j < n) {
            if(board[i][j] == 1)
                return false;
            else {
                i--;
                j--;
            }
        }

        i = row - 1;
        j = col + 1;

        while (i >= 0 && i < n && j>=0 && j < n) {
            if(board[i][j] == 1)
                return false;
            else {
                i--;
                j++;
            }
        }

        return true;
    }

    private void print2(String[] solution, int n) {

        for (int i = 0; i < n; i++) {
            System.out.print(solution[i]);
            System.out.println();
        }
        System.out.println();
    }

    private void print(int[][] board, int n) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();

    }

    public static void main (String[] args) {

        NQueens s = new NQueens();
        s.solveNQueens(4);
    }

}


























