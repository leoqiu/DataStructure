package LeetCode;

import java.util.ArrayList;

/**
 *
 * http://oj.leetcode.com/problems/
 *
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 9/17/13
 *
 * http://oj.leetcode.com/problems/palindrome-partitioning/
 *
 * given s = "aab",
 *
 * [
     ["aa","b"],
     ["a","a","b"]
   ]
 *
 *
 *
 * @see LeetCode.test.GraphTest
 *
 */


public class PalindromePartitioning1 {


    private void printChars (char[] chars, GNode node) {

        for (int i = node.x; i <= node.y; i++) {
            System.out.print(chars[i]);
        }
    }

    private void printSubsets (ArrayList<ArrayList<GNode>> pathList, char[] chars) {

        for (int i = 0; i < pathList.size(); i++) {
            ArrayList<GNode> path = pathList.get(i);
            for (int j = 0; j < path.size(); j++) {
                printChars(chars, path.get(j));
                System.out.print(" ");
            }
            System.out.println();
        }

    }

    private ArrayList<GNode> getGnodeList (char[] chars, int n) {

        ArrayList<GNode> list = new ArrayList<GNode>();
        int[][] dpArr = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= i; j--) {

                GNode node = null;

                if (i == j) {
                    node = new GNode(i, j);
                    dpArr[i][j] = 1;
                } else if (j - i + 1 == 2 && chars[i] == chars[j]) {
                    node = new GNode(i, j);
                    dpArr[i][j] = 1;
                } else if (chars[i] == chars[j] && dpArr[i+1][j-1] == 1) {
                    node = new GNode(i, j);
                    dpArr[i][j] = 1;
                }

                if (node != null)
                    list.add(node);
            }
        }

        return list;
    }


    private void allPathsFromNodeToAnotherGraph (GNode nodeS, GNode nodeE, ArrayList<GNode> path, ArrayList<ArrayList<GNode>> pathList, ArrayList<GNode> list) {

        if (nodeS == null)
            return;
        else {

            //nodeS.isVisited = true;
            path.add(nodeS);

            if (nodeS.equals(nodeE)) {
                ArrayList<GNode> currentPath = new ArrayList<GNode>(path);
                pathList.add(currentPath);
            }

            for (int i = 0; i < list.size(); i++) {

                GNode curNode = list.get(i);
                if (nodeS.y + 1 == curNode.x) // if nodeS and curNode are adjacent
                    allPathsFromNodeToAnotherGraph(curNode, nodeE, path, pathList, list);
            }

            path.remove(path.size() - 1);

        }

    }


    public void getAllPathsNodeToAnotherGraph (ArrayList<GNode> list, int n, char[] chars) {

        ArrayList<GNode> startNodes = new ArrayList<GNode>();
        ArrayList<GNode> endNodes = new ArrayList<GNode>();

        for (int i = 0; i < list.size(); i++) {
            GNode node = list.get(i);
            if(node.x == 0)
                startNodes.add(node);

            if(node.y == n-1)
                endNodes.add(node);
        }

        for (int i = 0; i < startNodes.size(); i++) {
            for (int j = 0; j < endNodes.size(); j++) {
                GNode startNode = startNodes.get(i);
                GNode endNode = endNodes.get(j);

                if(startNode.x == 0 && startNode.y == n - 1 && startNode.equals(endNode))
                    System.out.println(chars);

                if(startNode.y < endNode.x){
                    ArrayList<ArrayList<GNode>> pathList = new ArrayList<ArrayList<GNode>> ();
                    allPathsFromNodeToAnotherGraph(startNode, endNode, new ArrayList<GNode>(), pathList, list);

                    if (!pathList.isEmpty()) {
                        printSubsets(pathList, chars);
                    }
                }

            }

        }
    }

    public static void main (String[] args) {

        String str = "abbabba";
        //String str = "aab";
        char[] chars = str.toCharArray();
        int n = chars.length;

        PalindromePartitioning1 pp = new PalindromePartitioning1();
        //pp.getGnodeList(chars, n);
        pp.getAllPathsNodeToAnotherGraph(pp.getGnodeList(chars, n), n, chars);
    }

}


class GNode {
    int x;
    int y;
    boolean isVisited = false;

    public GNode (int x, int y) {
        this.x = x;
        this.y = y;
    }


    @Override
    public String toString() {
        return "(" + this.x + " , " +this.y+ ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GNode)) return false;

        GNode gNode = (GNode) o;

        if (isVisited != gNode.isVisited) return false;
        if (x != gNode.x) return false;
        if (y != gNode.y) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        result = 31 * result + (isVisited ? 1 : 0);
        return result;
    }
}










