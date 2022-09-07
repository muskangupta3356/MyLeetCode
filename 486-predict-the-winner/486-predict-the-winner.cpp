class Solution {
public:
    bool PredictTheWinner(vector<int>& nums) {
        int n=nums.size();
        pair<int,int> **dp = new pair<int,int>* [n];
        for(int i=0;i<n;i++)
        {
            dp[i]= new pair<int,int> [n];
            for(int j=0;j<n;j++)
            {
                if(i==j)
                    dp[i][j]= make_pair(nums[i],0);
                else
                    dp[i][j]=make_pair(0,0);       
            }
        }
        
        for(int k=1;k<n;k++)
        {
            int i=0;int j=i+k;
            while(j<n)
            { 
                int sum=0;
                for(int l=i;l<=j;l++)
                    sum+=nums[l];
                int temp= max(nums[i]+dp[i+1][j].second,nums[j]+dp[i][j-1].second);
                dp[i][j]=make_pair(temp,sum-temp);
                
                i++;
                j++;
            }
        }
        if(dp[0][n-1].first>=dp[0][n-1].second)
            return true;
        else
            return false;
        
    }
};