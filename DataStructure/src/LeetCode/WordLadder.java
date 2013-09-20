package LeetCode;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 9/19/13
 *
 * http://oj.leetcode.com/problems/word-ladder/
 *
 * Algorithm core : shortest path from one node to another in graph
 */
public class WordLadder {

    private ArrayList<GWLNode> getListGraph (String start, String end, HashSet<String> set) {

        int len = start.length();

        ArrayList<GWLNode> list = new ArrayList<GWLNode>();
        list.add(new GWLNode(start, false));

        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            String str = it.next();
            GWLNode node = new GWLNode(str, false);
            if (str.length() == len)
                list.add(node);
        }

        list.add(new GWLNode(end, false));

        return list;
    }


    private int getShortestDistances (int startNode, int endNode, int n, ArrayList<GWLNode> list) {

        int v2;

        int[] distances = new int[n];
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(startNode);
        list.get(startNode).isVisited = true;

        //init distance[]
        for (int i = 0; i < distances.length; i++) {
            distances[i] = -1;
        }
        distances[startNode] = 0;


        while (!queue.isEmpty()) {

            int v1 = queue.poll();

            while ( (v2 = getUnvisitedAdjNode(v1, list)) != -1 ) {

                if (distances[v2] == -1) {

                    distances[v2] = distances[v1] + 1;
                    list.get(v2).isVisited = true;
                    queue.offer(v2);

                }
            }

        }

        return distances[endNode] + 1;
    }

    private int getUnvisitedAdjNode (int v1, ArrayList<GWLNode> list) {

        GWLNode node1 = list.get(v1);

        for (int i = 0; i < list.size(); i++) {

            GWLNode node2 = list.get(i);
            if(isAdj(node1, node2) && !node2.isVisited)
                return i;

        }

        return -1;
    }

    private boolean isAdj (GWLNode node1, GWLNode node2) {

        boolean isAdj = false;

        char[] word1 = node1.word.toCharArray();
        char[] word2 = node2.word.toCharArray();
        int n = word1.length;
        int diffNum = 0;

        for (int i = 0; i < n; i++) {
            if(word1[i] != word2[i])
                diffNum++;
        }

        if (diffNum == 1)
            isAdj = true;

        return isAdj;
    }


    public static void main (String[] args) {

        HashSet<String> set = new HashSet<String>();
//        set.add("hot");
//        set.add("dot");
//        set.add("dog");
//        set.add("lot");
//        set.add("log");
//        String start = "hit";
//        String end = "cog";

        set.add("a");
        set.add("b");
        set.add("c");
        String start = "a";
        String end = "c";

        WordLadder wl = new WordLadder();

        ArrayList<GWLNode> list = wl.getListGraph(start, end, set);
        int n = list.size();
        System.out.println(wl.getShortestDistances(0, list.size() - 1, n, list));


    }







}


class GWLNode {

    String word;
    boolean isVisited;

    public GWLNode (String word, boolean visited) {

        this.word = word;
        this.isVisited = false;

    }

}























































