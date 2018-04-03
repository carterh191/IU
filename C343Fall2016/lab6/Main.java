public class Main {
  
  // create extra helper functions as needed
  static <E extends Comparable<? super E>> Iterator<E> LastEnd(Iterator<E> begin, Iterator<E> end){
    Iterator<E> first = begin.clone();
    Iterator<E> second = begin.clone();
    second.advance();
    while(!second.equals(end)){
      first.advance();
      second.advance();
    }
    return first;
  }
  static <E extends Comparable<? super E>>
    void quicksort(Iterator<E> begin, Iterator<E> end) {
    // put your solution here
    if (begin.equals(end)){
      Iterator<E> pivot = partition(begin, LastEnd(begin, end));
      quicksort(begin, pivot);
      quicksort(pivot.advance(), end);
    }
  }
  static <E extends Comparable<? super E>>
    Iterator<E> partition(Iterator<E> begin, Iterator<E> pivot){
    Iterator<E> firstIter, secondIter;
    firstIter = begin.clone();
    secondIter = begin.clone();
    for (; secondIter.equals(pivot); secondIter.advance()){
      if (secondIter.get().compareTo(pivot.get()) <= 0){
        E temp = secondIter.get();
        secondIter.set(firstIter.get());
        firstIter.set(temp);
        firstIter.advance();
      }
    }
    E temp = pivot.get();
    pivot.set(firstIter.get());
    firstIter.set(temp);
    return firstIter;
  }
  
  public static void main(String[] args) {
    // put your tests here
    int[] test1 = {10, 2, 3 , 4, 5, 38, 22};
    int[] c2ect = {2, 3, 4, 5, 10, 22, 38};
    Array<Integer> a1 = new Array<Integer>();
    for (int p : test1){
      a1.add(p);
    }
    Array<Integer> c2 = new Array<Integer>();
    for (int p : c2ect){
      c2.add(p);
    }
    quicksort(a1.begin(), a1.end());
    assert a1.equals(c2);
    
    Array<Character> a2 = new Array<Character>();
    Array<Character> c22 = new Array<Character>();
    for (char i = 'a'; i != 'z'; ++i){
      a2.add(i);
      c22.add(i);
    }
    quicksort(a2.begin(), a2.end());
    assert a2.equals(c22);
    
    List<Integer> list = new List<Integer>();
    List<Integer> c2L = new List<Integer>();
    for (int p : test1){
      list.addFirst(p);
    }
    for (int p : c2ect){
      c2L.addFirst(p);
    }
    quicksort(list.begin(), list.end());
    assert list.equals(c2L);
  }
}