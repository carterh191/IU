// Lab 4
// 
// Ex. 5.22, modify BinarySearchTree to find the Kth smallest
// value in O(log n) time. (The K's start at 0.)
// Hint: each BSTNode should record the size of its left subtree.

import java.util.Stack;
import java.util.HashSet;

class BSTNode {
  int key;
  int lcount;
  BSTNode left;
  BSTNode right;
  
  BSTNode(int k, BSTNode l, BSTNode r,int lc) {
    key = k;
    left = l;
    right = r;
    lcount = lc;
  }
}


public class BinarySearchTree {
  BSTNode root;
  BinarySearchTree() {
    root = null;
  }
  boolean find(int k) {
    return find_helper(root, k) != null;
  }
  void insert(int key) {
    root = insert_helper(root, key);
  }
  void remove(int key) {
    root = remove_helper(root, key);
  }
  int kth_smallest(int k) throws java.lang.Exception {
    /* replace the following with your code */
   return kth_smallest_helper(k, root);
  }
  int kth_smallest_helper(int k, BSTNode n){
    if (k == n.lcount) {
      return n.key;
    }
    else{
      if (k < n.lcount) {
        return kth_smallest_helper(k, n.left);
      }
    else{
      if (k > n.lcount) {
        return kth_smallest_helper(k - (n.lcount + 1), n.right);
      }
    }
  }
    
    throw new java.lang.UnsupportedOperationException();
  }
  public void print_tree() { System.out.print(tree_to_string(root)); }
  
  private String tree_to_string(BSTNode n) {
    if (n != null) {
      return String.format("(%s %d %s)",
          tree_to_string(n.left),
          n.key,
          tree_to_string(n.right));
    }
    return "";
  }
  
  // Helper Functions
  
  private BSTNode find_helper(BSTNode n, int key) {
    if (n == null) {
      return null;
    } else if (key < n.key) {
      return find_helper(n.left, key);
    } else if (key > n.key) {
      return find_helper(n.right, key);
    } else {
      return n;
    }
  }
  private BSTNode insert_helper(BSTNode n, int key) {
    if (find(key)){
      return n;
    }
    if (n == null) {
      return new BSTNode(key, null, null, 0);
    } else if (key < n.key) {
      n.lcount ++;
      n.left = insert_helper(n.left, key);
      return n;
    } else if (key > n.key) {
      n.right = insert_helper(n.right, key);
      return n;
    } else { // no need to insert, already there
      return n;
    }
  }
  private BSTNode delete_min(BSTNode n) {
    if (n.left == null) {
      return n.right;
    } else {
      n.left = delete_min(n.left);
      return n;
    }
  }
  private BSTNode get_min(BSTNode n) {
    if (n.left == null) {
      return n;
    }
    else {
      return get_min(n.left);
    }
  }
  private BSTNode remove_helper(BSTNode n, int key) {
    if (n == null) {
      return null;
    } else if (key < n.key) { // remove in left subtree
      n.lcount --;
      n.left = remove_helper(n.left, key);
      return n;
    } else if (key > n.key) { // remove in right subtree
      n.right = remove_helper(n.right, key);
      return n;
    } else { // remove this node
      if (n.left == null) {
        return n.right;
      } else if (n.right == null) {
        return n.left;
      } else { // two children, replace this with min of right subtree
        BSTNode min = get_min(n.right);
        n.key = min.key;
        n.right = delete_min(n.right);
        return n;
      }
    }
  }

  public static void main(String[] args) {
    BinarySearchTree T = new BinarySearchTree();
    HashSet<Integer> H = new HashSet<Integer>();
    int[] A = { 5, 2, 4, 1, 5, 9, 8 };
    int[] A_sorted = { 1, 2, 4, 5, 8, 9 };
    
    // Test insert and find
    for (int i = 0; i != A.length; ++i) {
      T.insert(A[i]);
      H.add(A[i]);
    }
    for (Integer k : H) {
      assert T.find(k) == true;
    }
    for (int k : A_sorted) {
      assert T.find(k) == true;
    }
    
    // Test remove
    for (int i = 0; i != A.length; ++i) {
      T.remove(A[i]);
      assert T.find(A[i]) == false;
    }
    
    // Test kth_smallest
    try {
      for (int i = 0; i != A_sorted.length; ++i) {
        int small = T.kth_smallest(i);
        assert small == A_sorted[i];
      }
    } catch (java.lang.Exception e) {
       System.out.println(e.toString());
    }

    System.out.println("tests passed!");
  }

}
