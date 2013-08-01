package graph.adt;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 8/1/13
 * Time: 3:08 PM
 */
public class Graph {

    private final int MAX_VERTICES = 20;
    public Vertex[] vertexList;
    public int[][] adjMatrix;
    public int vertexCount;

    public Graph () {

        this.vertexList = new Vertex[MAX_VERTICES];
        this.adjMatrix = new int[MAX_VERTICES][MAX_VERTICES];
        this.vertexCount = 0;
        for (int i = 0; i < MAX_VERTICES; i++)
            for (int j = 0; j < MAX_VERTICES; j++)
                adjMatrix[i][j] = 0;
    }

    /**
     * add a vertex
     *
     */
    public void addVertex (char label){
        vertexList[vertexCount++] = new Vertex(label);
    }

    /**
     * add a edge
     *
     * @param start
     * @param end
     */
    public void addEge (int start, int end) {

        adjMatrix[start][end] = 1;
        adjMatrix[end][start] = 1;
    }

    /**
     * display a vertex
     *
     * @param v
     */
    public void displayVertex (int v) {
        System.out.println(vertexList[v].label);
    }

    public int getAdjUnvisitedVertex (int v) {
        for (int i = 0; i < vertexCount; i++) {
            //v is adjacent to i AND i is NOT visited
            if(adjMatrix[v][i] == 1 && vertexList[i].visited == false)
                return i;
        }

        return -1;
    }


}
































