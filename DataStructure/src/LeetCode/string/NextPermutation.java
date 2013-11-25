package LeetCode.string;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 10/28/13
 *
 *
 *  http://oj.leetcode.com/problems/next-permutation/
 *
 *  题意寻找比当前排列顺序大的下一个排列。

 因为降序序列是没法变的更大的，所以从后往前找到第一个升序对的位置。

 然后就存在调整大小排列顺序的可能，从后往前找到比当前位置大的元素，交换之。

 当前位置后面的元素还是降序排列，将他们反转得到最小顺序排列。其实就是原来当前位置元素后面是最大的排列，而交换后的新元素之后是最小的排列，他们就是相邻的顺序。

 当不存在升序，则当前排列是最大排列，只要旋转整个序列变成最小排列。
 */


public class NextPermutation {

    public void nextPermutation(int[] num) {

        int n = num.length;

        int count = 0;

        for (int i = n-1; i > 0; i--) {

            if ( num[i-1] < num[i] ) {

                for (int j = n-1; j >= i; j--) {
                    if (num[j] > num[i-1]) {
                        int tmp = num[i-1];
                        num[i-1] = num[j];
                        num[j] = tmp;
                        break;
                    }
                }

                reverseArr (num, i, n-1);
                return;
            }

            count++;
        }

        if(count == n-1)
            reverseArr(num, 0, n-1);

        System.out.print("");
    }


    private void reverseArr (int[] num, int low, int high) {

        while (low < high) {

            int tmp = num[low];
            num[low] = num[high];
            num[high] = tmp;

            low++;
            high--;
        }
    }

    public static void main (String[] args) {

        NextPermutation s = new NextPermutation();
        //int[] num = {1,2,3,4,5,6};
        //int[] num = {4,2,0,2,3,2,0};
        int[] num = {1,2,3,4,5,9,8,7,6};
        s.nextPermutation(num);

    }

}











