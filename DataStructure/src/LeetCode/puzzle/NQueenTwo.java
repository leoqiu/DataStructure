package LeetCode.puzzle;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 11/1/13
 * Time: 11:54 AM
 * To change this template use File | Settings | File Templates.
 */
public class NQueenTwo {

    public int totalNQueens(int n) {

        int[] count = new int[1];
        count[0] = 0;

        //chess board
        int[][] board = new int[n][n];
        placeQueen(board, 0, n, count);
//System.out.print(count[0]);
        return count[0];
    }

    private void placeQueen (int[][] board, int row, int n,  int[] count) {

        if (row == n) {
            //print2(getValidBoard(board, n), n);
            count[0] = count[0] + 1;
            return;
        } else {

            for (int col = 0; col < n; col++) {

                if (canBeInserted(board, row, col, n)){
                    board[row][col] = 1;
                    placeQueen(board, row+1, n, count);
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


    public static void main (String[] args) {

        NQueenTwo s = new NQueenTwo();
        System.out.println(s.totalNQueens(8));
    }
}
