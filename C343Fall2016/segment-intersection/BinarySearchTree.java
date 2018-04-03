import java.util.*;
import java.util.function.BiPredicate;

public class BinarySearchTree<Key> implements SearchTree<Key> {
  private BiPredicate<Key,Key> bipred;
  public NodeClass<Key> root;
  public BinarySearchTree(BiPredicate<Key,Key> b){
    this.bipred = b;
    this.root = null;
  }
  
  public Node<Key> insert(Key k){
    NodeClass<Key> newNode = new NodeClass<Key>(k); 
    if(root==null){
      root = newNode;
      return newNode; 
    }
    NodeClass<Key> curr = root;
    NodeClass<Key> parent = null;
    while(true){ 
      parent = curr;
      if(bipred.test(k, curr.getKey())){
        curr = curr.before();
        if(curr ==null){
          newNode = parent.before();
          newNode.parent = parent;
          return newNode;
        }
      }
      else{
        curr = curr.after();
        if(curr==null){
          newNode = parent.after();
          newNode.parent = parent;
          return newNode;
        }
      }
    }
  }
  
  public Node<Key> search(Key k){ 
    NodeClass<Key> newNode = new NodeClass<Key>(k);
    if(root==null){
      return null; 
    }
    
    NodeClass<Key> curr = root;
    while(true){
      
      if(k == curr.k){
        return curr;
      }
      else if (bipred.test(k, curr.k)){
        if(curr.left == null){
          return null;
        }
        curr = curr.left;
      }
      
      else if(bipred.test(curr.k, k)){
        if (curr.right == null){
          return null;
        }
        curr = curr.right;
        
      }
    }
  }
  
  public void delete(Key k){
    NodeClass<Key> curr = root;
    while(true){
      if(curr == null){
        break;
      }
      else if (bipred.test(k, curr.k)){
        if(curr.left == null){
          break;
        }
        else{
          curr = curr.left; 
        }
      }
      else if (bipred.test(k, curr.k)){
        if(curr.right == null){
          break;
        }
        else{
          curr = curr.right; 
        }
      }
      else{
        if(curr.right == null && curr.left == null){
          if(curr == curr.parent.right){
            curr.parent.right = null;
          }
          if(curr == curr.parent.left){
            curr.parent.left = null;
          }
        }
        else if(curr.right == null || curr.left == null){
          if(curr.right == null){
            if(curr == curr.parent.right){
              curr.parent.right = curr.left;
            }
            if(curr == curr.parent.left){
              curr.parent.left = curr.left;
            }
          }
          else if(curr.left == null){
            if(curr == curr.parent.right){
              curr.parent.right = curr.right;
            }
            if(curr == curr.parent.left){
              curr.parent.left = curr.right;
            }
          }
        }
        
        else{
          curr.k = curr.after().k;
          curr = curr.right;
        }
      }
    }
  }
}