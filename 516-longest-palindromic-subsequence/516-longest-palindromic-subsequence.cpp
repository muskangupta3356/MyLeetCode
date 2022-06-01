class Solution {
public:
    int longestPalindromeSubseq(string s) {
        string t = s;
         reverse(t.begin(), t.end());
        int n = s.length();
        int**dp = new int*[n+1];
        for(int i=0;i<=n;i++)
        {
            int* temp = new int[n+1];
            dp[i]=temp;
        }
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=n;j++)
            {
                if(i==0)
                    dp[i][j]=0;
                if(j==0)
                    dp[i][j]=0;
            }
        }
        
         for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=n;j++)
            {
                if(s[i-1]==t[j-1])
                {
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else
                {
                    dp[i][j]=max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return dp[n][n];
        
    }
};