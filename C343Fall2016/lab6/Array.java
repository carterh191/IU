class ArrayIter<E> implements Iterator<E> {
    Object[] data;
    int pos;
    ArrayIter(Object[] d, int p) { data = d; pos = p; }
    public E get() { return (E)data[pos]; }
    public void set(E e) { data[pos] = e; }
    public Iterator<E> advance() {
        ++pos;
        return this;
    }
    public boolean equals(Iterator<E> other) { 
        return pos == ((ArrayIter<E>)other).pos; 
    }
    public Iterator<E> clone() {
        return new ArrayIter<E>(data, pos);
    }
}

class Array<E> {
    Object[] data;
    int num_elements;

    Array() {
        data = new Object[10];
        num_elements = 0;
    }
    public void add(E d) {
        if (num_elements >= data.length) {
            resize(data.length * 2);
        }
        data[num_elements] = d;
        ++num_elements;
    }

    void resize(int s) {
        Object[] new_data = new Object[s];
        for (int i = 0; i != num_elements; ++i) {
            new_data[i] = data[i];
        }
        data = new_data;
    }

    public ArrayIter<E> begin() { return new ArrayIter<E>(data, 0); }
    public ArrayIter<E> end() { return new ArrayIter<E>(data, num_elements); }
} // Array