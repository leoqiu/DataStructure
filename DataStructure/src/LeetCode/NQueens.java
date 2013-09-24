package LeetCode;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 9/20/13
 *
 *
 * http://oj.leetcode.com/problems/n-queens/
 */
public class NQueens {



    private void printBoard (int[][] board) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + "  ");
            }
            System.out.println();
        }
    }



    public ArrayList<String[]> solveNQueens(int n) {

        ArrayList<String[]> solutions = new ArrayList<String[]>();

        int[][] board = new int[n][n];




        return solutions;
    }


    private boolean isBoardFull (int[][] board) {

        boolean isFull = true;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++){

                if(board[i][j] == 0)
                    isFull = false;
            }
        }

        return isFull;
    }

    // Queen : 1, Empty : 0; can be attacked : 2
    private void getChessBoard (int[][] board, ArrayList<int[][]> boards ,Position firstPos, int queenNum, int n) {

        //printBoard(board);
        //int[][] boardRep = null;

        if (isBoardFull(board) )
            return;
        else {


            //mark places to could be attacked
            for (int i = 0; i < n; i++) {
                board[firstPos.x][i] = 2;
                board[i][firstPos.y] = 2;
            }

            for (int i = firstPos.x, j = firstPos.y; !(i < 0 || i > n - 1 || j < 0 || j > n-1); i--, j--)
                board[i][j] = 2;
            for (int i = firstPos.x, j = firstPos.y; !(i < 0 || i > n - 1 || j < 0 || j > n-1); i++, j++)
                board[i][j] = 2;
            for (int i = firstPos.x, j = firstPos.y; !(i < 0 || i > n - 1 || j < 0 || j > n-1); i--, j++)
                board[i][j] = 2;
            for (int i = firstPos.x, j = firstPos.y; !(i < 0 || i > n - 1 || j < 0 || j > n-1); i++, j--)
                board[i][j] = 2;

            //mark first Queen
            board[firstPos.x][firstPos.y] = 1;
            queenNum--;

            System.out.println();
            printBoard(board);

            if (queenNum == 0) {
                int[][] res = board.clone();
                boards.add(res);

                System.out.println();
                printBoard(board);
            }

            for (int i = 0; i < board.length; i++) {
                for(int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == 0) {
                        firstPos = new Position(i, j);
                        //positions.add(new Position(i, j));
                        getChessBoard (board, boards , firstPos,  queenNum,  n) ;
                    }
                }
            }

//            for (int i = 0; i < positions.size(); i++) {
//                getChessBoard (board, boards ,  positions , firstPos,  queenNum,  n) ;
//            }
            System.out.println("----------"+ queenNum + "-------------");
            printBoard(board);
        }


    }


    public static void main (String[] args) {

        NQueens nq = new NQueens();


        int n = 4;
        ArrayList<int[][]> boards = new ArrayList<int[][]>();
        int[][] board = new int[n][n];



        nq.getChessBoard(board, boards , new Position(0, 0), n, n);

//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                nq.getChessBoard(new int[4][4], boards, new Position(i, j), n, n);
//            }
//        }
//        System.out.println();
    }


}

class Position {

    int x;
    int y;

    public Position (int x, int y) {

        this.x = x;
        this.y = y;
    }
}


















































