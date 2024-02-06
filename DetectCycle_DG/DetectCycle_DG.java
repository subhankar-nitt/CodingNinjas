package DetectCycle_DG;

import java.util.*;


public class DetectCycle_DG {
     static int []visited;
     static int [] recStack;
    public static void main(String[] args) {
//         4 4
// 0 1
// 1 2
// 2 3
// 3 3
        
        int V = 4;
        int E= 4;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(Arrays.asList(1)));
        adj.add(new ArrayList<>(Arrays.asList(2)));
        adj.add(new ArrayList<>(Arrays.asList(3)));
        adj.add(new ArrayList<>(Arrays.asList(3)));

        visited=new int[V];
        recStack = new int [V];
        
        for(int i=0;i<V;i++){
            if(detectCycle(adj, i)) 
                System.out.println(true);
        }
        System.out.println(false);
    }
    public static boolean detectCycle(ArrayList<ArrayList<Integer>> adj,int src ){

        if(visited[src]==0){
            visited[src]=1;
            recStack[src]=1;
            ArrayList<Integer> neighbour = adj.get(src);
            for(int i: neighbour){
                if(recStack[i]==1){
                    return true;
                }else if(detectCycle(adj, i))
                    return true;
            }
            recStack[src]=0;
        }
        return false;
    }
}
