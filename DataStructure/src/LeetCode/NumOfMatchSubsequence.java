package LeetCode;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 9/18/13
 * Time: 8:20 AM
 * To change this template use File | Settings | File Templates.
 *
 * Input
 * String1 : bbcc
 * String2 : bc
 *
 * Output
 * 4
 *
 * Algorithm core : all paths from one node to another in graph
 *
 */


public class NumOfMatchSubsequence {


    private ArrayList<GNode> getGList (char[] c1, int n, char[] c2, int m) {

        ArrayList<GNode> list = new ArrayList<GNode>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (c2[i] == c1[j]) {
                    GNode node = new GNode(i, j);
                    list.add(node);
                }
            }
        }

        return list;
    }

    private void getNumOfSubsequence (ArrayList<GNode> list, int m) {

        int numSubsequence = 0;

        ArrayList<GNode> startList = new ArrayList<GNode>();
        ArrayList<GNode> endList = new ArrayList<GNode>();

        for (int i = 0; i < list.size(); i++) {

            GNode curNode = list.get(i);
            if(curNode.x == 0)
                startList.add(curNode);

            if(curNode.x == m - 1)
                endList.add(curNode);
        }

        ArrayList<ArrayList<GNode>> pathList = new ArrayList<ArrayList<GNode>>();
        //ArrayList<Integer> listInt = new ArrayList<Integer>();
        //listInt.add(0);

        for (int i = 0; i < startList.size(); i++) {
            for (int j = 0; j < endList.size(); j++) {

                GNode start = startList.get(i);
                GNode end = endList.get(j);

                if (start.y < end.y) {
                    getPathsFromNodeToAnotherGraph(list, start, end, new ArrayList<GNode>(), pathList);
                    numSubsequence = numSubsequence + pathList.size();
System.out.println(pathList);
                    pathList.clear();
                }


            }
        }

        System.out.print(numSubsequence);
    }

    private void getPathsFromNodeToAnotherGraph (ArrayList<GNode> list, GNode startNode, GNode endNode, ArrayList<GNode> path, ArrayList<ArrayList<GNode>> pathList) {


        if (startNode == null)
            return;
        else {

            path.add(startNode);

            if (startNode.equals(endNode)) {
                ArrayList<GNode> curPath = new ArrayList<GNode>(path);
                pathList.add(curPath);
                //listInt.set(0, listInt.get(0) + 1);
            }

            for (int i = 0; i < list.size(); i++) {

                GNode curNode = list.get(i);
                if (startNode.x == curNode.x - 1 && startNode.y < curNode.y)  //if the two nodes are adjacent
                    getPathsFromNodeToAnotherGraph(list, curNode, endNode, path, pathList);

            }

            path.remove(path.size() - 1);

        }

    }




    public static void main (String[] args) {

        String s1 = "abcaccbccbac";
        char[] c1 = s1.toCharArray();
        int n = c1.length;

        String s2 = "bcac";
        char[] c2 = s2.toCharArray();
        int m = c2.length;

        NumOfMatchSubsequence nms = new NumOfMatchSubsequence();

        nms.getNumOfSubsequence(nms.getGList(c1, n, c2, m), m);



    }




}





























