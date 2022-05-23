
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree t = new BinarySearchTree();
		t.insert(10);		
		t.insert(20);
		t.insert(14);
		t.insert(30);
		t.insert(5);
		t.insert(8);
		t.insert(13);
		t.insert(17);
		t.display();
		
		System.out.println("delete 20 (degree 0)");
		t.delete(13);
		t.display();
		System.out.println("delete 20 (degree 1)");
		t.delete(5);
		t.display();
		System.out.println("delete 10 (degree 2)");
		t.delete(10);
		t.display();
	}

}
