package É¢ÁÐ±í;

public class Main {
	public static void main(String[] args) {
		/*MyHashList<Integer> hashList=new MyHashList();
		hashList.add(1, 1);
		hashList.add(2, 2);
		hashList.add(3, 3);
		hashList.delete(2);
		System.out.println(hashList.search(2));*/
		HashTypeTwo<Integer> two=new HashTypeTwo();
		two.add(1, 111);
		two.add(2, 222);
		two.add(3, 333);
		two.delete(2);
		System.out.println(two.get(3));
		
	}
}
