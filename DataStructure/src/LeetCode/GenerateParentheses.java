package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: leo
 * Date: 10/17/13
 *
 *  http://oj.leetcode.com/problems/generate-parentheses/
 *
 *  solution -
 *  http://www.cnblogs.com/lichen782/p/leetcode_Generate_Parenthness.html
 *
 */


public class GenerateParentheses {


    public ArrayList<String> generateParenthesis(int n) {


        HashSet<String> set1 = new HashSet<String>();
        HashSet<String> set2 = new HashSet<String>();
        set1.add("()");

        for (int i = 2; i <= n; i++) {

            //fill set1
            if (i%2 == 1) {
                set1.clear();

                Iterator<String> it = set2.iterator();
                while (it.hasNext()) {
                    String curStr = it.next();
                    for (int j=0; j<=curStr.length(); j++) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(curStr).insert(j, "()");
                        set1.add(sb.toString());

                    }
                }
            }

            //fill set2
            if (i%2 == 0) {
                set2.clear();

                Iterator<String> it = set1.iterator();
                while (it.hasNext()) {
                    String curStr = it.next();
                    for (int j=0; j<=curStr.length(); j++) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(curStr).insert(j, "()");
                        set2.add(sb.toString());

                    }
                }

            }

        }

        ArrayList<String> res = new ArrayList<String>();

        if (n%2 == 1)
            setToList(set1, res);
        else
            setToList(set2, res);

        return res;
    }

    private void setToList (HashSet<String> set, ArrayList<String> list) {

        Iterator<String> it = set.iterator();
        while(it.hasNext())
            list.add(it.next());

    }



    private void combinationPar (ArrayList<String> res, StringBuilder solution, int len, int n, int leftNum, int rightNum)  {

        if (len == 2*n) {
            res.add(solution.toString());
        System.out.println(solution.toString());
            return;
        }

        if(leftNum < n) {
            solution.append('(');
            combinationPar(res, solution, len+1, n, leftNum+1, rightNum);
            solution.deleteCharAt(solution.length()-1);
        }

        if(rightNum < leftNum) {
            solution.append(')');
            combinationPar(res, solution, len+1, n, leftNum, rightNum+1);
            solution.deleteCharAt(solution.length()-1);
        }
    }



    public static void main (String[] args) {

        GenerateParentheses s = new GenerateParentheses();
        s.generateParenthesis(4);

        ArrayList<String> res = new ArrayList<String>();
        StringBuilder solution = new StringBuilder();
        s.combinationPar(res, solution, 0, 4, 0, 0);
        System.out.print("");
    }


}












