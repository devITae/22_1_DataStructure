
public class Main {

	public static void main(String[] args) {

		int nums[] = {50, 60, 70, 90, 80, 75, 73, 72, 78};
		AVLTree avlt = new AVLTree();
		for(int num: nums) {
			System.out.println("\ninsert " + num);
			avlt.insert(num);
			avlt.display();
		}
	}
}
