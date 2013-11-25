package LeetCode.ArrayIntegers;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 11/23/13
 * Time: 10:41 AM
 * To change this template use File | Settings | File Templates.
 */



public class SingleNumberTwo {

    //define a bit vector, an array with lenght 32. bitVector[i] stores the count of '1' in position i
//time O(n), space O(1)

    /*

    现在的解法是比较普通的。因为题目已经说了，除了一个数字以外，其他的都出现了3次，如果我们把那个特殊的数剔除，
    并把剩下的数于每一位来加和的话，每一位上1出现的次数必然都是3的倍数。所以，解法就在这里，将每一位数字分解到32个bit上，
    统计每一个bit上1出现的次数。最后对于每一个bit上1出现的个数对3取模，剩下的就是结果
     */


    public int singleNumber(int[] A) {

        int n = A.length;
        int[] bits = new int[32];

        for (int i = 0; i < n; i++) {

            //int k = 1;
            for (int j = 0; j < 32; j++) {
                int rotated;
                if ((rotated = A[i] >> j) == 0)
                    break;
                int tmp = rotated & 1;
                bits[j] += tmp;

            }
        }

        int target = 0;
        for (int i = 0; i < 32; i++) {
            target += (bits[i] % 3 << i);

        }

        return target;
    }


    public static void main (String[] args) {

        //int[] A = {1,2,3,4,3,1,2};
        //int[] A = {-1,2,3,4,3,-1,2,4,0};
        int[] A = {11,11,11,22,22,22,3,111,111,111,2222,2222,2222};

        SingleNumberTwo s = new SingleNumberTwo();
        char b = 98;
        System.out.print(s.singleNumber(A));

    }




}
