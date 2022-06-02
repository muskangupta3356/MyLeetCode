class Solution {
public:
    void helper(int n, int& ans)
    {
        if(n<=0)
        {
            ans++;
            return;
        }
        if(n>=1)
            helper(n-1,ans);
        if(n>=2)
            helper(n-2,ans);
        return;
        
    }
    int climbStairs(int n) {
        // int ans=0;
        // if(n>=1)
        //     helper(n-1,ans);
        // if(n>=2)
        //     helper(n-2,ans);
        // return ans;
        int*dp = new int [n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++)
        {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
};