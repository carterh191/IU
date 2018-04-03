// a simple BST tree (so simple we call it BSTJr) for C343

/**
 * Special thanks to Prof.Yuzhen Ye, CSCI, Indiana University Bloomington, for the original source code. 
 *
 */

public class BSTJr <K extends Comparable<?super K>> {
	BinNode<K> root;
	BinNode<K> curr;
	//for balance checking: if a node is unbalanced, the tree will be unbalanced
	BinNode<K> unbalanced = null;
	public BSTJr() {
		root = null;
		curr = null;
	}
	public void build(K[] ks) {
		for(int i = 0; i < ks.length; i ++) insert(ks[i]);
	}
	public void insert(K k) {
		BinNode<K> t = new BinNode<K>(k);
		if(root == null) {
			root = curr = t;
		}
		else {
			curr = search(root, k);
			if(k.compareTo(curr.getKey()) < 0) curr.setLeft(t);
			else curr.setRight(t);
		}
	}
	public BinNode<K> search(BinNode<K> entry, K k) {
		if(entry == null) return null;
		else { 
			entry.setSize(entry.getSize() + 1); //update the size of the subtree by one
			if(entry.isLeaf()) return entry;
			if(k.compareTo(curr.getKey()) < 0) {
				if(entry.getLeft() != null) return search(entry.getLeft(), k);
				else return entry;
			}
			else {
				if(entry.getRight() != null) return search(entry.getRight(), k);
				else return entry;
			}
		}
	}
	public void display() { 
		if(root == null) return;
		System.out.println("Preorder enumeration: key(size-of-the-subtree)");
		preorder(root); 
		System.out.println();
	}
	public void preorder(BinNode<K> entry) {
		System.out.print(entry.getKey() + "(" + entry.getSize() + ") ");
		if(entry.getLeft() != null) preorder(entry.getLeft());
		if(entry.getRight() != null) preorder(entry.getRight());
	}

    // C343/Summer 2017 - Lab 08
	public void checkBalance() {
		int h = treeHeight(root);
		System.out.println("the height of the tree " + h);
		if(unbalanced != null)
			System.out.println("the tree is unbalanced at node " + unbalanced.getKey());
		else System.out.println("the tree is balancd");
	}
    // C343/Summer 2017 - Lab 08
	public int treeHeight(BinNode<K> entry) {
		if (entry == null) return 0;
		else { 
			int hLeft = treeHeight(entry.getLeft());
			int hRight = treeHeight(entry.getRight());
			System.out.println("check key " + entry.getKey() + " left subtree height " + hLeft + " right subtree height " + hRight);
			if(Math.abs(hLeft - hRight) > 1) unbalanced = entry;
			return Math.max(hLeft, hRight) + 1;
		}	
	}
    // C343/Summer 2017 - Lab 09
	public void select(int kth) {
		BinNode<K> node = select(root, kth);
		if(node != null)
			System.out.println(kth + "th smallest value in the BST: " + node.getKey());
		else
			System.out.println("there is no " + kth + "th smallest value in the tree");
	}
    // C343/Summer 2017 - Lab 09
	public BinNode<K> select(BinNode<K> entry, int kth) {
		if(entry == null) return null;
		int leftsize = 0;
		if(entry.getLeft() != null) leftsize = entry.getLeft().getSize();	
		if(leftsize == kth - 1) {
			return entry;
		}
		else if(leftsize > kth - 1) {
			return select(entry.getLeft(), kth);
		}
		else {
			return select(entry.getRight(), kth - 1 - leftsize);
		}
	}
	public static void main(String[] argv) {
		BSTJr<Integer> tree = new BSTJr<Integer>();
		Integer[] ks = {37, 24, 42, 7, 2, 40, 120};
		tree.build(ks);
		tree.display();
		tree.checkBalance();
		for(int i = 1; i <= ks.length; i ++)
			tree.select(i);
		tree.select(100);
	}
}