package LeetCode.graphs;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 11/30/13
 *
 * http://oj.leetcode.com/problems/word-ladder-ii/
 *
 */


class Count {
    String str;
    int count;
    ArrayList<String> path;

    public Count(String s, int c, ArrayList<String> path) {
        this.str = s;
        this.count = c;
        this.path = new ArrayList<String>(path);
    }
}


public class WordLadderTwo {



    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {

        ArrayList<ArrayList<String>> solutions = new ArrayList<ArrayList<String>>();
        ArrayList<String> solution = new ArrayList<String>();

        if (start.equals(end)){
            solution.add(start); solution.add(end);
            solutions.add(solution);
            return solutions;
        }

        Map<String, Boolean> visited = new HashMap<String, Boolean>();
        LinkedList<Count> queue = new LinkedList<Count>();
        solution.add(start);
        queue.add(new Count(start, 1, solution));
        visited.put(start, true);

        boolean isFoundASolution = false;
        while (!queue.isEmpty()) {
            Count c = queue.poll();
            // for each character in the string, start new branches
            for (int i = 0; i < start.length(); i++) {
                StringBuilder sb = new StringBuilder(c.str);
                char sc = c.str.charAt(i);
                // for each different character as new node
                for (char cc = 'a'; cc <= 'z'; cc++) {
                    if (cc == sc) continue;
                    sb.setCharAt(i, cc);
                    String tmp = sb.toString();
                    // if we haven't visited this node and is in our dictionary
                    // we visit this node
                    if (dict.contains(tmp)) {
                        if (tmp.equals(end)) {
                            isFoundASolution = true;
                            ArrayList<String> solutionList = new ArrayList<String>(c.path);
                            solutionList.add(end);
                            solutions.add(solutionList);
                        }

                       if(!isFoundASolution) {
                            //visited.put(tmp, true);
                            ArrayList<String> newPath = new ArrayList<String>(c.path);
                            newPath.add(tmp);
                            queue.add(new Count(tmp, c.count+1, newPath));
                      }
                    }
                }
                sb.setCharAt(i, sc);
            }
        }

        trimSolutions(solutions);

        return solutions;
    }


    private void trimSolutions (ArrayList<ArrayList<String>> solutions) {

        if(solutions.size() > 0) {
            int min = solutions.get(0).size();
            for (int i = 1; i < solutions.size(); i++)
                min = Math.min(min, solutions.get(i).size());

            for (int i = 0; i < solutions.size(); i++)
                if(solutions.get(i).size() > min)
                    solutions.remove(i);

        }
    }

    public static void main (String[] args) {

        WordLadderTwo s = new WordLadderTwo();

//        String start = "hit";
//        String end = "cog";
//        String[] inputs = {"hot","dot","dog","lot","log"};

//        String start = "a";
//        String end = "c";
//        String[] inputs = {"a","b","c"};

        String start = "red";
        String end = "tax";
        String[] inputs = {"ted","tex","red","tax","tad","den","rex","pee"};


        HashSet<String> dict = new HashSet<String>();
        dict.add(end);

        for (int i = 0; i < inputs.length; i++)
            dict.add(inputs[i]);

        s.findLadders(start, end, dict);

    }


}































