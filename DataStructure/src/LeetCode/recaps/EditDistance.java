package LeetCode.recaps;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 12/12/13
 *
 * http://oj.leetcode.com/problems/edit-distance/
 *
 * solution ref : http://www.cnblogs.com/etcow/archive/2012/08/30/2662985.html
 *
 */
  /*
            _	a	b	a	b	d
        _	0	1	2	3	4	5
        c	1
        c	2
        a	3
        b	4
        a	5
        b	6

        然后按照注释里的方法填满表格，返回最后一个数字（最佳解）

            _	a	b	a	b	d
        _	0	1	2	3	4	5
        c	1	1	2	3	4	5
        c	2	2	2	3	4	5
        a	3	2	3	2	3	4
        b	4	3	2	3	2	3
        a	5	4	3	2	3	3
        b	6	5	4	3	2	3

    */
public class EditDistance {



    public int minDistance(String word1, String word2) {
        //recursive solution
        //return edit(word1, word1.length(), word2, word2.length());

        int[][] dp = new int[word1.length()+1][word2.length()+1];

        for (int i = 0; i < dp.length; i++)
            dp[i][0] = i;

        for (int i = 0; i < dp[0].length; i++)
            dp[0][i] = i;

        for (int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[i].length; j++) {

                //如果当前两个字符相等，Min(左上角的数，上面的数+1，左边的数+1)
                //如果不相等， Min（左上角的数+1， 上面的数+1，左边的数+1）
                if(word1.charAt(i-1) == word2.charAt(j-1))
                    dp[i][j] = Math.min(Math.min(dp[i][j-1]+1, dp[i-1][j]+1), dp[i-1][j-1]);
                else
                    dp[i][j] = Math.min(Math.min(dp[i][j-1]+1, dp[i-1][j]+1), dp[i-1][j-1]+1);

            }

        }

        return dp[word1.length()][word2.length()];

    }


    private int edit (String word1, int len1, String word2, int len2) {

        if (len1 == 0)
            return len2;

        if (len2 == 0)
            return len1;

        if (word1.charAt(len1-1) == word2.charAt(len2-1))
            return edit(word1, len1-1, word2, len2-1);
        else
            return Math.min( Math.min(edit(word1, len1-1, word2, len2)+1, edit(word1, len1, word2, len2-1)+1),
                    edit(word1, len1-1, word2, len2-1)+1);
    }

    public static void main (String[] args) {

        String word1 = "dinitrophenylhydrazine";
        String word2 = "benzalphenylhydrazone";


        EditDistance s = new EditDistance();
        System.out.println(s.minDistance(word1, word2));

    }


}
