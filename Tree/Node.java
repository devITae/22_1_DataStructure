
public class Node {
	private Integer element; // ����� ��
	private Node left; // ���� ���� Ʈ���� ��Ʈ
	private Node right; // ������ ���� Ʈ���� ��Ʈ
	
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