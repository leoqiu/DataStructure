package graph;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 8/1/13
 * Time: 12:09 PM
 */


/**
 * Graph Representation
 *      #1. Adjacency Matrix
 *          1. The adjacency matrix representation is good if the graphs are dense.
 *
 *      #2. Adjacency List
 *          1. Using adjacency list representation we can not perform operations efficiently, like deleting a node
 *
 *
 */


import graph.adt.Graph;
import graph.adt.Vertex;

import java.util.Stack;

/**
 * Graph Traversal
 *      #1. DFS
 *
 *      #2. BFS
 *
 *
 *
 *
 */




public class BasicOperations {



    public void dfs (Graph graph) {

        Stack<Integer> stack = new Stack<Integer>();

        //dfs starting at the first vertex
        graph.vertexList[0].visited = true;
        graph.displayVertex(0);
        stack.push(0);

        while (!stack.isEmpty()) {

            //unvisited and adjacent vertex
            int v = graph.getAdjUnvisitedVertex(stack.peek());
            if (v == -1)
                stack.pop();
            else {
                graph.displayVertex(v);
                graph.vertexList[v].visited = true;
                stack.push(v);

            }
        }

        for (int i = 0; i < graph.vertexCount; i++) {
            graph.vertexList[i].visited = false;
        }

    }


    public void dfsR () {}




    public static void main (String[] args) {

        Graph graph = new Graph();
        //add vertexes
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');
        graph.addVertex('F');
        graph.addVertex('G');
        graph.addVertex('H');

        //add edges
        graph.addEge(1 , 0);
        graph.addEge(2 , 1);
        graph.addEge(3 , 2);
        graph.addEge(4 , 2);
        graph.addEge(5 , 4);
        graph.addEge(6 , 4);
        graph.addEge(7 , 1);
        graph.addEge(7 , 4);

        BasicOperations bo = new BasicOperations();
        bo.dfs(graph);
    }
}
































