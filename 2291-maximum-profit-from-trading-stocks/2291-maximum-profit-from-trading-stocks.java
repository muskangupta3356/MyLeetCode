class Solution {
    public int maximumProfit(int[] present, int[] future, int budget) {
        int n = present.length;
        int[] value = new int [n];
        for(int i=0;i<n;i++){
            value[i] = future[i] - present [i];
        }
        
        int[][] dp = new int [n+1][budget+1];
        
        for(int i=1;i<=n;i++){
            for(int j=0;j<=budget;j++){
                if(present[i-1]<= j){
                    dp[i][j] = Math.max(dp[i-1][j],value[i-1]+dp[i-1][j-present[i-1]]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
                    
            }
        }
        
        return dp[n][budget];
        
    }
}