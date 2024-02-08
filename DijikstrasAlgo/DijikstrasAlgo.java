package DijikstrasAlgo;

import java.util.*;
import java.util.stream.Collectors;

public class DijikstrasAlgo {
    public static void main(String[] args) {
        int vertices = 2;
        int edges = 1;
        int source =0;
        ArrayList< ArrayList < Integer > > vec= new ArrayList<>();
        
        vec.add(new ArrayList<>(Arrays.asList(0,1,9)));
        Map<Integer,ArrayList<int []>> graph=new HashMap<>();

		for(ArrayList<Integer> arr : vec){
			if(graph.containsKey(arr.get(0))){
				ArrayList<int [] > list = graph.get(arr.get(0));
				list.add(new int []{arr.get(1),arr.get(2)});
				graph.put(arr.get(0),list);
			}
			else {
				ArrayList<int []> list = new ArrayList<>();
				list.add(new int [] {arr.get(1),arr.get(2)});
                graph.put(arr.get(0), list);
				
			}
            if(graph.containsKey(arr.get(1))){
                ArrayList<int [] > list2 = graph.get(arr.get(1));
				list2.add(new int []{arr.get(0),arr.get(2)});
				graph.put(arr.get(1),list2);
            }else{
                ArrayList< int []> list2 = new ArrayList<>();
                list2.add(new int []{arr.get(0),arr.get(2)});
                graph.put(arr.get(1), list2);
            }
		}
        int [] result = new int[vertices];
        Arrays.fill(result,Integer.MAX_VALUE);
         System.out.println(dijiktras(graph, new int [vertices], new PriorityQueue<>((a,b)->a.val-b.val), source, vertices, result));   
    }
    public static ArrayList<Integer> dijiktras(Map<Integer,ArrayList<int []>> graph,int [] sptSet,PriorityQueue<value> queue ,int src,int vertices,int [] result){
        
        value v = new value(src, 0);
        queue.add(v);
           while(!queue.isEmpty()){

            value key = queue.poll();
            int index = key.index;
            int val = key.val;
            if(sptSet[index]!=1){
                sptSet[index]=1;
                result[index]=val;
                List<int []> neighbour = graph.get(index);
                if(neighbour!=null){

                    for(int [] arr: neighbour){
                        // result[index]=val+arr[1];
                        queue.add(new value(arr[0], val+arr[1]));
                    }
                }
                }

           }

           return Arrays.stream(result).boxed().mapToInt(i->i).boxed().collect(Collectors.toCollection(ArrayList::new));
    }
}
class value{
    public int index;
    public int val;
    public value(int index,int val){
        this.index=index;
        this.val=val;
    }
}


// 10 8
// 2 3 98 
// 6 5 90 
// 4 6 89 
// 1 9 67 
// 6 4 51 
// 6 2 33 
// 3 8 40 
// 6 1 35


// 2
// 5 19
// 1 4 1557
// 2 1 1341
// 4 3 491
// 0 4 1876
// 2 4 1788
// 2 3 63
// 1 2 1162
// 0 4 1744
// 2 4 1339
// 3 4 828
// 0 1 1443
// 0 2 1527
// 2 3 1957
// 3 4 1035
// 3 4 22
// 2 4 1234
// 1 4 1057
// 1 4 1342
// 1 2 955
