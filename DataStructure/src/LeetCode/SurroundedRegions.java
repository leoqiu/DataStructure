package LeetCode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 9/16/13
 *
 *
 * http://oj.leetcode.com/problems/surrounded-regions/
 *
 * Algorithm core : Graph dfs or bfs search
 */
public class SurroundedRegions {



    public void printArr (char[][] chars) {

        for (int i = 0; i < chars.length; i++) {
            for(int j = 0; j < chars[i].length; j++)
                System.out.print(chars[i][j] + " ");
            System.out.println();
        }

    }


    public void flip4 (int x , int y, char[][] chars, int[][] isVisited) {

        //if point is on border
        if (x == 0 || y == 0 || x == chars.length - 1 || y == chars[0].length - 1)
            return;

        //mark (x, y) at visited
        isVisited[x][y] = 1;

        if ( (chars[x-1][y] == 'x' || isVisited[x-1][y] == 1) && (chars[x+1][y] == 'x' || isVisited[x+1][y] == 1)
                && (chars[x][y-1] == 'x' || isVisited[x][y-1] == 1)  && (chars[x][y+1] == 'x' || isVisited[x][y+1] == 1))
            chars[x][y] = 'x';

        if (chars[x-1][y] == 'o') {
            flip4(x - 1, y, chars, isVisited);
        }


        if (chars[x+1][y] == 'o'){
            flip4(x + 1, y, chars, isVisited);
        }


        if (chars[x][y-1] == 'o' ) {
            flip4(x, y - 1, chars, isVisited);
        }


        if (chars[x][y+1] == 'o' ) {
            flip4(x, y+1, chars, isVisited);
        }


    }

    public static void main (String[] args) {

        SurroundedRegions sr = new SurroundedRegions();

        char[][] chars = {
                {'x', 'x' , 'x', 'x'},
                {'x', 'o' , 'o', 'x'},
                {'x', 'o' , 'o', 'x'},
                {'x', 'o' , 'x', 'x'},
                {'x', 'x' , 'o', 'o'},
                {'x', 'o' , 'o', 'x'},
                {'x', 'x' , 'o', 'x'},
                {'x', 'o' , 'x', 'x'}
        };

        sr.printArr(chars);

        int[][] visits = new int[chars.length][chars[0].length];

        //boolean isSurrounded = false;

        //Point p = new Point(1, 1);
        ArrayList<ArrayList<Point>> listOfList = new ArrayList<ArrayList<Point>>();

        for (int i = 1; i < chars.length - 1; i++) {
            for (int j = 1; j < chars[0].length - 1; j++) {

                if (chars[i][j] == 'o' && visits[i][j] == 0) {
                    //isSurrounded = sr.dfsOs(new Point(i, j), visits, chars, list) ;
                    ArrayList<Point> list = sr.dfsOs(new Point(i, j), visits, chars);

                    if (!list.isEmpty())
                        listOfList.add(list);

                }

            }

        }


        for (int i = 0; i < listOfList.size(); i++) {
            for (int j = 0; j < listOfList.get(i).size(); j++) {
                Point temp = listOfList.get(i).get(j);
                chars[temp.x][temp.y] = 'x';
            }
        }

        System.out.println();
        sr.printArr(chars);

    }


    public ArrayList<Point> dfsOs (Point p, int[][] visits, char[][] chars) {

        ArrayList<Point> list = new ArrayList<Point>();

        boolean isGraphOSurrounded = false;

        Stack<Point> stack = new Stack<Point>();
        visits[p.x][p.y] = 1; //set as visited
       // p.show();
        stack.push(p);
        list.add(p);

        while (!stack.isEmpty()) {

            Point point = null;

            //unvisited and adjacent vertex
            Point tempP = stack.peek();

            if ( !(tempP.x == 0 || tempP.y == 0 || tempP.x == chars.length - 1 || tempP.y == chars[0].length - 1) )
                point = getAdjUnvisitedVertex(tempP, chars, visits);

            if (point == null) {
                stack.pop();
            } else {

                if (point.x == 0 || point.y == 0 || point.x == chars.length - 1 || point.y == chars[0].length - 1)
                    isGraphOSurrounded = true;

                visits[point.x][point.y] = 1;
                //point.show();
                stack.push(point);
                list.add(point);
            }

        }

        if (isGraphOSurrounded)
            list.clear();

        return list;
    }


    private Point getAdjUnvisitedVertex (Point p, char[][] chars, int[][] visits) {

        int x = p.x;
        int y = p.y;

        if (chars[x-1][y] == 'o' && visits[x-1][y] == 0)
            return new Point(x-1, y);
        else if (chars[x][y-1] == 'o' && visits[x][y-1] == 0)
            return new Point(x, y-1);
        else if (chars[x][y+1] == 'o' && visits[x][y+1] == 0)
            return new Point(x, y+1);
        else if (chars[x+1][y] == 'o' && visits[x+1][y] == 0)
            return new Point(x+1, y);
        else
            return null;

    }


}


class Point {

    int x;
    int y;
    boolean isVisited = false;

    public Point (int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void show () {
        System.out.print("(" + this.x + ", " + this.y + ")" + "  ");
    }

}




















