public class NodeClass<Key> implements Node<Key>{
  
  Key k;
  NodeClass<Key> right;
  NodeClass<Key> left;
  NodeClass<Key> parent;
  
  public NodeClass (Key k){
    this.k = k;
    left = null;
    right = null;
    parent = null;
  }
  
  public NodeClass<Key> after(){
    NodeClass<Key> r = this.right;
    if(r == null){
      return null; 
    }
    while(r.left != null){
      r = r.left; 
    }
    return r;
  }
  
  public NodeClass<Key> before(){
    NodeClass<Key> l = this.left;
    if(l == null){
      return null; 
    }
    while(l.right != null){
      l = l.right; 
    }
    return l;
  }
  
  public Key getKey(){
    return this.k;
  }
  
}

