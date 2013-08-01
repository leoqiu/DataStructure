package graph.adt;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 8/1/13
 * Time: 3:08 PM
 */
public class Vertex {

    public char label;
    public boolean visited;


    public Vertex (char label) {
        this.label = label;
        this.visited = false;
    }

}
