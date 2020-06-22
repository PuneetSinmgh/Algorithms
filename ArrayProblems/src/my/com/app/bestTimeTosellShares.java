package my.com.app;

public class bestTimeTosellShares {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	class Solution {
	    public int maxProfit(int[] prices) {
	 
	        if(prices.length == 0)
	            return 0;
	        
	        int profit =0, max_profit = Integer.MIN_VALUE;
	        
	        for(int i=0;i<prices.length-1; i++){
	            for(int j=i+1; j<prices.length ;j++){
	                if(prices[j] > prices[i]){
	                    profit  = prices[j] - prices[i];
	                    
	                    if(profit > max_profit)
	                        max_profit = profit;
	                    
	                }
	            }
	        }
	        
	        return (max_profit== Integer.MIN_VALUE)?0:max_profit ;
	    }
	}
}
