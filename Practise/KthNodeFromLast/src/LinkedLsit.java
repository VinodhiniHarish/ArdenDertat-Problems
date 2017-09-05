class Node{
	int d;
	Node next;
	
	Node(int x){
		d = x;
		next = null;
	}
}

public class LinkedLsit {

	protected Node head;
	protected Node tail;
	
	public LinkedLsit(){
		head = null;
		tail = null;
	}
	
	public void insert(int x) {
		Node n = new Node(x);
		if(head == null && tail == null) {
			head = tail = n;
		}else {
			tail.next = n;
			tail = n;
		}
		
	}
	
	public void findKthNodeFromLast(int k) {
		Node ptr1 = head;
		Node ptr2 = head;
		
		while(k!=0 && ptr2!=null) {
			ptr2 = ptr2.next; 
			k--;
		}
		
		while(ptr2!=null) {
			ptr1 = ptr1.next;
			ptr2 = ptr2.next;
		}
		
		System.out.println(ptr1.d);
		
	}
	
	
	public void printLn() {
		Node n = head;
		while(n!=null) {
			System.out.print(n.d + "->");
			n = n.next;
		}
		System.out.print("NIL");
		System.out.println("\n");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedLsit l = new LinkedLsit();
		int[] a = {1, 2, 3, 4, 5, 6, 7};
		
		for(int i=0;i<a.length;i++) {
			l.insert(a[i]);
		}
		l.printLn();
		System.out.println("Kth element from the last: ");
		l.findKthNodeFromLast(3);
	}

}
