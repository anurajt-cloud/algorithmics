package assessedExercise2;

public class Node {
	protected int key;
	protected Node prev;
	protected Node next;
	
	public Node(int val) {
		this.key = val;
		this.next = null;
		this.prev = null;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public void setPrev(Node prev) {
		this.prev = prev;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public int getKey() {
		return key;
	}

	public Node getPrev() {
		return prev;
	}

	public Node getNext() {
		return next;
	}
	
	
}
