package LeetCode.dp;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 11/3/13
 *
 *
 *
 */


public class UniquePathsTwo {


    public static int pathNum = 0;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {


        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        getUniquePathsWithObstacles(0, 0, m, n, obstacleGrid);


         return pathNum;
    }

    private void getUniquePathsWithObstacles (int startX, int startY, int m, int n, int[][] obstacleGrid) {

        if (startX == m-1 && startY == n-1) {
            pathNum++;
            return;
        }

        if(startX < m-1 && obstacleGrid[startX+1][startY] != 1) {
            //startX++;
            getUniquePathsWithObstacles(startX+1, startY, m, n, obstacleGrid);
        }

        if(startY < n-1 && obstacleGrid[startX][startY+1] != 1) {
            //startY++;
            getUniquePathsWithObstacles(startX, startY+1, m, n, obstacleGrid);
        }

    }

    public int uniquePathsWithObstaclesDP (int[][] obstacleGrid) {


        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        for (int j = 0; j < n;) {
            if(obstacleGrid[0][j] != 1) {
                obstacleGrid[0][j] = -1;
                j++;
            } else {
                for ( ; j < n; j++)
                    obstacleGrid[0][j] = 1;
            }
        }

        //i starts from 1, corner case {1}
        for (int i = 0; i < m;) {
            if(obstacleGrid[i][0] != 1) {
                obstacleGrid[i][0] = -1;
                i++;
            } else {
                for ( ; i < m; i++)
                    obstacleGrid[i][0] = 1;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if(obstacleGrid[i][j] == 1)
                    obstacleGrid[i][j] = 0;
                else {

                    if(i == 0 && j == 0)
                        ;
                    else if (i == 0 && j > 0)
                        obstacleGrid[i][j] = 0 + obstacleGrid[i][j-1];
                    else if (i > 0 && j == 0)
                        obstacleGrid[i][j] = obstacleGrid[i-1][j] + 0;
                    else
                        obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
                }
            }
        }

        return -obstacleGrid[m-1][n-1];
    }

    public static void main (String[] args) {

        UniquePathsTwo s = new UniquePathsTwo();
        int[][] obstacleGrid = {
                {0,0,0,1,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
        };

        //corner case
//        int[][] obstacleGrid = {
//                {1,0},
//
//        };

//        int[][] obstacleGrid = {
//                {1},
//
//        };

//        int[][] obstacleGrid = {
//                {1,0},
//
//
//
//        };

//        int[][] obstacleGrid = {
//
//                {0,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0},
//                {0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
//                {0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0},
//                {1,1,1,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,1,1,0,0,0,0,0,0,0,0,1,0,0,1},
//                {0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0},
//                {0,0,0,1,0,1,0,0,0,0,1,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1,1,0},
//                {1,0,1,1,1,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0},
//                {0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,1,0,0,0,1,0,1,0,0,0,0,0,0},
//                {0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,1,0},
//                {0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,1,0,0,0,0,0},
//                {0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},
//                {1,0,1,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,1,0,1,0,0,0,1,0,1,0,0,0,0,1},
//                {0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,1,0,0,0,0,0,0,1,1,0,0,0,0,0},
//                {0,1,0,1,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,1,0,0,0,0,0},
//                {0,1,0,0,0,0,0,0,1,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,1,0,1},
//                {1,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
//                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,1,1,0,0,1,0,0,0,0,0,0},
//                {0,0,1,0,0,0,0,0,0,0,1,0,0,1,0,0,1,0,0,0,0,0,0,1,1,0,1,0,0,0,0,1,1},
//                {0,1,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,1,1,0,1,0,1},
//                {1,1,1,0,1,0,0,0,0,1,0,0,0,0,0,0,1,0,1,0,1,1,0,0,0,0,0,0,0,0,0,0,0},
//                {0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,1,1},
//                {0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,1,0,0,0,1,0,0,0}
//
//        };


        System.out.print(s.uniquePathsWithObstacles(obstacleGrid));
    }

}
