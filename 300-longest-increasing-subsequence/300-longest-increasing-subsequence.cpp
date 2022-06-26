class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        int n = nums.size();
        int* dp = new int[n];
        for(int i=0;i<n;i++)
            dp[i]=1;
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(nums[i]>nums[j] && dp[i]<=dp[j])
                    dp[i]= 1 + dp[j];
            }
        }
     int ans=0;   
    for(int i=0;i<n;i++)
        ans= max(ans,dp[i]);
        
        return ans;
    }
};