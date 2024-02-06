package CelebrityProblem;

import java.util.Arrays;
import java.util.Stack;

public class CelebrityProblem {
    public static void main(String[] args) {
        int n = 3;
        int [][] graph = {{0 ,1 ,0},{0, 0 ,0}, {0, 1 ,0}};
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++)
            st.push(i);
        
        while(st.size()>1){
            int a = st.pop();
            int b = st.pop();
            
            if(knows(a, b, graph)){
                st.push(b);
            }else{
                st.push(a);
            }
        }
        // System.out.println(st);
        if(st.isEmpty())
            System.out.println(-1);
        for(int i=0;i<n;i++){
            if(i!=st.peek() && (!knows(i,st.peek(),graph) || knows(st.peek(),i,graph)))
              System.out.println(-1);
        }
    	System.out.println(st.peek());
    }
    public  static boolean knows(int a,int b,int [][] graph){
            if(graph[a][b]==1)
                return true;
            return false;
    }
    public static int findCelebrity(int n) {
        int [] inDegree = new int [n];
		int [][] graph = new int [n][n];
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(i!=j){
					if(knows(i,j,graph)){
						inDegree[j]=inDegree[j]+1;
						graph[i][j]=1;
					}
				}
			}
		}
		// System.out.println(Arrays.toString(inDegree));
		for(int i=0;i<n;i++){
			if(inDegree[i]==n-1 && Arrays.stream(graph[i]).boxed().mapToInt(ind->ind).sum()==0){
				return i;
			}
		}
		return -1;

    }

}
