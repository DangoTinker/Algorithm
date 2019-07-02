package ¶ş²æ²éÕÒÊ÷;

public class Main {
	public static void main(String[] args) {
		BinarySearchTree testTree=new BinarySearchTree(null);
		
		testTree.add(2,2002);
		testTree.add(1,1001);
		testTree.add(5,5005);
		testTree.add(8,8008);
		testTree.add(4,4004);
		testTree.add(7,7007);
		testTree.add(9,9009);
		testTree.deleteNode(5);
		testTree.traversal();

	}
	 
}
