class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0){
            return 0;
        }
        int minNow = prices[0];
        int maxStockProfit = 0;
        for(int i=1; i<prices.length; i++){
            if(minNow>prices[i]){
                minNow=prices[i];
            }
            maxStockProfit = Math.max(maxStockProfit, prices[i]-minNow);
        }
        return maxStockProfit;
    }
}