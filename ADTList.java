interface ADTList<T> {
	
	void add( T value );
	void add( int index, T value );
	void clear();
	int indexOf(T value);
	T get(int index);
	T remove(int index);
	T remove(T value);
	void set(int index, T value);
	int size();
	boolean contains(T value);
}