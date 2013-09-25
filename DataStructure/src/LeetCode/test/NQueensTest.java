package LeetCode.test;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 9/24/13
 * Time: 11:50 AM
 * To change this template use File | Settings | File Templates.
 */
public class NQueensTest {
    static int n;// 皇后个数
    static int[] x;// 当前解
    static long sum;// 当前已经找到的可行方案数

    public static long nQueen(int nn) {
        n = nn;
        sum = 0;
        x = new int[n + 1];
        for (int i = 0; i <= n; i++)
            x[i] = 0;
        backtrack(1);
        return sum;
    }

    private static boolean place(int k) {
        for (int j = 1; j < k; j++)
            if ((Math.abs(k - j) == Math.abs(x[j] - x[k])) || (x[j] == x[k]))
                return false;
        return true;
    }

    /**
     * 对指定的行进行处理，并递归处理剩下行
     * @param t 指定行
     */
    private static void backtrack(int t) {
        if (t > n)//所有行均处理（也就是不被回溯）
            sum++;
        else
            for (int i = 1; i <= n; i++) {
                x[t] = i;//i表示放置的列
                if (place(t))
                    backtrack(t + 1);
            }
    }

    public static void main (String[] args) {
        System.out.println(nQueen(5));
    }

}


















