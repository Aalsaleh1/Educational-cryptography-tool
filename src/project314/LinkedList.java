package project314;

public class LinkedList {

	private static Node head;
	private static Node current;
	
	
	public static boolean IsNull() {  // Check if the current is in the end or not
		return current == null;
	}
	
	public static void InsertAtEnd(char data) { // note that the current will pointed head
		Node NewNode = new Node(data); 
		if(head==null) 
			head = NewNode;
		else {
				while (current.getNext() != null) 
				MoveCurrent();
				current.setNext(NewNode);
			}
		SetFirst();
		}
	
	
	public static void SetFirst() { // will set the current in the first
		current = head;
		
	}
	
	public static char retrieve() { // will give you the data at the existing current
		return current.getData();
	}
	
	public static void MoveCurrent() { // will move the current
		current = current.getNext();
	}
	
	

	
	
	
	
	
	
	
}
