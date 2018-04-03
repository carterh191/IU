class DList implements Sequence {
  DNode sentinel;
  DList() {
    sentinel = new DNode(444, null, null);
    sentinel.next = sentinel;
    sentinel.prev = sentinel;
  }
  
  // insert before pos, return iterator pointing to new node
  public Iter insert(Iter pos, int e) {
    
  }
  
  // erase the node at pos, return iterator to the next element
  public Iterator erase(Iter pos) {
    assert(pos != end());
    return Iterator(erase(p.node).next);
  }
  
  //public boolean empty() { ... }
  
  public class Iter implements Iterator, BidirectionalIterator {
    DNode curr;
    Iter(DNode n) { curr = n; }
    public int get() { return curr.data; }
    public Iterator advance() {
      curr = curr.next;
      return this;
    }
    public BidirectionalIterator retreat(BidirectionalIterator begin,
                                         BidirectionalIterator end,
                                         int[] output) {
      int i = 0;
      while (! end.equals(begin)) {
        end.retreat();
        output[i] = end.get();
        ++i;
      }
    } 
    
    public boolean equals(Iterator other) { 
      return curr == ((Iter)other).curr; 
    }
  }
  
  public Iter begin() { return new Iter(sentinel.next); }
  public Iter end() { return new Iter(sentinel); }
}
