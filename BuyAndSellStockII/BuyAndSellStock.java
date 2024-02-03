package BuyAndSellStock;


import java.util.*;
public class BuyAndSellStock{
	public static void main(String[] args) {
		long [] prices = {};
		System.out.println(solve(prices,prices.length));		
	}
	public static long solve(long [] prices,int n){
		// int n = prices.length;
		if(n<=1)
				return 0;
		long maxProfit =0;
		long smallestBuy = prices[0];
		long currBuy = prices[0];

		for(int i=1;i<n;i++){

				if(prices[i]-currBuy>0){
					maxProfit+= prices[i]-currBuy;
					maxProfit= Math.max(maxProfit,prices[i]-smallestBuy);
					currBuy=prices[i];
				}else{
					currBuy=prices[i];
					smallestBuy=Math.min(smallestBuy,currBuy);
				}
		}
		return maxProfit;
	}
}