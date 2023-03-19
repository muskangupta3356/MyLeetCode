class Solution {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[] rtrack = new int[row];
        int[] ctrack = new int[col];
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(matrix[i][j]==0)
                {
                    rtrack[i]=1;
                    ctrack[j]=1;
                }
            }
        }
        
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(rtrack[i]==1 || ctrack[j]==1)
                    matrix[i][j]=0;
            }
        }
        
        return;
        
    }
}