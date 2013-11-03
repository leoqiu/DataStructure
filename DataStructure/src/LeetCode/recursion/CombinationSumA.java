package LeetCode.recursion;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 10/30/13
 * Time: 10:09 AM
 * To change this template use File | Settings | File Templates.
 */
public class CombinationSumA {
    /**
     * Created with IntelliJ IDEA.
     * User: shqiu
     * Date: 10/29/13
     *
     *  http://oj.leetcode.com/problems/combination-sum/
     *
     */



    public static class CombinationSum {

        public ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates, int target) {


            ArrayList<ArrayList<Integer>> listOfIntegers = new ArrayList<ArrayList<Integer>>();
            HashSet<Integer> hash = new HashSet<Integer>();

            for (int i = 0; i < candidates.length; i++) {
                hash.add(candidates[i]);
            }

            Iterator<Integer> it = hash.iterator();
            int[] arr = new int[hash.size()];

            int count = 0;
            while (it.hasNext()) {
                arr[count] = it.next();
                count++;
            }

            Arrays.sort(arr);



            for (int i = 0; i < arr.length; i++) {
                int x = arr[i];
                if (x == target) {
                    ArrayList<Integer> integers = new ArrayList<Integer>();
                    integers.add(x);
                    listOfIntegers.add(integers);
                    break;
                }

                if (target%x == 0) {
                    int singleCount = target / x;
                    ArrayList<Integer> integers = new ArrayList<Integer>();
                    for (int k = 0; k < singleCount; k++)
                        integers.add(x);
                    listOfIntegers.add(integers);
                }


                for (int j = i+1; j < arr.length; j++) {

                    int y = arr[j];
                    int curSum = x+y;

                    if (curSum == target) {
                        ArrayList<Integer> integers = new ArrayList<Integer>();
                        integers.add(x);
                        integers.add(y);
                        listOfIntegers.add(integers);
                    } else if (curSum < target) {

                        int curCount = target / curSum;

                        for (int m = 1; m <= curCount; m++) {

                            int diff = target - m*curSum;

                            if (diff % x == 0) {
                                int xNum = diff / x;

                                ArrayList<Integer> integers = new ArrayList<Integer>();
                                for (int k = 0; k < m+xNum; k++)
                                    integers.add(x);
                                for (int k = 0; k < m; k++)
                                    integers.add(y);
                                listOfIntegers.add(integers);

                            }

                            if (diff % y == 0) {
                                int yNum = diff / y;

                                ArrayList<Integer> integers = new ArrayList<Integer>();
                                for (int k = 0; k < m; k++)
                                    integers.add(x);
                                for (int k = 0; k < m+yNum; k++)
                                    integers.add(y);
                                listOfIntegers.add(integers);
                            }

                        }

                    } else if (curSum > target)
                        continue;

                }


            }

            return listOfIntegers;
        }



        public ArrayList<LinkedList<Integer>> combinationSum(int[] candidates, int target) {
            ArrayList<LinkedList<Integer>> listOfIntegers = new ArrayList<LinkedList<Integer>>();
            HashSet<Integer> hash = new HashSet<Integer>();

            for (int i = 0; i < candidates.length; i++) {
                hash.add(candidates[i]);
            }

            Iterator<Integer> it = hash.iterator();
            int[] arr = new int[hash.size()];

            int count = 0;
            while (it.hasNext()) {
                arr[count] = it.next();
                count++;
            }

            Arrays.sort(arr);

            int sum = 0;
            combineNums(arr, sum, 0, target, listOfIntegers, new LinkedList<Integer>());

            return listOfIntegers;
        }

        public void combineNums(int[] candidates, int sum, int begin, int target,
                                                         ArrayList<LinkedList<Integer>> listOfIntegers, LinkedList<Integer> integers) {

            if (sum == target) {
                LinkedList<Integer> list = new LinkedList<Integer>(integers);
                listOfIntegers.add(list);
                return;
            }

            if (sum > target)
                return;

            for (int i = begin; i < candidates.length; i++) {

                if(candidates[i] <= target) {
                    integers.push(candidates[i]);
                    sum = sum + candidates[i];
                    combineNums(candidates, sum, i, target, listOfIntegers, integers);
                    sum = sum - candidates[i];
                    integers.pop();
                }
            }
        }

        public static void main (String[] args) {
            CombinationSum s = new CombinationSum();
            //int[] candidates = {2,5,7,8,2,3,3,3,8,9,10};
            int[] candidates = {3,2,7};
            System.out.print(s.combinationSum(candidates, 18));

        }


    }
}
