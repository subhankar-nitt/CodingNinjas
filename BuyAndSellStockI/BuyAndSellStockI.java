package BuyAndSellStockI;

import java.util.*;

public class BuyAndSellStockI{

	public static void main(String[] args) {
		ArrayList<Integer> prices= new ArrayList<Integer>(){
			{
			add(2);
			add(100);
			add(150);
			add(120);
			}
		};
		int n = prices.size();

		int max= 0;

		int first= prices.get(0);

		for(int i=1;i<n;i++){
			max=Math.max(max,prices.get(i)-first);
			first=Math.min(first,prices.get(i));
		}

		System.out.println(max); 
	}
}
