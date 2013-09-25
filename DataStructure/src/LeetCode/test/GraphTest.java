package LeetCode.test;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 9/17/13
 *
 * For PalindromePartitioning1
 *
 * all possible paths in graph
 *
 * http://blog.csdn.net/hcx25909/article/details/8043107
 */
public class GraphTest {




    private ArrayList<GNode> getLis () {

        ArrayList<GNode> list = new ArrayList<GNode>();

        GNode p1 = new GNode(0, 0);
        GNode p2 = new GNode(0, 3);
        GNode p3 = new GNode(0, 6);
        GNode p4 = new GNode(1, 1);
        GNode p5 = new GNode(1, 2);
        GNode p6 = new GNode(1, 5);
        GNode p7 = new GNode(2, 2);
        GNode p8 = new GNode(2, 4);
        GNode p9 = new GNode(3, 3);
        GNode p10 = new GNode(3, 6);
        GNode p11 = new GNode(4, 4);
        GNode p12 = new GNode(4, 5);
        GNode p13 = new GNode(5, 5);
        GNode p14 = new GNode(6, 6);
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(p5);
        list.add(p6);
        list.add(p7);
        list.add(p8);
        list.add(p9);
        list.add(p10);
        list.add(p11);
        list.add(p12);
        list.add(p13);
        list.add(p14);

        return list;

    }

    private int[][] initGArray (ArrayList<GNode> list) {

        int[][] gArr = new int[list.size()][list.size()];

        for (int i = 0; i < list.size(); i++) {
            GNode node1 = list.get(i);
            for (int j = i+1; j < list.size(); j++) {

                GNode node2 = list.get(j);
                //if adjacent, connect them
                if (node1.y + 1 == node2.x)
                    gArr[i][j] = 1;
            }
        }

        return gArr;
    }

    private void allPathsFromNodeToAnotherGraph (GNode nodeS, GNode nodeE, ArrayList<GNode> path, ArrayList<ArrayList<GNode>> pathList, ArrayList<GNode> list) {

//        if (nodeS == null)
//            return;
//        else {

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

            System.out.println(path);
//        }

    }


    public ArrayList<ArrayList<GNode>> getRootToLeafPathList(ArrayList<GNode> list) {

        ArrayList<ArrayList<GNode>> pathList = new ArrayList<ArrayList<GNode>> ();
        allPathsFromNodeToAnotherGraph(list.get(0), list.get(9), new ArrayList<GNode>(), pathList, list);
        return pathList;
    }


    //
    public static void main (String[] args) {

        GraphTest gt = new GraphTest();

        int[][] gArr = gt.initGArray(gt.getLis());

        System.out.print(gt.getRootToLeafPathList(gt.getLis()));

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
