//import java.util.NoSuchElementException;
import java.util.ArrayList;
import java.util.Comparator;

public class HeapImp<E> implements Heap<E> {
  private ArrayList<E> data;
  private Comparator<E> compare;
  private int heapSize;
  
  HeapImp(ArrayList<E> data, Comparator<E> compare) {
    this.data = data;
    this.compare = compare;
    buildMinHeap();
  }
  
  
  public void swapTwo(ArrayList<E> A, int i, int j){
    E temp = A.get(i);
    A.set(i, A.get(j));
    A.set(j, temp);
  }
  
  public E minimum() {
    return data.get(0);
  }
  
  @Override
  public void insert(E e) {
    heapSize++;
    if(heapSize > data.size()){
      data.add(e);
    }
    else{
      data.set(heapSize - 1, e);
    }
    decreaseKey(heapSize - 1);
    System.out.println(data.toString());
  }
  
  
  public E extractMin() {
    if(heapSize == 0){
      return null;
    }
    else{
      E min = data.get(0);
      data.set(0, data.get(heapSize - 1));
      data.remove(heapSize - 1);
      System.out.println("after deletion");
      System.out.println(data.toString());
      heapSize--;
      if(heapSize > 0){
        minHeapify(0);
      }
      System.out.println("after minheapify");
      System.out.println(data.toString());
      return min;
    }
  }
  
  int parent(int i){
    return (int)Math.floor((i-1)/2);
  }
  
  private void decreaseKey(int i) {
    while(i > 0 && this.compare.compare(data.get(i), data.get(parent(i))) < 0){
      
      swapTwo(data, i, parent(i));
      i = parent(i);
    }
    return;
  }
  
  
  public void minHeapify(int i) {
    int L = 2*i + 1;
    int R = 2*i + 2;
    int smallest = i;
    if(L< heapSize && this.compare.compare(data.get(L), data.get(i))< 0){
      smallest= L;
    }
    if(R< heapSize && this.compare.compare(data.get(R), data.get(smallest))< 0) {
      smallest= R;
    }
    if(smallest != i){
      swapTwo(data, smallest, i);
      minHeapify(smallest);  
    }
  }
  
  public void buildMinHeap(){
    int lastParent = heapSize/2;
    for(int i = lastParent; i >= 0; --i){
      System.out.println("i is " + i);
      minHeapify(i);
    }
    return;
  }
  
  public String toString() {
    return data.toString();
  }
}