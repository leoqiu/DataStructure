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

        for (int i = pos.x, j = pos.y; !(i < 0 || i > n - 1 || j < 0 || j > n-1); i--, j--) {
            board[i][j] = 2;
        }
        for (int i = pos.x, j = pos.y; !(i < 0 || i > n - 1 || j < 0 || j > n-1); i++, j++) {
            board[i][j] = 2;
        }
        for (int i = pos.x, j = pos.y; !(i < 0 || i > n - 1 || j < 0 || j > n-1); i--, j++) {
            board[i][j] = 2;
        }
        for (int i = pos.x, j = pos.y; !(i < 0 || i > n - 1 || j < 0 || j > n-1); i++, j--) {
            board[i][j] = 2;
        }

        //mark first Queen
        board[pos.x][pos.y] = 1;

    }

    private void placeAQueen2 (int[][] board, Position pos, int n, ArrayList<Position> positions) {

        //mark places to could be attacked
        for (int i = 0; i < n; i++) {
            if (board[pos.x][i] == 0) {
                board[pos.x][i] = 2;
                positions.add(new Position(pos.x, i));
            }

            if (board[i][pos.y] == 0) {
                board[i][pos.y] = 2;
                positions.add(new Position(i, pos.y));
            }
        }

        for (int i = pos.x, j = pos.y; !(i < 0 || i > n - 1 || j < 0 || j > n-1); i--, j--) {
            if (board[i][j] == 0) {
                board[i][j] = 2;
                positions.add(new Position(i, j));
            }
        }
        for (int i = pos.x, j = pos.y; !(i < 0 || i > n - 1 || j < 0 || j > n-1); i++, j++) {
            if (board[i][j] == 0) {
                board[i][j] = 2;
                positions.add(new Position(i, j));
            }
        }
        for (int i = pos.x, j = pos.y; !(i < 0 || i > n - 1 || j < 0 || j > n-1); i--, j++) {
            if (board[i][j] == 0) {
                board[i][j] = 2;
                positions.add(new Position(i, j));
            }
        }
        for (int i = pos.x, j = pos.y; !(i < 0 || i > n - 1 || j < 0 || j > n-1); i++, j--) {
            if (board[i][j] == 0) {
                board[i][j] = 2;
                positions.add(new Position(i, j));
            }
        }

        //mark first Queen
        board[pos.x][pos.y] = 1;
        positions.add(new Position(pos.x, pos.y));

    }




    private boolean isCurRowFull (int[][] board, int n, int row) {

        boolean isFull = true;

        for (int i = 0; i < n; i++) {
            if (board[row][i] == 0){
                isFull = false;
                break;
            }
        }

        return isFull;
    }

    private void resetBoard (int[][] board, int queenNum, ArrayList<ArrayList<Position>> positionsList) {

        ArrayList<Position> positions = positionsList.get(queenNum - 1);

        for (int i = 0; i < positions.size(); i++) {
            Position p = positions.get(i);
            board[p.x][p.y] = 0;
        }

        positionsList.remove(queenNum - 1);
    }

    public void getChessBoard2 (int[][] board, int n, int row , int queenNum, ArrayList<ArrayList<Position>> positionsList) {


        //n == 0
        if (isCurRowFull(board, n, row))
            return;
        else {

            ArrayList<Position> positions = new ArrayList<Position>();

            for (int i = 0; i < n; i++) {
                if(board[row][i] == 0) {
                    placeAQueen2 (board, new Position(row, i), n, positions);
                    positionsList.add(positions);
                    queenNum++;
                    break;
                }
            }

            if (queenNum == n) {
                System.out.println();
                printBoard(board);

            }

            for (int i = 1; i < n; i++) {
                getChessBoard2(board, n, i, queenNum, positionsList);
            }

            resetBoard ( board, queenNum, positionsList);

            System.out.println("--------- " + queenNum + " -----------");
            printBoard(board);

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


    //////////////////////////////////////   Try #3   //////////////////////////////////////////////////
    private boolean canBePlaced (int row, int col, int[][] board, int n) {

        for ( int i = 0; i < n; i++ )
           if (board[i][col] == 1) {
               return false;
           }

        for (int i = row, j = col; !(i < 0 || i > n - 1 || j < 0 || j > n-1); i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        for (int i = row, j = col; !(i < 0 || i > n - 1 || j < 0 || j > n-1); i++, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        for (int i = row, j = col; !(i < 0 || i > n - 1 || j < 0 || j > n-1); i--, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        for (int i = row, j = col; !(i < 0 || i > n - 1 || j < 0 || j > n-1); i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    public void getChessBoard3 (int row, int n, int[][] board, ArrayList<Integer> count) {

        if (n == row) {
            System.out.println("--------------------");
            printBoard(board);
            count.set(0, count.get(0) + 1);
        } else {

            if (row < n) {
                for (int col = 0; col < n; col++) {

                    if (canBePlaced(row, col, board, n)){
                        board[row][col] = 1;
                        //printBoard(board);
                        //System.out.println();
                        getChessBoard3(row+1, n, board, count);
                    }

                    board[row][col] = 0;
                }
            }

        }


    }




    public static void main (String[] args) {

        NQueens nq = new NQueens();


        int n = 4;
        int[][] board = new int[n][n];
        ArrayList<Integer> count = new ArrayList<Integer>();
        count.add(0);
        nq.getChessBoard3(0, n, board, count);
        System.out.println(count.get(0));


        //nq.getChessBoard1(board, boards , new Position(0, 0), n, n);
        //nq.getChessBoard2(board, n , 0, 0, new ArrayList<ArrayList<Position>>());


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


















































