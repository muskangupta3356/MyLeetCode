class Solution {
    public int numDecodings(String s) {
        int[] dp = new int [s.length()+1];
        dp[0]=1;
        if(s.charAt(0)!='0')
            dp[1] = 1;
        else
            dp[1] = 0;
        for(int i=2;i<dp.length; i++){
            if(s.charAt(i-1)!='0')
                dp[i]=dp[i-1];
            else
                dp[i]=0;
            
            int doubleNum = Integer.valueOf(s.substring(i-2,i));
            if(doubleNum>=10 && doubleNum <=26)
                dp[i]+=dp[i-2];
        }
        return dp[s.length()];
    }
}