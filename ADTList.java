interface ADTList<T> {
	
	void add( T value );
	void add( int index, T value );
	void clear();
	int indexOf(T value);
	T get(int index);
	void remove(int index);
	boolean set(int index, T value);
	int size();
	boolean contains(T value);
}