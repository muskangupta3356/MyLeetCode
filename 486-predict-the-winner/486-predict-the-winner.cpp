class Solution {
public:

bool PredictTheWinner(vector<int>& a) {
    int n=a.size();
    vector<vector<int>> dp(n+2,vector<int>(n+2,0));
    for(int i=n-1;i>=0;i--){
        for(int j=0;j<n;j++){
            if(i>j) continue;
            if(i==j){
                dp[i][j]=a[i];
            }
            else if(abs(i-j)==1){
                dp[i][j]=max(a[i],a[j]);
            }
            else{
                int id=a[i]+min(dp[i+2][j],dp[i+1][j-1]);
                int ie=a[j]+min(dp[i+1][j-1],dp[i][j-2]);
                dp[i][j]=max(id,ie);
            }
        }
    }
    int i=dp[0][n-1];
    int s=0;
    for(int j=0;j<n;j++){
        s+=a[j];
    }
    if(i>=s/2.0) return 1;
    return 0;
}
};