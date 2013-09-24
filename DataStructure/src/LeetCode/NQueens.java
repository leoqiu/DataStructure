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

    private void placeAQueen (int[][] board, Position pos, int n) {

        //mark places to could be attacked
        for (int i = 0; i < n; i++) {
            board[pos.x][i] = 2;
            board[i][pos.y] = 2;
        }

        for (int i = pos.x, j = pos.y; !(i < 0 || i > n - 1 || j < 0 || j > n-1); i--, j--)
            board[i][j] = 2;
        for (int i = pos.x, j = pos.y; !(i < 0 || i > n - 1 || j < 0 || j > n-1); i++, j++)
            board[i][j] = 2;
        for (int i = pos.x, j = pos.y; !(i < 0 || i > n - 1 || j < 0 || j > n-1); i--, j++)
            board[i][j] = 2;
        for (int i = pos.x, j = pos.y; !(i < 0 || i > n - 1 || j < 0 || j > n-1); i++, j--)
            board[i][j] = 2;

        //mark first Queen
        board[pos.x][pos.y] = 1;

    }

    public void getChessBoard2 (int[][] board, int n, Position curPos ,Position[] positions, int queenNum) {

        if(isBoardFull(board))
            return;
        else {

            placeAQueen (board, curPos, n);
            positions[queenNum++] = curPos;


            System.out.println();
            printPos(positions, queenNum);

            if (queenNum == n) {

            }

            for (int i = 0; i < board.length; i++) {
                for(int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == 0) {
                        curPos = new Position(i, j);
                        //positions.add(new Position(i, j));
                        getChessBoard2 (board, n , curPos, positions,  queenNum) ;
                    }
                }
            }

            System.out.println("----------"+ queenNum + "-------------");
            printPos(positions, queenNum);

        }

    }


    private void printPos (Position[] positions, int queenNum) {
        for (int i = 0; i < queenNum; i++) {
            System.out.print("(" + positions[i].x + ", " + positions[i].y + ")");
        }
        System.out.println();

    }

    // Queen : 1, Empty : 0; can be attacked : 2
    private void getChessBoard1 (int[][] board, ArrayList<int[][]> boards ,Position firstPos, int queenNum, int n) {

        //printBoard(board);
        //int[][] boardRep = null;

        if (isBoardFull(board) )
            return;
        else {


            //mark places to could be attacked
            placeAQueen (board, firstPos, n);
            queenNum--;

            System.out.println();
            printBoard(board);
            //boards.add(board);

            if (queenNum == 0) {
                //int[][] res = board.clone();
                //boards.add(res);

                System.out.println();
                printBoard(board);
            }

            for (int i = 0; i < board.length; i++) {
                for(int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == 0) {
                        firstPos = new Position(i, j);
                        //positions.add(new Position(i, j));
                        getChessBoard1 (board, boards , firstPos,  queenNum,  n) ;
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



        //nq.getChessBoard1(board, boards , new Position(0, 0), n, n);
        nq.getChessBoard2(board, n , new Position(0, 0), new Position[10], 0);


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


















































