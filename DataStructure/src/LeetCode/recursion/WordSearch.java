package LeetCode.recursion;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 11/12/13
 *
 *  http://oj.leetcode.com/problems/word-search/
 *
 */



public class WordSearch {

    static boolean isExist = false;
    public boolean exist(char[][] board, String word) {

        if(word.equals(""))
            return true;

        StringBuilder needFind = new StringBuilder();
        int n = board.length;
        int m = board[0].length;
        char firstC = word.charAt(0);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(board[i][j] == firstC) {
                    findWord(board, i, j, n, m, 0, word, word.length(), new int[n][m]);
                    if(isExist == true)
                        return true;
                }
            }
        }

        return isExist;
    }

    public void findWord (char[][] board, int x, int y, int n, int m, int count , String word ,int len, int[][] visits) {

        if(x>=0 && x<n && y>=0 && y<m && count < len && board[x][y] == word.charAt(count) && visits[x][y] == 0){
            visits[x][y] = 1;
            count++;

        } else
            return;

        if(count == len)
            isExist = true;

        findWord(board, x + 1, y, n, m, count, word, len, visits);
        findWord(board, x - 1, y, n, m, count, word, len, visits);
        findWord(board, x, y + 1, n, m, count, word, len, visits);
        findWord(board, x, y-1, n, m, count, word, len, visits);
    }

    public static void main (String[] args) {

        WordSearch s = new WordSearch();
//        char[][] board = {
//                {'A', 'B', 'C', 'E'},
//                {'S', 'F', 'C', 'S'},
//                {'A', 'D', 'E', 'E'}
//
//        };
//        String word = "ABCCED";

        char[][] board = {
                {'a'},

        };
        String word = "ab";

//        char[][] board = {
//                {'A', 'B', 'C'}
//
//        };
//        String word = "ABCCED";

       //System.out.print(s.exist(board, word));

       System.out.print(s.exist(board, word));
    }



}





























