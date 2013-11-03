package LeetCode.hash;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 10/31/13
 *
 * http://oj.leetcode.com/problems/anagrams/
 *
 */


public class Anagrams {

    public ArrayList<String> anagrams(String[] strs) {

        ArrayList<String> list = new ArrayList<String>();

        if(strs.length == 0)
            return list;

        HashMap<String, ArrayList<Integer>> hash = new HashMap<String, ArrayList<Integer>>();

        for (int i = 0; i < strs.length; i++) {


            char[] curChars = strs[i].toCharArray();

            if(!strs[i].isEmpty())
                Arrays.sort(curChars);
            String curStr = String.valueOf(curChars);

            if(!hash.containsKey(curStr)) {
                ArrayList<Integer> tmpList = new ArrayList<Integer>();
                tmpList.add(i);
                hash.put(curStr, tmpList);
            } else {
                hash.get(curStr).add(i);
            }
        }

        Iterator it = hash.entrySet().iterator();
        while (it.hasNext()) {

            Map.Entry<String, ArrayList<Integer>> entry = (Map.Entry)it.next();
            ArrayList<Integer> value = entry.getValue();
            if (value.size() > 1) {
                for (int i = 0; i < value.size(); i++) {
                    list.add(strs[value.get(i)]);
                }
            }

        }

        return list;
    }

    public static void main (String[] args) {


//        String str = "bcade";
//        char[] chars = str.toCharArray();
//        Arrays.sort(chars);
//        System.out.print(chars);

        Anagrams s = new Anagrams();
        String[] strs  = {"", ""};
        System.out.print(s.anagrams(strs));

    }


}
