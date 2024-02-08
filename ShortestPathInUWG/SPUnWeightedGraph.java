package ShortestPathInUWG;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SPUnWeightedGraph {

    static int len ;
    static List<Integer> result;
    public static void main(String[] args) {
        int n =4;
        int m =4;
        int s=1,t=4;
        len =Integer.MAX_VALUE;
        result = new ArrayList<>();
        int [][] edges={{1, 2}, { 2, 3},{3 ,4},{ 1 ,3}};
        int [][] graph = new int [n][n];
		for(int i=0;i<m;i++){
			graph[edges[i][0]-1][edges[i][1]-1]=1;
			graph[edges[i][1]-1][edges[i][0]-1]=1;
		}
        bfs(graph, s-1, t-1, n);
    }
    public static List<Integer> solve(int [][] graph,int V,int src,int t,List<Integer> res,int [] visited){
		if(visited[src]==0){
			if(src==t){
				int l = res.size();
                if(l<len){
                    len=l;
                    List<Integer> temp = new ArrayList<>();
                    for(int ele:res)
                        temp.add(new Integer(ele)+1);
                    temp.add(t+1);
                    result=temp;
                }
				return res;
			}
			visited[src]=1;
			res.add(src);
            
			int [] neighbour = graph[src];
			for(int i=0;i<V;i++){
				if(neighbour[i]==1 && visited[i]!=1){
					solve(graph,V,i,t,res,visited);
				}
			}
            visited[src]=0;
            res.remove(res.size()-1);
		}
		return res;
	}
    public static void bfs(int [][] graph,int src,int dest,int V){
        int [] visited= new int[V];
        Queue<Value> queue = new LinkedList<>();
        queue.add(new Value(src,new ArrayList<>(Arrays.asList(src))) );
        // List<I> res=new ArrayList<>();
       List<Integer> rs =new ArrayList<>();
        while (!queue.isEmpty()) {
            Value i = queue.poll();
            if(i.val==dest){
                rs=i.trace;
                break;
            }
            if(visited[i.val]==0){

                visited[i.val]=1;
                int [] neighbour= graph[i.val];
                for(int j=0;j<V;j++){
                    if(neighbour[j]==1 && visited[j]==0 && !queue.contains(j)){
                        List<Integer> li = new ArrayList<>();
                        for(int k:i.trace){
                            li.add(new Integer(k));
                        }
                        li.add(j);
                        queue.add(new Value(j,li));
                    }
                }
            }
        }
        System.out.println(rs);
    }
}
class Value{
    public int val;
    public List<Integer> trace;
    public Value(int val,List<Integer> trace){
        this.val=val;
        this.trace=trace;
    }
}
