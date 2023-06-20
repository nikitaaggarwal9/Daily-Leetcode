class Solution {
    public int maxProfit(int[] prices) {
        int maxPriceInFuture = prices[prices.length - 1], maxProfit = 0;
         
        for(int i = prices.length - 2; i >= 0; i--) {
            maxProfit = Math.max(maxProfit, maxPriceInFuture - prices[i]);
            maxPriceInFuture = Math.max(maxPriceInFuture, prices[i]);
        }
        
        return maxProfit;
    }
}