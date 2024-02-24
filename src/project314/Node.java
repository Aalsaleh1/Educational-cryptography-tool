package project314;

public class Node {
	
	private char data;
	private Node next;
	
	public Node(char data) {
		this.data = data;
		this.next = null;
	}
	
	public char getData() {
		return data;
	}
	public void setData(char data) {
		this.data = data;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	
	

}
