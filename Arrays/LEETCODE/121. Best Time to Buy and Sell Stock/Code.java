class Solution {
    public int maxProfit(int[] prices) {
        /*int maxprofit= 0;
        for(int i = 0; i<prices.length; i++){
           for(int j =i+1; j<prices.length; j++){
            
            maxprofit = Math.max(maxprofit, prices[j]-prices[i]);
        }
        }
        return maxprofit;*/
        int maxProfit= 0;
         int minPrice = Integer.MAX_VALUE;

        for(int i = 0; i<prices.length; i++){
          
            if(prices[i]<minPrice){
                minPrice = prices[i];
            }else{
                 maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            }
           
        
        }
        return maxProfit;
        
    }
}
