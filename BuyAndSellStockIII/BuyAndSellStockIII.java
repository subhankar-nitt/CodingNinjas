package BuyAndSellStockIII;

public class BuyAndSellStockIII  {
	static int dp[][][];
	public static void main(String[] args) {
		
		int [] prices = {3,3,5,0,0,3,1,4};
		int n = prices.length;
		// dp=new int[n][3][2];
		// for(int i=0;i<n;i++){
		// 	for(int j=0;j<=2;j++){
		// 		for(int k=0;k<=1;k++){
		// 			dp[i][j][k]=-1;
		// 		}
		// 	}
		// }
	}
	public static int solve(int [] prices ,int buy,int index,int cap,int n){

		if(index==n || cap==0)
			return 0;
		if(dp[index][cap][buy]!=-1)
			return dp[index][cap][buy];
			if(buy==1){
				return dp[index][cap][buy]=Math.max(-prices[index]+solve(prices, 0, index+1, cap, n),solve(prices, 1, index+1, cap, n));
			}else{
				return dp[index][cap][buy]=Math.max(prices[index]+solve(prices, 1, index+1, cap-1, n),solve(prices, 0, index+1, cap, n));
			}

	}
}