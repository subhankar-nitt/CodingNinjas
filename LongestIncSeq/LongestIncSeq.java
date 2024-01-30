package LongestIncSeq;

/*
 * In this dp approach we traverse from the bottom right.  
 * For each element right (j > i) we check if the ith element is 
 * Smaller than the jth one . if its smaller than its a possible 
 * Increasing subseq . so we will update the dp[i][i] for all j>i ,
 * 
 * i.e. 
 * while (j>i){
 *      dp[i][i]=Math.max(dp[i][i],dp[i][j]+1)
 * }
 * 
 * res is the max of all possible subseq
 */



public class LongestIncSeq {
    public static void main(String[] args) {
        int [] arr = {7,7,7,7,7,7,7};
        int n = arr.length;
        int res =Integer.MIN_VALUE;

        int [][] dp = new int [n][n];

        for(int i=0;i<n;i++){
            dp[i][i]=1;
        }
        for(int i=n-2;i>=0;i--){
            for(int j=n-1;j>i;j--){
                dp[i][j]= dp[i+1][j];
                if(arr[i]<arr[j]){
                    dp[i][i]=Math.max(dp[i][i], dp[i][j]+1);
                }
                res=Math.max(res, dp[i][i]);
            }
        }
        // for(int [] array: dp){
        //     System.out.println(Arrays.toString(array));
        // }

        System.out.println(res);
    }
}
