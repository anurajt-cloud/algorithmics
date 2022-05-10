package assessedExercise2;

public class DoublyLinkedList {
	protected Node head;
	public int listSize;
	
	/*
	 * Constructor
	 */
	public DoublyLinkedList() {
		this.head = null;
		this.listSize = 0;
	}
	
	/*
	 * To check whether the list is empty or not.
	 * 
	 * @returns a boolean value with respect to the list being empty.
	 */
	public boolean setEmpty(){
		return head == null;
	}
	
	/*
	 *  Get the size of the list
	 *  
	 *  @returns The size of the list.
	 */
	public int setSize() {
		return this.listSize;
	}
	
	
	/*
	 *  Searches for a given value in the list and return the point if found.
	 *  
	 *  @param val - It is the value to search for in the list.
	 *  
	 *  @returns A Node which points to the value.
	 */
	public Node search(int val) {
		Node comp = head;
		while(comp != null) {
			if(comp.key == val) {
				return comp;
			}
			comp = comp.next;
		}
		return comp = null;
	}
	
	/*
	 *  Inserts the element int the set if it is not already in the set.
	 *  
	 *  @param val - The value to be added to the list.
	 */
	public void add(int val) {
		Node insNode = new Node(val);
		if(head == null) {
			head = insNode;
			listSize += 1;
			return;
		}
		Node find = this.search(val);
		if(find == null) {
			insNode.next = head;
			head = insNode;
			insNode.next.prev = insNode;
			listSize+=1;
		}
		
	}
	
	
	/*
	 * Removes an element from the list, provided it is in the list.
	 * 
	 * @param val - It is the value that needs to be removed from the list.
	 */
	public void remove(int val) {
		Node find = this.search(val);
		if(find == null) {
			System.out.println("Element is not in the list!");
		}
		else {
			if(find.prev==null) {
				head=find.next;
			}
			else {
				find.prev.next = find.next;
			}
			if(find.next != null) {
				find.next.prev = find.prev;
			}
			listSize-=1;
		}
	}
	
	/*
	 * The method is used to find the union between this set and T set.
	 * 
	 * @param T - It is the set with which we find the union.
	 * 
	 * @returns A new set which contains the union of the two sets.
	 */
	public DoublyLinkedList union(DoublyLinkedList T) {
		DoublyLinkedList newList = new DoublyLinkedList();
		Node TNode = T.head;
		Node SNode = head;
		while(SNode != null) {
			newList.add(SNode.key);
			SNode = SNode.next;
		}
		while(TNode != null) {
			newList.add(TNode.key);
			TNode = TNode.next;
		}
		return newList;
	}
	
	/*
	 * This method is used to find the intersection between two sets.
	 * 
	 * @param T - The tree with which the intersection is being taken
	 * 
	 * @returns A list of the values of intersection.
	 */
	public DoublyLinkedList intersection(DoublyLinkedList T) {
		Node SNode = head;
		DoublyLinkedList newList = new DoublyLinkedList();
		while(SNode != null) {
			if(T.search(SNode.key)!=null) {
				newList.add(SNode.key);
			}
			SNode = SNode.next;
		}
		return newList;
	}
	
	/*
	 * This method is used to find the difference of two sets.
	 * 
	 * @param T - It is the tree with which the difference is found of this tree.
	 * 
	 * @returns The new list which contains the values of the difference between the two sets.
	 */
	public DoublyLinkedList difference(DoublyLinkedList T) {
		Node SNode = head;
		DoublyLinkedList newList = new DoublyLinkedList();
		while(SNode != null) {
			if(T.search(SNode.key) == null) {
				newList.add(SNode.key);
			}
			SNode = SNode.next;
		}
		return newList;
	}
	
	/*
	 * The method is used to check whether a given list is a subset of another one.
	 * 
	 * @param T - is to the list which is checked to have a subset.
	 * 
	 * @returns A boolean value whether this tree is a subset or not.
	 */
	public boolean subset(DoublyLinkedList T) {
		Node SNode = head;
		int counter = 0;
		while(SNode != null){
			if(T.search(SNode.key)!= null) {
				counter++;
			}
			SNode = SNode.next;
		}
		return counter==listSize;
	}
	
	/*
	 * This method is used to print the doubly linked list in an orderly fashion.
	 * 
	 * @returns A string representation of a doubly linked list.
	 */
	@Override
	public String toString() {
		String list = "{";
		Node start = head;
		while(start != null) {
			list += start.key+" ";
			start = start.next;
		}
		list += "}";
		return list;
	}
	
	
	public static void main(String[] arg) {
		try {
		DoublyLinkedList list = new DoublyLinkedList();
		list.add(3);  
		list.add(45);
		DoublyLinkedList blist = new DoublyLinkedList();
		blist.add(12);
		blist.add(45);
		blist.add(3333);
		blist.add(3);
		System.out.println(blist.toString());
		System.out.println(list.subset(blist));
		}
		catch(Exception ex) {
		}
	}
}
