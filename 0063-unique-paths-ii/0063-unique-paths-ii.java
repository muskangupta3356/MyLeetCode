class Solution {
    int[] xd = {0,1};
    int[] yd = {1,0};
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] memo = new int [m][n];
        if(obstacleGrid[0][0] == 1  || obstacleGrid[m-1][n-1] == 1)
            return 0;
        return helper(obstacleGrid, memo, 0,0,m-1,n-1);
        
    }
    
    public int helper(int[][] obstacleGrid, int[][] memo, int x, int y, int row, int col){
        if(x == row && y ==col)
            return 1;
        if(memo[x][y] != 0)
            return memo[x][y];
        int count =0 ;
        for(int i=0;i<2;i++){
            int xt = x + xd[i];
            int yt = y + yd[i];
            if(xt>= 0 && xt<=row && yt>=0 && yt <= col && obstacleGrid[xt][yt]==0){
                count += helper(obstacleGrid, memo, xt, yt, row, col);
            }
        }
        memo[x][y] = count;
        return count;
    }
}