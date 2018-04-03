//a simple class for binary tree (mini-assignment)
public class BinNodeJr <E extends Comparable<?super E>>{ 
	private E value;
	private BinNodeJr<E> left;
	private BinNodeJr<E> right;
	public BinNodeJr(E e) {
		value = e;
		left = right = null;
	}
	public void setLeft(BinNodeJr<E> node) {
		left = node;
	}
	public void setRight(BinNodeJr<E> node) {
		right = node;
	}

    // C343/Summer 2017 - Lab 08
	public boolean find(E q) {
		if (q.compareTo(value) == 0) return true;
		if (left != null) 
			if(left.find(q)) return true;
		if (right != null) 
			if(right.find(q)) return true;
		return false;
	}
	public static void main(String[] argv) {
		BinNode<Integer> root = new BinNode<Integer>(10);
		BinNode<Integer> node1 = new BinNode<Integer>(30);
		BinNode<Integer> node2 = new BinNode<Integer>(40);
		root.setLeft(node1);
		root.setRight(node2);
		System.out.println("40 is found in the tree: " + root.find(40));
		System.out.println("100 is found in the tree: " + root.find(100));
		BinNode<String> rootW = new BinNode<String>("fruit");
		BinNode<String> node1W = new BinNode<String>("apple");
		BinNode<String> node2W = new BinNode<String>("orange");
		rootW.setLeft(node1W);
		rootW.setRight(node2W);
		System.out.println("apple is found in the tree: " + rootW.find("apple"));
		System.out.println("banana is found in the tree: " + rootW.find("banana"));
	}
}