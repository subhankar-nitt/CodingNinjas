package DivideAndConqure.ConuntInversions.ConuntInversions;

import java.util.*;

public class CountInversions{

	static List<Map.Entry<Integer,Integer>> res = new ArrayList<>();
	static int count =0;
	static int N ;
	public static void main(String[] args) {
		long [] array = {52244275 ,123047899 ,493394237 ,922363607 ,378906890 ,188674257 ,222477309 ,902683641 ,860884025 ,339100162};
		int n = array.length;
		N=n;

		for(int i=0;i<n;i++){
			for(int j=i+1;j<n;j++){
				if(array[i]>array[j]){
					System.out.println(array[i]+"  "+array[j]);
				}
			}
		}

		System.out.println("+++++ manual ++++");
		generateInversePairs(array,0,n);
		// for(Map.Entry<Integer,Integer> entry: res){
		// 	System.out.println(entry.getKey()+ " "+entry.getValue());
		// }	

	
		System.out.println(count);		
	}
	public static long []  generateInversePairs(long [] array,int start,int end){
		if(start>=end){

		  if(start<0 || end>=N){
			  return new long[0];
		  }
			 return new long []{array[start]};
		   
		}
		
		
		int mid = (start+end)/2;
		long [] left = generateInversePairs(array, start, mid);
		long [] right = generateInversePairs(array, mid+1, end);

	  long [] res = new long [left.length+right.length];

	  int l=0;
	  int r=0;
	  int index=0;
	  boolean fromLeft=true;
	  while((l<left.length || r<right.length) && index < left.length+right.length){
		  if(l<left.length && r<right.length){
			  if(left[l]<right[r]){
				  res[index++]=left[l];
				  l++;
			  }else{
				  res[index++]=right[r];
				  System.out.println(left[l]+"  "+right[r]);
				  count+=left.length-l;
				  r++;
				  fromLeft=false;
			  }
		  }else if(r>=right.length && l<left.length){
			  while(l<left.length){

				  res[index++]=left[l];
				  System.out.println(left[l]+"  "+res[index-1]);
				  l++;
				  if(right.length!=0 && fromLeft){
					  count++;
				  }
			  }
			//   fromLeft=true;
		  }else if(l>=left.length && r<right.length){
			while(r<right.length)
			  res[index++]=right[r++];
		  }
	  }
	  return res;
  }
}