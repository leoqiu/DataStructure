package LeetCode.test;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 11/12/13
 * Time: 1:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class Format {


    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean found = find(board, i, j, word, 0, new boolean[board.length][board[0].length]);
                    if (found)
                        return true;
                }
            }
        }
        return false;
    }

    private boolean find(char[][] board, int i, int j, String word, int index, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length)
            return false;
        if (board[i][j] != word.charAt(index) || visited[i][j])
            return false;
        visited[i][j] = true;
        if (index == word.length() - 1)
            return true;
        // left, right, up, down
        boolean found = find(board, i, j - 1, word, index + 1, visited) || find(board, i, j + 1, word, index + 1, visited)
                || find(board, i - 1, j, word, index + 1, visited) || find(board, i + 1, j, word, index + 1, visited);
        //这样就能保证每次true的能给false回来
        visited[i][j] = false;
        return found;
    }
}
