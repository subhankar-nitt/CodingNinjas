package DetectCycle_Undirected_Graph;

import java.util.Arrays;

public class DetectCycle_UCG {

    static int [] visited;
    static int [][] graph;
    public static void main(String[] args) {
        int n = 5;
        int m = 5;
        int [][] edges = {
           { 0 ,1},
            {1, 2},
            {1 ,4},
            {2, 3},
            {3, 4}
        };

        graph = new int[n][n];

        for(int i=0;i<m;i++){
            graph[edges[i][0]][edges[i][1]]=1;
            graph[edges[i][1]][edges[i][0]]=1;
        }

        visited = new int[n];

        for(int i=0;i<n;i++){
            if(detectCycle(i, i, n))
                System.out.println(true);
        }
        System.out.println(false);

        for(int [] array:graph){
            System.out.println(Arrays.toString(array));
        }
    }
    public static boolean detectCycle(int src,int parent,int n){

        if(visited[src]==0){
            visited[src]=1;
            int [] neighbour= graph[src];
            for(int i=0;i<n;i++){
                if(neighbour[i]==1 ){
                    if(visited[i]==1 && i!=parent)
                        return true;
                    else if(detectCycle(i, src, n))
                        return true;
                }
            }
        }
        return false;
    }
}