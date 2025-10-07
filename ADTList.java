package Assignment1;

interface ADTList<T> {
	// Created based on ADTList requirements from Figure 1 in Assignment 1 PDF
	// Added comments based on the descriptions from Table 1 in Assignment 1 PDF
	// Modified variable names to better align with specifications from the Assignment 1 PDF
	
	void add(T element);
	//Appends the specified element to the end of this list.
	
	void add(int index, T element);
	//Inserts the specified element at the specified position in this list.
	
	void set(int index, T element);
	//Replaces the element at the specified position in this list with the specified element.
	
	T remove(int index);
	//Returns and removes the element at the specified position in this list.
	
	T remove(T element);
	//Returns and removes the first occurrence of the specified element from this list, if it is present.
	
	boolean contains(T element);
	//Returns true if this list contains the specified element.
	
	T get(int index);
	//Returns the element at the specified position in this list.
	
	int indexOf(T element);
	//Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element.
	
	ADTList<T> subList(int fromIndex, int endIndex);
	//Returns a view of the portion of this list between the specified fromIndex, inclusive, and endIndex, exclusive.
	
}