class Node{
	int data;
	Node next;
	
	public Node(int x) {
		data = x;
		next = null;
	}
}

public class LinkedList {
	
	protected Node head;
	protected Node tail;
	
	public LinkedList() {
		head = null;
		tail = null;
	}
	
	public Node[] find(int x) {
		Node[] nodes = new Node[2];
		nodes[0] = head;
		nodes[1] = null;
		while(nodes[0]!=null) {
			if(nodes[0].data!= x) {
				nodes[1] = nodes[0];
				nodes[0] = nodes[0].next;
			}
		}
		return nodes;
	}
	
	public void delete(int x) {
		if(head == null && tail == null) {
			System.out.println("Linked List is Empty. Cannot find the element ");
		}else {
			if(head == tail) {
				if(head.data == x) {
					head = tail = null;
					System.out.println("Element is deleted from the Linked List ");
					return;
				}else {
					System.out.println("Element Not found in the Linked list");
				}
			}else {
				Node n = head;
				Node prev = null;
				while(n!=null) {
					if(n.data != x) {
						prev = n;
						n = n.next;
					}else {
						if(prev!=null) {
							System.out.println("Deleting "+n.data + " from the Linked List");
							prev.next = n.next;
							n = n.next;
						}
					}
				}
			}
		}
		
	}
	
	public void printLn() {
		Node n = head;
		while(n!=null) {
			System.out.print(n.data + "->");
			n = n.next;
		}
		System.out.print("NIL");
		System.out.println("\n");
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList l = new LinkedList();
		l.insert(1);
		l.printLn();
		System.out.println("Deleting 5 from the LL");
		l.delete(5);
		int[] a = {5,5,5};
		for(int i=0;i<a.length;i++) {
			l.insert(a[i]);
		}
		l.printLn();
		l.delete(5);
		System.out.println("After Deletion Linked list is: ");
		l.printLn();
	}

}
