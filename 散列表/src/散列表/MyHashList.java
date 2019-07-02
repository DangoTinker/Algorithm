package É¢ÁÐ±í;
import java.util.*;
public class MyHashList<Item> {
	class Node{
		private int key;
		private Item data;

		public Node() {
			
		}
		public Node(int k,Item i) {
			key=k;
			data=i;
		}
	}
	
	private LinkedList<Node>[] code=new LinkedList[10];
	
	public MyHashList() {
		for(LinkedList<Node> i:code) {
			i=null;
		}
	}
	
	public MyHashList(LinkedList<Node>[] a) {
		code=a;
	}
	
	public void add(Integer key,Item item){
		int HashCode=key.hashCode();
		String classname=null;
		
		
		
		if(code[HashCode]==null) {
			code[HashCode]=new LinkedList();
			code[HashCode].add(new Node(key,item));
		}
		else {
			code[HashCode].addLast(new Node(key,item));
		}
	}
	
	public Item search(Integer key) {
		int HashCode=key.hashCode();
		for(Node i:code[HashCode]) {
			if(i.key==key) {
				return i.data;
			}
		}
		
		return null;
		
	}
	
	public void delete(Integer key) {
		int HashCode=key.hashCode();
		if(code[HashCode].getFirst().key==key) {
			code[HashCode].removeFirst();
			return;
		}
		for(Node i:code[HashCode]) {
			if(i.key==HashCode) {
				code[HashCode].remove(i);
			}
		}
		
	}
	
	
	
	
}
