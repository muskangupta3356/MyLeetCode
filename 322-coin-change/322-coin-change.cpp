class Solution {
public:
    int coinChange(vector<int>& coins, int S) {
            int n = coins.size();
    int **dp = new int* [n+1];
    for(int i=0;i<=n;i++)
    {
        dp[i]= new int [S+1];
        for(int j=0;j<=S;j++)
            dp[i][j]=0;
    }
    
    for(int j=1;j<=S;j++)
    {
        dp[0][j]=INT_MAX-1;
    }
    for(int i=1;i<=n;i++)
    {
        for(int j=1;j<=S;j++)
        {   if((j-coins[i-1])>=0)
            {
                dp[i][j]= min(dp[i-1][j],1+dp[i][j-coins[i-1]]);
            }
            else
                dp[i][j]=dp[i-1][j];
        }
    }

    if(dp[n][S]==INT_MAX-1)
        return -1;
    else
        return dp[n][S]; 
        
    }
};