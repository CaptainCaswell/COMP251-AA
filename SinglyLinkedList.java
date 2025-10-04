class SinglyLinkedList<T> implements ADTList<T> {
	// Node class
	public static class Node<T> {
		private T item;
		private Node<T> next;
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

	public void add( T value ) {
		// New node setup
		Node<T> newNode = new Node<T>(); // Create new node
		newNode.item = value; // Assign node with value passed to constructor
		newNode.next = null;

		// Case 1: Empty list (new head and tail)
		if( size == 0 ) {
			head = tail = newNode; // Point head and tail at new node
		}

		// Case 2: Non-empty list (add after tail)
		else {		
			tail.next = newNode; // Point the old tail to the new node
			tail = newNode; // Update tail to new node
		}

		size++;
	}

	public void add( int index, T value ) {
		// Check if index valid. Must be between 0 and size, inclusive
		if ( index < 0 || index > size ) {
			System.out.println( "Error: Index out of bounds" );
			return;
		}

		// Case 1: Index is last index
		if ( index == size ) {
			add(value); // Reuse add to end method
			return;
		}

		// Create temp node
		Node<T> newNode = new Node<T>(); // New node to be added
		newNode.item = value; // Assign new node the value passed to method

		// Case 2: Index 0 on non-empty list
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
		size++;
	}

	public T remove( int index ) { 
		if ( !validate(index) ) return null;

		// Case 1: Index 0
		if ( index == 0 ) {

			T copy = head.item; // Store value to be removed;
			
			if (size == 1) {
				clear();
			} else {
				head = head.next; // Change head to the next node
				size--;
			}
			
			return copy; // Return removed value
		}

		Node<T> tempNode = head;
		for ( int i = 0; i < index - 1; i++ ) {
			tempNode = tempNode.next; // Traverse until tempNode is the node before index
		}

		// Case 2: Index at end of list
		if ( tempNode.next == tail ) {
			T copy = tail.item; // Copy the tail data being removed
			tempNode.next = null;
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
			if ( tempNode.item.equals( value ) ) return remove( i );
			tempNode = tempNode.next; 
		}

		// If no matches found
		return null;
	}

	public void set( int index, T value ) {
		if ( !validate( index ) ) return;

		Node<T> tempNode = head;
		for (int i = 0; i < index; i++) {
			tempNode = tempNode.next; // Traverse until tempNode is the node at index
		}

		tempNode.item = value; // Writes value to node
	}

	public void clear() {
		head = null;
		tail = null;
		size = 0;
	}

	public int indexOf( T value ) {
		
		Node<T> tempNode = head;
		for ( int i = 0; i < size; i++ ) {
			if ( tempNode.item.equals( value ) ) return i;
			tempNode = tempNode.next; // Traverse until tempNode is the node before index
		}

		return -1;
	}
	public T get( int index ) { 
		if ( !validate( index ) ) return null;

		Node<T> tempNode = head;
		for ( int i = 0; i < index; i++ ) {
			tempNode = tempNode.next; // Traverse until tempNode is the node before index
		}

		return tempNode.item;
	}

	public int size() { return size; }

	public boolean contains(T value) {
		// Iterate through all nodes
		Node<T> tempNode = head;
		for ( int i = 0; i < size; i++ ) {
			if (tempNode.item.equals( value ) ) return true;
			tempNode = tempNode.next; 
		}

		// If no matches found
		return false;
	}
	public ADTList<T> subList(int fromIndex, int toIndex) {
		// Validate indexes
		if ( fromIndex < 0 || fromIndex > toIndex || toIndex > size -1 ) {
				System.out.println( "Error: Index out of bounds" );
				return null;
		}
		
		SinglyLinkedList<T> output = new SinglyLinkedList<>();
		Node<T> tempNode = head;
		int i = 0;

		// Traverse to just before sublist
		while ( i < fromIndex ) {
			tempNode = tempNode.next;
			i++;
		}

		// Iterate through list, adding to new list
		while ( i <= toIndex ) {
			output.add( tempNode.item );
			tempNode = tempNode.next;
			i++;
		}
		
		return output;
	}

	public String toString() {
		if ( size == 0) return "Empty list";
		
		String output = "Values: { ";

		Node<T> tempNode = head;
		for ( int i = 0; i < size - 1; i++ ) {
			output += tempNode.item + ", "; // Add value to output
			tempNode = tempNode.next; // Move to next node
		}

		output += tempNode.item + " }";
		output += "\nSize: " + size;

		return output;
	}

	// Private methods
	private boolean validate(int index) { // Method to check if index is valid
		if ( index < 0 || index > size - 1 ) {
			System.out.println( "Error: Index out of bounds" );
			return false;
		} else {
			return true;
		}
	}
}