
public class AVLTree extends BinarySearchTree {
	
	public AVLTree() {
		root = null;
	}
	
	public Node LL_rotate(Node parent) {
		Node child = parent.getLeft();
		parent.setLeft(child.getRight());
		child.setRight(parent);
		return child;
	}
	
	public Node RR_rotate(Node parent) {
		Node child = parent.getRight();
		parent.setRight(child.getLeft());
		child.setLeft(parent);
		return child;
	}
	
	public Node LR_rotate(Node parent) {
		Node child = parent.getLeft();
		parent.setLeft(RR_rotate(child));
		return LL_rotate(parent);
	}
	
	public Node RL_rotate(Node parent) {
		Node child = parent.getRight();
		parent.setRight(LL_rotate(child));
		return RR_rotate(parent);
	}
	
	private int getHeight(Node p) {
		int height = 0;
		if(p != null)
			height = Math.max(getHeight(p.getLeft()), getHeight(p.getRight())) + 1;
		return height;
	}
	
	private int getBF(Node p) {
		if(p == null)
			return 0;
		return getHeight(p.getLeft()) - getHeight(p.getRight());
	}
	
	private Node rebalance(Node p) {
		int BF = getBF(p);
		if(BF > 1) {
			if(getBF(p.getLeft()) > 0)
				p = LL_rotate(p);
			else
				p = LR_rotate(p);
		} else if(BF < -1) {
			if(getBF(p.getRight()) < 0)
				p = RR_rotate(p);
			else
				p = RL_rotate(p);
		}
		return p;
	}	

	protected Node insertItem(Node t, Integer e) {
		if (t == null)
			t = new Node(e);
		else if (t.getElement() > e) {
			t.setLeft(insertItem(t.getLeft(), e));
			t = rebalance(t);
		}
		else {
			t.setRight(insertItem(t.getRight(), e));
			t = rebalance(t);
		}
		return t;
	}
}