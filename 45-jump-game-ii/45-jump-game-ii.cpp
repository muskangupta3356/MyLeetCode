class Solution {
public:
    int jump(vector<int>& nums) {
        int n = nums.size();
        long *dp = new long[n];
        dp[n-1]=0;
        for(int i=0;i<=n-2;i++)
        {
            dp[i]=INT_MAX;
        }
        for(int j=n-2;j>=0;j--)
        {
            for(int i=1;i<=nums[j];i++)
            {   if(j+i < n)
                dp[j]= min(dp[j],1+dp[j+i]);
            }
        }
        return dp[0];
    }
};