
public class Node {
	private Integer element; // element of node
	private Node left; // root of left subtree
	private Node right; // root of right subtree
	
	public Node(Integer element){
		this.element = element;
		left = right = null;
	}
	
	public Integer getElement(){
		return element;
	}
	public Node getLeft(){
		return left;
	}
	public Node getRight(){
		return right;
	}
	
	public void setElement(Integer element){
		this.element = element;
	}
	public void setLeft(Node left){
		this.left = left;
	}
	public void setRight(Node right){
		this.right = right;
	}
}