package LeetCode.graphs;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 12/5/13
 * Time: 9:36 AM
 * To change this template use File | Settings | File Templates.
 */


class UndirectedGraphNode {
    int label;
    ArrayList<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
};


public class CloneGraph {


    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {

        if (node == null)
            return node;

        HashSet<UndirectedGraphNode> hashVisit = new HashSet<UndirectedGraphNode>();
        HashMap<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.offer(node);
        hashVisit.add(node);
        UndirectedGraphNode res = cloneNode(node);
        map.put(res.label, res);


        while (!queue.isEmpty()) {

            node = queue.poll();

            for (int i = 0; i < node.neighbors.size(); i++) {
                UndirectedGraphNode curAdjNode = node.neighbors.get(i);
                if (!hashVisit.contains(curAdjNode)) {
                    queue.offer(curAdjNode);
                    hashVisit.add(curAdjNode);
                    UndirectedGraphNode cloneNode = cloneNode(curAdjNode);
                    map.put(cloneNode.label, cloneNode);
                }
            }
        }

        Iterator it = map.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry<Integer, UndirectedGraphNode> entry = (Map.Entry)it.next();
            ArrayList<UndirectedGraphNode> neighbors = entry.getValue().neighbors;

            for (int i = 0; i<neighbors.size(); i++) {
                UndirectedGraphNode curNeighbor = map.get(neighbors.get(i).label);
                neighbors.set(i, curNeighbor);
            }
        }

        return res;
    }


    private UndirectedGraphNode cloneNode(UndirectedGraphNode node) {
        UndirectedGraphNode copyNode = new UndirectedGraphNode(node.label);
        copyNode.neighbors = new ArrayList<UndirectedGraphNode>(node.neighbors);
        return copyNode;
    }


    private void resetStr(String str) {
        str = "haha";
    }

    public static void main(String[] args) {

        CloneGraph s = new CloneGraph();
//        String str = "hehe";
//        System.out.println(str);
//        s.resetStr(str);
//        System.out.println(str);

        UndirectedGraphNode node = new UndirectedGraphNode(0);
        node.neighbors.add(node);
        node.neighbors.add(node);
        s.cloneGraph(node);


    }


}




































