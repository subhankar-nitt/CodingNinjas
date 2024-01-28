import java.util.*;

public class MaximumSlidingArray{
	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(1 ,0 ,1 ,2 ,2 ,2 ,2 ,1 ,0 ,2 );
		int n = list.size();
		int k=2;

		PriorityQueue<Element> queue = new PriorityQueue<>((a,b)->b.data-a.data);
		ArrayList<Element> cache = new ArrayList<>();

		ArrayList<Integer> res = new ArrayList<>();

		for(int i=0;i<n;i++){

			Element ele = new Element(list.get(i));
			queue.offer(ele);
			cache.add(ele);

			if(i<k){
				if(i==k-1){
					res.add(queue.peek().data);
				}
				continue;
			}
			queue.remove(cache.get(i-k));
			res.add(queue.peek().data);

		}

		System.out.println(res);

	}
}

class Element{
	public int data;
	public Element(int data){
		this.data=data;
	}
}