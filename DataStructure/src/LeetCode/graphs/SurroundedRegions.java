package LeetCode.graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 12/3/13
 * Time: 6:13 PM
 * To change this template use File | Settings | File Templates.
 */







public class SurroundedRegions {

    class Point {
        int row;
        int col;

        public Point (int row, int col) {
            this.row = row;
            this.col = col;
        }
    }


    public void solve(char[][] board) {

        if(board == null)
            return;

        int rowNum = board.length;
        int colNum = board[0].length;
        if(rowNum == 0 || colNum == 0)
            return;

        Queue<Point> queue = new LinkedList<Point>();

        //two border cols, left & right
        for (int i = 0; i < rowNum; i++) {
            if(board[i][0] == 'O')
                queue.offer(new Point(i, 0));
            if(board[i][colNum-1] == 'O')
                queue.offer(new Point(i, colNum-1));
        }

        //two border rows, up and bottom
        for (int i = 0; i < colNum; i++) {
            if(board[0][i] == 'O')
                queue.offer(new Point(0, i));
            if(board[rowNum-1][i] == 'O')
                queue.offer(new Point(rowNum-1, i));
        }

        while (!queue.isEmpty()) {
            Point curP = queue.poll();
            board[curP.row][curP.col] = 'Y';

            //up
            if(curP.col > 0 && board[curP.row][curP.col-1] == 'O')
                queue.offer(new Point(curP.row, curP.col-1));

            //down
            if(curP.col < colNum-1 && board[curP.row][curP.col+1] == 'O')
                queue.offer(new Point(curP.row, curP.col+1));

            //left
            if(curP.row > 0 && board[curP.row-1][curP.col] == 'O')
                queue.offer(new Point(curP.row-1, curP.col));

            //right
            if(curP.row < rowNum-1 && board[curP.row+1][curP.col] == 'O')
                queue.offer(new Point(curP.row+1, curP.col));

        }

        for (int i = 0; i < rowNum; i++) {
            for(int j = 0; j < colNum; j++) {
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                if(board[i][j] == 'Y')
                    board[i][j] = 'O';
            }
        }

    }

    private void print (char board[][]) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
    }

    public static void main (String[] args) {

        char[][] board = {

                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'X', 'X', 'X'},
                {'O', 'X', 'O', 'O'},
                {'X', 'X', 'O', 'X'},
                {'X', 'X', 'X', 'X'},
        };

//        char[][] board = {
//
//                {'X', 'X', 'O', 'X'},
//        };

        SurroundedRegions s = new SurroundedRegions();
        s.print(board);
        s.solve(board);
        System.out.println();
        s.print(board);

    }

}






























