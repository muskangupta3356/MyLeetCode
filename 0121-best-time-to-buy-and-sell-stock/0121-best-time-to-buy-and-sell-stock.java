class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==1)
            return 0;
        int maxProfit=0;
        int minValue=prices[0];
        for(int i=1;i<prices.length;i++)
        {
            if(prices[i]<minValue)
            {
                minValue=prices[i];
            }
            if(maxProfit<prices[i]-minValue)
            {
                maxProfit = prices[i]-minValue;
            }
        }
        return maxProfit;
    }
}