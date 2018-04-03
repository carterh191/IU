import java.util.function.BiFunction;
import java.util.Set;
import java.util.LinkedList;

class Entry<K,V> {
    Entry(K k, V v) { key = k; value = v; }
    final K key;
    V value;
    int hash;
}

@SuppressWarnings("unchecked")
public class HashTableImp<K,V> implements HashTable<K,V> {
    // an array of linked lists to handle chaining
    private LinkedList<Entry<K,V>>[] array;
    private int itemCount;
    private BiFunction<K,Integer,Integer> h;

    private int hash(K k){
 return this.h.apply(k,this.itemCount);
    }
    
    public HashTableImp(int initialCapacity, HashMethod hm){
 // This cast violates type safety of the program but we wanted
 // you to implement hash table on top of a data structure that
 // does not do dynamic resizing (arrays instead of ArrayList)
 // so you can do the hash table growing yourself.
 // Do NOT do it in the future.
 this.array = (LinkedList<Entry<K,V>>[]) new Object[initialCapacity];
 
 this.itemCount = 0;
 switch (hm) {
 case Div:
     // division method
     h = (k,m) -> {return k.hashCode() % m;};
     break;
 case MAD:
     h = (k,m) -> {return mad(k,m);};
     break;
 }
    }

    // Implement all the following stubs

    // Multiply-Add-and-Divide (MAD) hashing method
    private int mad(K k, int m) {
 return 0;
    }

    // this method needs to be called appropriately in the put method
    private void growTable() {
    }

    @Override
    public boolean containsKey(K key){
      return get(key) != null;
    }

    @Override    
    public V get(K key){
      
      return null;
    }

    @Override    
    public V put(K key, V value){
 return null;
    }

    // not used in this client code so make sure it works correctly by
    // implementing unit tests.
    @Override    
    public boolean isEmpty(){
 return size == 0;
    }

    @Override    
    public Set<K> keySet(){
 return null;
    }

    // not used in this client code so make sure it works correctly by
    // implementing unit tests.
    @Override    
    public V remove(K key){
      return false;
}
}
