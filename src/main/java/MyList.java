public interface MyList<T> {
    void add(T value);
    void addByIndex(T value, int index);
    Object get(int index);


    void set(T value, int index);
    int indexOf(T value);
    void clear();


    Object remove(int index); /*This method removes the element at the specified index and return it. The subsequent elements are shifted to the left by one place. This method throws IndexOutOfBoundsException is the specified index is out of range. If the List implementations doesn’t support this operation, UnsupportedOperationException is thrown.*/
    boolean remove(T value);/*boolean remove(Object o): This method removes the first occurrence of the specified object. If the list doesn’t contain the given element, it remains unchanged. This method returns true if an element is removed from the list, otherwise false. If the object is null and list doesn’t support null elements, NullPointerException is thrown. UnsupportedOperationException is thrown if the list implementation doesn’t support this method.*/
}
