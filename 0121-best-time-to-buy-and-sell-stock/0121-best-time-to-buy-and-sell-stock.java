class Solution {
    public int maxProfit(int[] prices) {
        int maxProf = 0;
        int maxOnRight = prices[prices.length - 1];
        for(int i = prices.length - 2; i >= 0; i--) {
            maxOnRight = Math.max(prices[i], maxOnRight);
            int prof = maxOnRight - prices[i];
            maxProf = Math.max(prof, maxProf);
        }

        return maxProf;
    }
}