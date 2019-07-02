package É¢ÁÐ±í;

public class HashTypeTwo<Item> {
	
	private int size=100;
	class Node<Item>{
		private Item data;
		private int key;
		public Node(int a,Item b) {
			key=a;data=b;
		}
	}
	private Node<Item>[] code=new Node[size];
	
	public HashTypeTwo() {
		for(int i=0;i<size;i++) {
			code[i]=null;
		}
	}
	
	public void add(Integer key,Item item) {
		int hashCode=key.hashCode();
		
		while(true) {
			if(code[hashCode]==null) {
				code[hashCode]=new Node(key,item);
				size++;
				return;
			}	
			else {
				hashCode++;
			}
		}
		
	}
	
	
	public Item get(Integer key) {
		int hashCode=key.hashCode();
		while(true) {
			if(code[hashCode].key==key) {
				return code[hashCode].data;
			}
			else {
				hashCode++;
			}
			
		}
		
	}
	
	
	public void delete(Integer key) {
		int hashCode=key.hashCode();
		int temp;
		while(true) {
			if(code[hashCode].key==key||hashCode>=size) {
				temp=hashCode;
				break;
			}
			else {
				hashCode++;
			}
			
		}
		code[temp]=null;
		hashCode++;
		while(hashCode<size) {
			 
			
			if(code[hashCode].key==key) {
				code[temp]=code[hashCode];
				code[hashCode]=null;
				temp++;hashCode++;
				
			}
			else {
				hashCode++;
			}
			
			
		}
		
		
	}
	
	
	
	
}
