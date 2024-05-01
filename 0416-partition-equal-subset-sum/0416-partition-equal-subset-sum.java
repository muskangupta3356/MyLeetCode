class Solution {
    public boolean canPartition(int[] nums) {
        int sum =0;
        for( int n : nums){
            sum+= n;
        }
        if(sum%2!=0)
            return false;
        else sum =sum/2;
        int l = nums.length;
        int[][] dp = new int [l+1][sum+1];
        for(int i=0;i<=l;i++){
            for(int j=0;j<=sum;j++){
                if(i==0 || j==0)
                    dp[i][j]=0;
            }
        }
          for(int i=1;i<=l;i++){
            for(int j=1;j<=sum;j++){
                if(j-nums[i-1]>=0)
                    dp[i][j]= Math.max(dp[i-1][j],nums[i-1]+dp[i-1][j-nums[i-1]]);
                else
                    dp[i][j]=dp[i-1][j];
                if(dp[i][j]==sum)
                    return true;
            }
        }
        return false;
    }
}