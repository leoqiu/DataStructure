package LeetCode.string;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 11/21/13
 *
 *
 *
 */


/*

遇到这种两个串的问题，很容易想到DP。但是这道题的递推关系不明显。可以先尝试做一个二维的表int[][] dp，用来记录匹配子序列的个数（以S ="rabbbit",T = "rabbit"为例）：

    r a b b b i t
  1 1 1 1 1 1 1 1
r 0 1 1 1 1 1 1 1
a 0 0 1 1 1 1 1 1
b 0 0 0 1 2 3 3 3
b 0 0 0 0 1 3 3 3
i 0 0 0 0 0 0 3 3
t 0 0 0 0 0 0 0 3

从这个表可以看出，无论T的字符与S的字符是否匹配，dp[i][j] = dp[i][j - 1].就是说，假设S已经匹配了j - 1个字符，得到匹配个数为dp[i][j - 1].
现在无论S[j]是不是和T[i]匹配，匹配的个数至少是dp[i][j - 1]。除此之外，当S[j]和T[i]相等时，我们可以让S[j]和T[i]匹配，然后让S[j - 1]和T[i - 1]去匹配。所以递推关系为：
dp[0][0] = 1; // T和S都是空串.
dp[0][1 ... S.length() - 1] = 1; // T是空串，S只有一种子序列匹配。
dp[1 ... T.length() - 1][0] = 0; // S是空串，T不是空串，S没有子序列匹配。
dp[i][j] = dp[i][j - 1] + (T[i - 1] == S[j - 1] ? dp[i - 1][j - 1] : 0).



 */


public class DistinctSubsequencesDP {


    public int numDistinct(String S, String T) {

        int[][] dp = new int[T.length()+1][S.length()+1];

        //T >= "" & S == ""
        for (int i = 0; i < dp.length; i++)
            dp[i][0] = 0;

        //T == "" & S >= ""
        for (int j = 0; j < dp[0].length; j++)
            dp[0][j] = 1;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {

                dp[i][j] = dp[i][j-1];
                if(T.charAt(i-1) == S.charAt(j-1))
                    dp[i][j] += dp[i-1][j-1];

            }

        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {

                System.out.print(dp[i][j] + " ");
            }
            System.out.println();

        }

        return dp[T.length()][S.length()];

    }


    public static void main (String[] args) {
        DistinctSubsequencesDP s = new DistinctSubsequencesDP();

//        String S = "rabbbit";
//        String T = "rabbit";

        String S = "aabdbaadcbbdedacb";
        String T = "babd";
        System.out.print(s.numDistinct(S, T));

    }

}

























































