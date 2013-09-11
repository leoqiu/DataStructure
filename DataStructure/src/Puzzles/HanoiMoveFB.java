package Puzzles;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 9/10/13
 * Time: 4:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class HanoiMoveFB {

        /*

       There are K pegs. Each peg can hold discs in decreasing order of radius when looked from bottom to top of the peg.
       There are N discs which have radius 1 to N; Given the initial configuration of the pegs and the final configuration
       of the pegs, output the moves required to transform from the initial to final configuration. You are required to do
       the transformations in minimal number of moves. A move consists of picking the topmost disc of any one of the pegs
       and placing it on top of any other peg. At any point of time, the decreasing radius property of all the pegs must be maintained.

       Constraints:
       1<= N<=8
       3<= K<=5

       Input Format:
       N K
       2nd line contains N integers.
       Each integer in the second line is in the range 1 to K where the i-th integer denotes the peg to which disc of radius i is present in the initial configuration.
       3rd line denotes the final configuration in a format similar to the initial configuration.

       Output Format:
       The first line contains M - The minimal number of moves required to complete the transformation.
       The following M lines describe a move, by a peg number to pick from and a peg number to place on.

       If there are more than one solutions, it's sufficient to output any one of them. You can assume, t
       here is always a solution with less than 7 moves and the initial confirguration will not be same as the final one.


    Sample Input #00:

    2 3
    1 1
    2 2

    Sample Output #00:

    3
    1 3
    1 2
    3 2

    Sample Input #01:

    6 4
    4 2 4 3 1 1
    1 1 1 1 1 1

    Sample Output #01:

    5
    3 1
    4 3
    4 1
    2 1
    3 1

     */


//    public void hanoiMove (int numDisc, int numPeg, int[] initC, int[] finalC) {
//
//    }

    public void hanoiMoveFB (int[] initC, int[] finalC, int n) {


        for (int i = n; i >= 1; i--) {

            if(initC[i - 1] == finalC[i - 1]) //already in final place
                ;
            else {                            //move

                // initC[i] -> finalC[i]
                while (initC[i - 1] != finalC[i - 1]) {

                }

            }

        }




    }


    /*
        3 pegs
        n discs

        init : all discs in 1st peg
        final: all discs in 3rd peg

    http://blog.sina.com.cn/s/blog_48e3f9cd01000474.html

     */
    public void hanoi (int n, char a, char b, char c) {


        if (n > 0) {
            hanoi(n - 1, a, c, b);
            System.out.println("Move top disc from tower " + a + " to top of tower " + b);
            hanoi(n - 1, c, b, a);
        }


    }


    public static void main (String[] args) {

        HanoiMoveFB h = new HanoiMoveFB();
        h.hanoi(5, 'a', 'b', 'c');
    }


}



















































