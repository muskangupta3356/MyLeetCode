class Solution {
public:
     int d[4][2]={{0,1},{0,-1},{1,0},{-1,0}};
    void helper(vector<vector<int>>& image, bool **vis,int r , int c, int x, int y,int color ,int value)
    {
        vis[x][y]=true;
        
        for(int i=0;i<4;i++)
        {
            int a=x+d[i][0];
            int b=y+d[i][1];
            if(a>=0 && a<r && b>=0 && b<c && vis[a][b]==false && image[a][b]==value)
            {
                image[a][b]=color;
                helper(image,vis,r,c,a,b,color,value);
            }
        }
        
       return; 
    }
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int color) {
        
        int r = image.size();
        int c = image[0].size();
        bool **vis = new bool*[r];
        for(int i=0;i<r;i++)
        {
            vis[i]= new bool[c];
            for(int j=0;j<c;j++)
            {
                vis[i][j] = false;
            }
        }
        int value;
       for(int i=0;i<r;i++)
        {
            
            for(int j=0;j<c;j++)
            {
                if(i==sr && j==sc && vis[i][j]==false)
                {
                    value = image[i][j];
                    image[i][j]=color;
                    helper(image,vis,r,c,i,j,color,value);
                }
            }
        }
        
        return image;
        
        
    }
};