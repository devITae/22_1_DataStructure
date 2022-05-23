
public class Node {
	private Integer element; // 노드의 값
	private Node left; // 왼쪽 서브 트리의 루트
	private Node right; // 오른쪽 서브 트리의 루트
	
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