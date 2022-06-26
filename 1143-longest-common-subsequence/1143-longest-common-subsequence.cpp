class Solution {
public:
    int longestCommonSubsequence(string text1, string text2) {
        int n1 = text1.length();
        int n2 = text2.length();
        int **dp = new int*[n1+1];
        for(int i=0;i<=n1;i++)
        {
            int *temp = new int [n2+1];
            dp[i]= temp;
            
        }
        for(int i=0;i<=n1;i++)
        {
            for (int j=0;j<=n2;j++)
            
                if(i==0 || j==0)
                dp[i][j]=0;
            
        }
        
         for(int i=1;i<=n1;i++)
        {
            for (int j=1;j<=n2;j++)
            {
                if(text1[i-1]==text2[j-1])
                    dp[i][j]= 1 + dp[i-1][j-1];

                else
                    dp[i][j]=max(dp[i][j-1],dp[i-1][j]);
            }
        }
        return dp[n1][n2];
    }
    
};