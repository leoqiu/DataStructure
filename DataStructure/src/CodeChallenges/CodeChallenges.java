package CodeChallenges;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 9/11/13
 *
 * https://www.hackerrank.com/challenges/pairs
 *
 * http://sixrevisions.com/resources/10-puzzle-websites-to-sharpen-your-programming-skills/
 */
public class CodeChallenges {

    /**
     * Pairs
     *
     * https://www.hackerrank.com/challenges/pairs
     *
     *
     *   Sample Input #00:
         5 2
         1 5 3 4 2

         Sample Output #00:
         3

     *
     */
    public void pairs1 (int n, int k, int[] array) {

        int[][] results = new int[n][n];
        int count = 0;

        for (int i = 0; i < results.length; i++) {
            for (int j = 0; j < results[i].length; j++) {

                results[i][j] = array[i] - array[j];
                if (results[i][j] == k)
                    count++;

            }
        }

        System.out.print(count);
    }

    public void pairs2 (int n, int k, int[] array) {

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {

                if (Math.abs(array[i] - array[j]) == k)
                    count++;
            }
        }

        System.out.print(count);

    }

    public static void main(String[] args) {
        CodeChallenges cc = new CodeChallenges();
        int[] array = {363374326, 364147530, 61825163, 1073065718, 1281246024, 1399469912, 428047635, 491595254, 879792181, 1069262793};
        //cc.pairs1(5, 2, array);
        cc.pairs2(10, 1, array);
    }


}
