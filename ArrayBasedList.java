class ArrayBasedList<T> implements ADTList<T> {
	
	//data members
	private T [] items;
	private int capacity;
	private int size;
	public static final int INCREMENT = 5;
	
	//constructors
	public ArrayBasedList() { //Time: O(1), Space: O(n)
		
		capacity = INCREMENT;
		items = (T[]) new Object[capacity];
		size = 0;
	}
	public ArrayBasedList( int capacity ) { //Time: O(1), Space: O(n)
		items = (T[]) new Object[capacity];
		size = 0;
	}
	
	public ArrayBasedList( T[] items ) { //Time: O(n), Space: O(n)
		this.items = (T[]) new Object[capacity];
		this.items = items;
		int size = 0;
		int capacity = 0;
		for(T item : items ) {
			if( item != null )
				size++;
			capacity++;
		}
	}
	public int capacity() { return capacity; } //Time: O(1), Space: O(1)
	public void add( T value ) { //Time: O(m), Space: O(n+k) 
		
		if( capacity > size ) { //C
			items[size++] = value; //C
		}
		else {
			resize(); //Time: O(m), Space: O(n+k) 
			items[size++] = value; //C
		}
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
	
	//Time: ???, Space: ???
	public void add( int index, T value ) {
		
		if(index < 0 || index >= size ) {
			System.out.println("Error: "+ index + " is out of bound!!");
			return;
		}
		
		if( capacity == size ) { resize(); }
		//shifting the elements
		for( int i = size - 1; i >= index; i-- ) {
			items[i+1] = items[i];
		}
		items[index] = value;
		size++;
	}
	
	public void clear() { 
		items = (T[]) new Object[capacity];
		size = 0;
	}
	public int indexOf(T value) { 
		
		int i = 0;
		for(T item : items ) {
			if( item.equals(value) )
				return i;
			i++;
		}
		return -1;
	}
	public T get(int index) { //Time complexity: O(1), Memory complexity: O(1)
		if(index < 0 || index >= size ) {
			System.out.println("Error: "+ index + " is out of bound!!");
			return null;
		}
		
		return (T) items[index];
	}
	public void remove(int index) {}
	public boolean set(int index, T value) { return false; }
	public int size() { return size; }
	public boolean contains(T value) { return false; }
	
	public String toString() {
		
		if( size == 0 ) { 
			return "[], Size: " + size + ", Capacity: " + capacity; 
		}
		String str = "[";
		for( int i = 0; i < size - 1; i++ )
			str += items[i] + ", "; 
		str += items[size - 1] + "], Size: " + size + ", Capacity: " + capacity;
		
		return str;
	}
}