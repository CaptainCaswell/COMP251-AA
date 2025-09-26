class SinglyLinkedList<T> implements ADTList<T> {
	
	public static class Node<T> {
		private T item;
		private Node<T> next;
	}
	
	private Node<T> element = null;
	private int size = 0; 
	public void add( T value ) {
		Node<T> node = new Node<T>();
		node.item = value;
		if( element == null ) {
			node.next = null;
			size++;
			return;
		}
		
		Node<T> temp = element;
		while( temp.next != null ) {
			temp = temp.next;
		}
		temp.next = null;
		element = temp;
		size++;
	}
	public void add( int index, T value ) {}
	public void clear() {}
	public int indexOf(T value) { return 0; }
	public T get(int index) { return null; }
	public void remove(int index) {}
	public boolean set(int index, T value) { return false; }
	public int size() { return 0; }
	public boolean contains(T value) { return false; }
	public ADTList<T> subList(int fromIndex, int toIndex) { return null; }
}