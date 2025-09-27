class SinglyLinkedList<T> implements ADTList<T> {
	// Node class
	public static class Node<T> {
		private T item;
		private Node<T> next;
		private int tail;
	}

	// Instance Variables
	private Node<T> head = null;
	private Node<T> tail = null;
	private int size = 0;

	// Add to end of list
	public void add( T value ) {
		// New node setup
		Node<T> newNode = new Node<T>(); // Create new node
		newNode.item = value; // Assign node with value passed to constructor

		// Case 1: Empty list
		if( head == null ) {
			head = tail = newNode; // Point head and tail at new node
			size++;
		} else {
		
		// Case 2: Non-empty list
			tail.next = newNode; // Point the old tail to the new node
			tail = newNode; // Update tail to new node
			size++;
		}
	}

	// Add to given index
	public void add( int index, T value ) {
		// Check if index valid. Must be between 0 and size, inclusive
		if ( index < 0 || index > size) {
			System.out.println("Index out of bounds");
			return;
		}

		// Case 1: Index is the last (reuse add(value) constructor)
		if ( index == size ) {
			add(value);
			return;
		}

		Node<T> newNode = new Node<T>(); // Create new node
		newNode.item = value; // Assign node with value passed to constructor


		// Case 2: Index 0, non-empty list
		if ( index == 0 ) {
			newNode.next = head; // Point the new node to old head
			head = newNode; // Update head to new node
			size++;
			return;
		}

		// Case 3: Index in the middle of list
		Node<T> tempNode = head; // Create a copy of head
		for (int i = 0; i < index -1; i++) {
			tempNode = tempNode.next; // Traverse until tempNode is the node before the index
		}

		newNode.next = tempNode.next; // Point newNode at the node currently at that index
		tempNode.next = newNode; // Point the node before to the index
	}
	
	public void clear() {}
	public int indexOf(T value) { return 0; }
	public T get(int index) { return null; }
	public void remove(int index) {}
	public boolean set(int index, T value) { return false; }
	public int size() { return 0; }
	public boolean contains(T value) { return false; }
	public ADTList<T> subList(int fromIndex, int toIndex) { return null; }
}