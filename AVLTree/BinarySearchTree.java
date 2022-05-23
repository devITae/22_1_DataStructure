import java.util.Stack;

public class BinarySearchTree {

	protected Node root;

	// generator
	public BinarySearchTree() {
		root = null;
	}

	// search
	public Node search(Integer e) {
		return searchItem(root, e);
	}

	private Node searchItem(Node t, Integer e) {
		if (t == null)
			return null;
		else if (t.getElement() < e)
			return searchItem(t.getRight(), e);
		else if (t.getElement() > e)
			return searchItem(t.getLeft(), e);
		else
			return t;
	}

	// insert
	public void insert(Integer e) {
		root = insertItem(root, e);
	}

	protected Node insertItem(Node t, Integer e) {
		if (t == null) // insert after a leaf (or into an empty tree)
			t = new Node(e);
		else if (t.getElement() > e)
			t.setLeft(insertItem(t.getLeft(), e)); // branch left
		else
			t.setRight(insertItem(t.getRight(), e)); // branch right
		return t;
	}

	// remove
	public void delete(Integer e) {
		root = findAndDelete(root, e);
	}

	private Node findAndDelete(Node t, Integer e) {
		if (t == null)
			return null; // item not found!
		else {
			if (t.getElement() == e)
				t = deleteNode(t); // item found at t
			else if (t.getElement() > e)
				t.setLeft(findAndDelete(t.getLeft(), e));
			else
				t.setRight(findAndDelete(t.getRight(), e));
			return t;
		}
	}

	private Node deleteNode(Node t) {
		if (t.getLeft() == null && t.getRight() == null)
			return null; // case 1 (no child)
		else if (t.getLeft() == null)
			return t.getRight(); // case 2 (only right child)
		else if (t.getRight() == null)
			return t.getLeft(); // case 2 (only left child)
		else { // case 3 (two children)
			returnPair rPair = deleteMinItem(t.getRight());
			t.setElement(rPair.minItem);
			t.setRight(rPair.node);
			return t; // t survived
		}
	}

	private returnPair deleteMinItem(Node t) {
		if (t.getLeft() == null) { // found minimum at t
			return new returnPair(t.getElement(), t.getRight());
		} else { // branch left, then backtrack
			returnPair rPair = deleteMinItem(t.getLeft());
			t.setLeft(rPair.node);
			rPair.node = t;
			return rPair;
		}
	}

	private class returnPair {
		Integer minItem;
		Node node;

		private returnPair(Integer e, Node t) {
			minItem = e;
			node = t;
		}
	}
	
	public void display() {
		Stack<Node> globalStack = new Stack<Node>();
		globalStack.push(root);
		int blank = 32;
		boolean isRowEmpty = false;
		
		while(!isRowEmpty) {
			Stack<Node> localStack = new Stack<Node>();
			isRowEmpty = true;
			
			for(int i=0; i<blank; i++) {
				System.out.print(' ');
			}
			
			while(!globalStack.isEmpty()) {
				Node temp = globalStack.pop();
				if(temp != null) {
					System.out.print(temp.getElement());
					localStack.push(temp.getLeft());
					localStack.push(temp.getRight());
					if(temp.getLeft() != null || temp.getRight() != null)
						isRowEmpty = false;
				} else {
					System.out.print("**");
					localStack.push(null);
					localStack.push(null);
				}
				
				for(int i=0; i<blank*2-2; i++) {
					System.out.print(' ');
				}
			}
			System.out.println();
			blank /= 2;
			
			while(!localStack.isEmpty())
				globalStack.push(localStack.pop());
		}
		System.out.println();
	}
}
