class SinglyLinkedList<T> implements ADTList<T> {
	// Node class
	public static class Node<T> {
		private T item;
		private Node<T> next;
		private int tail;
	}

	// Instance Variables
	private Node<T> head;
	private Node<T> tail;
	private int size;

	// Constructor
	public SinglyLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}

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
		for (int i = 0; i < index - 1; i++) {
			tempNode = tempNode.next; // Traverse until tempNode is the node before the index
		}

		newNode.next = tempNode.next; // Point newNode at the node currently at that index
		tempNode.next = newNode; // Point the node before to the index
	}

	// Set: replace given index with given value
	public void set( int index, T value ) {
		if ( validate(index) ) return;

		Node<T> tempNode = head;
		for (int i = 0; i < index; i++) {
			tempnode = tempNode.next; // Traverse until tempNode is the node at index
		}

		tempNode.item = value; // Writes value to node
	}

	public void clear() {} // Just head and tail to null?
	public int indexOf(T value) { return 0; }
	public T get(int index) { return null; }

	// Removes node at index, returns data for removed node
	public T remove(int index) { 
		if ( validate(index) ) return;



		// Case 1: Index 0
		if ( index == 0 ) {
			T copy = head.item; // Store value to be removed;
			head = head.next; // Change head to the next node
			size--;
			return copy; // Return removed value
		}

		// Case 2 + 3
		Node<T> tempNode = head;
		for ( int i = 0; i < index - 1; i++ ) {
			tempNode = tempnNode.next; // Traverse until tempNode is the node at index
		}

		// Case 2: Index at end of list
		if (tempNode.next == tail ) {
			T copy = tail.data; // Copy the tail data being removed
			tail = tempNode; // Make second to last node the new tail
			size--;
			return copy;
		}

		// Case 3: Index in middle of list
		T copy = tempNode.next.item; // Copy value to be removed
		tempNode.next = tempNode.next.next; // Connect to node after index to be removed
		size--;
		return copy;

	}

	public T remove( T value ) {

		// Iterate through all nodes
		Node<T> tempNode = head;
		for ( int i = 0; i < size; i++ ) {
			// If a node matches class of value, return and remove that index
			return remove( i, value);
		}

		// If no matches found
		return null;
	}

	public int size() { return size; }
	public boolean contains(T value) { return false; } // Copy from remove (T value)
	public ADTList<T> subList(int fromIndex, int toIndex) { return null; }

	// Private methods
	private boolean validate(int index) { // Method to check if index is valid
		if ( index < 0 || index > size - 1) {
			System.out.println("Index out of bounds");
			return false;
		} else {
			return true;
		}
	}
}