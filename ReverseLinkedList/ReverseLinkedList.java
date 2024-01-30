public class ReverseLinkedList{

	static LinkedListNode<Integer> dupHead;
	public static void main(String[] args) {
		// 2 100 -1
		LinkedListNode<Integer> head=new LinkedListNode(1);
		// head.next=new LinkedListNode(100);
		// head.next=new LinkedListNode(-1);
		// head.next.next.next=new LinkedListNode(4);
		// head.next.next.next.next=new LinkedListNode(5);
		// head.next.next.next.next.next=null;
		LinkedListNode<Integer> res= reverseLinkedList(head);
		res.next=null;
		while(dupHead!=null ){
			System.out.println(dupHead.data);
			dupHead=dupHead.next;
		}
	}
	public static LinkedListNode<Integer> reverseLinkedList(LinkedListNode<Integer> head){
		if(head.next==null)
				return head;
		LinkedListNode<Integer> val = reverseLinkedList(head.next);
		if(val.next==null){
			dupHead=val;
		}
		val.next=head;
		return head;		
	}
}

class LinkedListNode<T> 
    {
    	T data;
    	LinkedListNode<T> next;
    	public LinkedListNode(T data) 
        {
        	this.data = data;
        }
    }