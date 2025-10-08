class ArrayBasedList<T> implements ADTList<T> {

	private T[] items;
	private int capacity;
	private int size;
	private static final int INCREMENT = 5;
	private static final int DEFAULT_CAPACITY = 10;
	
	/* Constructors */
	//Copied code from assignment example for constructing ArrayBasedList but with a default capacity of 10
	public ArrayBasedList() { //Time: O(1), Space: O(n)
		capacity = DEFAULT_CAPACITY;
		items = (T[]) new Object[capacity];
		size = 0;
	}
	
	public ArrayBasedList( int initialCapacity ) { //Time: O(1), Space: O(n)
		capacity = initialCapacity;
		items = (T[]) new Object[capacity];
		size = 0;
	}
	
	/* Modifier Methods */
	//Copied code from assignment example for "capacity()" and "resize()" to build modifier methods "void add(T element)" and void add(int index, T element)"
	
	/*Appends the specified element to the end of this list.*/
	public void add( T element ) { //Time: O(m), Space: O(n+k) 
		
		if( capacity > size ) { //C
			items[size++] = element; //C
		}
		else {
			resize(); //Time: O(m), Space: O(n+k) 
			items[size++] = element; //C
		}
	}
	
	//Time: ???, Space: ???
	/*Inserts the specified element at the specified position in this list.*/
	public void add( int index, T element ) {
		
		if(index < 0 || index > size ) {
			System.out.println("Error: "+ index + " is out of bound!!");
			return;
		}
		
		// If at capacity
		if( capacity == size ) { resize(); }

		// If adding to end
		if (index == size ) {
			add(element);
			return;
		}
		
		//shifting the elements
		for( int i = size - 1; i >= index; i-- ) {
			items[i+1] = items[i];
		}
		items[index] = element;
		size++;
	}
	
	/*Replaces the element at the specified position in this list with the specified element.*/
	public void set(int index, T element) {
		if (index < 0 || index >= size) { 
			throw new IndexOutOfBoundsException("Index: " + index + " , Size: " +size);
		// Added exception after AI help with ADTList<T> sublist, made me realize I should have exceptions elsewhere
		}
		items[index] = element;
	}
	
	/*Returns and removes the element at the specified position in this list.*/
	public T remove(int index) {
		if (index < 0 || index >= size) { 
			throw new IndexOutOfBoundsException("Index: " + index + " , Size: " +size);
		// Added exception after AI help with ADTList<T> sublist, made me realize I should have exceptions elsewhere
		}
		
		T removedelement = items[index];
		
		for (int i = index; i < size -1; i++) { //shifts elements to the left to account for the removed element in the array list
			items[i] = items[i + 1];
		}

		size--;

		// Make the last, now duplicated, index null
		items[size] = null;
		
		return removedelement;
	}
	
	/*Returns and removes the first occurrence of the specified element from this list, if it is present.*/
	public T remove(T element) {
		int index = indexOf(element);
		if (index == -1) {
			return null;
		}
		return remove(index);
	}

	
/*Accessor Methods*/
	/*Returns true if this list contains the specified element.*/
	public boolean contains(T element) {
		return indexOf(element) != -1;
	}
	
	/*Returns the element at the specified position in this list.*/
	public T get(int index) {
		return items[index];
	}
	
	/*Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element.*/
	public int indexOf(T element) {
		for (int i = 0; i < size; i++) {
			if (element == null) {
				if (items[i] == null) {
					return i;
				}
			} else if (element.equals(items[i])) {
				return i;
			}
		}
		return -1;
	}

	/*Returns a view of the portion of this list between the specified fromIndex, inclusive, and endIndex, exclusive.*/
	// Was not sure how to build the ADTList<T> subList(int fromIndex, int endIndex) method
	// Asked AI how to build it and to break down and explain the function
	public ADTList<T> subList(int fromIndex, int endIndex) {
		
		//Step 1: Parameter Validation. (starting index can't be negative || ending index can't be beyond the list || start can't be after the end)
		if (fromIndex < 0 || endIndex > size || fromIndex > endIndex) {
			throw new IndexOutOfBoundsException(
				"fromIndex: " + fromIndex + ", endIndex: " + endIndex + ", Size: " + size
			);
		}
		
		//Step 2: Calculate Sublist Size. Calculates how many elements will be in the new list. "fromIndex" is inclusive / "endIndex" is exclusive.
		int subListSize = endIndex - fromIndex + 1;
		
		//Step 3: Create New List. Creates a new ArrayBasedList object. Sets the initial capacity to "subListSize". This is currently an empty list that will be filled.
		ArrayBasedList<T> subList = new ArrayBasedList<>(subListSize);

		//Step 4: Copy Elements. Loop starts at "fromIndex"(inclusive). Loop ends before "endIndex"(exclusive). Each element from the original list is copied to the new sublist.
		for (int i = fromIndex; i <= endIndex; i++) {
			subList.add(items[i]);
		}
		
		//Step 5: Return the New List. Returns the newly created list. Return type is ADTList<T> (the interface), not ArrayBasedList<T>	
		return subList;
	}

	public String toString() {
		String output = "{ ";

		for (int i = 0; i < size; i++) {
			output += get(i) + " ";
		}

		output += "} Capacity: " + capacity;

		return output;
	}
	
	
/* Helper Methods */
	public int size() {
		return size;
	}
	
	//Time: O(m), Space: O(n + k)
	private void resize() {
		capacity += INCREMENT;// C
		T[] temp = (T[]) new Object[capacity]; //Time: C, Space: n + k
		
		//copying items into temp
		for(int i = 0; i < size; i++ ){ //2m + 1
			temp[i] = items[i];
		}
		items = temp; //C
	}
	
	public int capacity() { return capacity; } //Time: O(1), Space: O(1)
}