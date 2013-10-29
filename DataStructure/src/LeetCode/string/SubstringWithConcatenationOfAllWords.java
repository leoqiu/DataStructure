package LeetCode.string;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 10/28/13
 *
 *
 *  http://oj.leetcode.com/problems/substring-with-concatenation-of-all-words/
 *
 */


public class SubstringWithConcatenationOfAllWords {


    //Can not handle duplicate words in L case
    public ArrayList<Integer> findSubstring(String S, String[] L) {

        HashMap<String, Integer> hash = new HashMap<String, Integer>();
        ArrayList<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < L.length; i++)
            hash.put(L[i], 1);

        int len = L[0].length();
        int curStart = 0;

        for (int i = 0; i < S.length() - len;) {

            String curStr = S.substring(i, i+len);
            if (hash.containsKey(curStr) && hash.get(curStr) == 1) {
                hash.put(curStr, hash.get(curStr) + 1);
                i = i + len;
            } else {
                curStart++;
                i = curStart;
            }

            if (!hash.containsValue(1)) {
                list.add(curStart);
                curStart = i;
                i = curStart;

                for (int j = 0; j < L.length; j++)
                    hash.put(L[j], 1);
            }

        }

        return list;
    }


    //一个长度为M*N的子串在S上从左到右平移，每个位置上，直接去判断是不是每一个L中的单词都出现了一次
    public ArrayList<Integer> findSubstring2(String S, String[] L) {

        int len = L[0].length();
        int allLen = len * L.length;

        HashMap<String, Integer> hash = new HashMap<String, Integer>();
        ArrayList<Integer> list = new ArrayList<Integer>();

        if(allLen > S.length())
            return list;

        for (int i = 0; i < L.length; i++){
            String curStr = L[i];
            if (hash.containsKey(curStr))
                hash.put(curStr, hash.get(curStr)+1);
            else
                hash.put(curStr, 1);
        }



        int startIndex = 0;
        HashMap<String, Integer> tmp = new HashMap<String, Integer>(hash);
        for (int i = 0; i <= S.length() - len;) {

            String curStr = S.substring(i, i+len);

            if(tmp.containsKey(curStr)) {
                int curVal = tmp.get(curStr) - 1;
                if(curVal == 0)
                    tmp.remove(curStr);
                else
                    tmp.put(curStr, curVal);
                i = i+len;
            } else {
                startIndex++;
                i = startIndex;
                //re set hash
                tmp = new HashMap<String, Integer>(hash);
                continue;
            }

            if(tmp.isEmpty()) {
                //re set hash
                tmp = new HashMap<String, Integer>(hash);
                list.add(startIndex);
//                startIndex = startIndex + allLen;
//                i = startIndex;
                startIndex++;
                i = startIndex;
            }
        }

        return list;
    }

    private void resetHash (HashMap<String, Integer> hash, String[] L) {
        hash.clear();
        for (int i = 0; i < L.length; i++){
            if (hash.containsValue(L[i]))
                hash.put(L[i], hash.get(L[i])+1);
            else
                hash.put(L[i], 1);
        }
    }

    public static void main (String[] args) {

        String S = "barfoothefoobarman";
        String[] L = {"foo", "bar"};
        SubstringWithConcatenationOfAllWords s = new SubstringWithConcatenationOfAllWords();
        s.findSubstring2(S, L);

    }

}
























