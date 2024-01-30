public class DetectCycleInLinkedList{

	public static void main(String[] args) {
		
	}
	public static boolean detectCycle(Node head) {

        if(head==null || head.next==null)
            return false;
        Node slow=head.next;
        Node fast = head.next.next;


        while(fast!=null && head!=null){
            if(fast.next==null || fast.next.next==null)
                return false;
            if(slow==fast)
                return true;
            slow=slow.next;
            fast=fast.next.next;
        }
        return false;
    }
}
