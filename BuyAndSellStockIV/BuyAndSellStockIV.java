package BuyAndSellStockIV;

import java.util.Arrays;

public class BuyAndSellStockIV  {
	public static void main(String[] args) {
		
		int [] prices={2, 6, 5 ,2};
		int n = prices.length;

		int k=0;

		int [][] dp = new int [n][k*2];
		Arrays.fill(dp[0], Integer.MIN_VALUE);
		dp[0][0]=-prices[0];
		int buy = -prices[0];
		int sell = Integer.MIN_VALUE;
		for(int i=1;i<n;i++){
			for(int j=0;j<2*k;j++){
				if(j==0)
						dp[i][j]=Math.max(dp[i-1][j],-prices[i]);
				else{
					if(j%2==0){
						dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]-prices[i]);
					}else{
						dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]+prices[i]);
					}
				}
			}
		}
		System.out.println(dp[n-1][2*k-1]);
	}
}