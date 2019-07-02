package �ı��༭��;

public class HashMap<Key,Value> {
	class Node<Key,Value>{
		private Key key;
		private Value value;
		private Node next=null;
		private Node(Key a,Value b) {
			key=a;
			value=b;
		}
		private Node() {
			
		}
	}
	
	private Node<Key,Value>[] data;
	
	public HashMap() {
		data=new Node[100];
		for(int i=0;i<100;i++) {
			data[i]=new Node();
		}
	}
	
	public void put(Key a,Value b) {
		int hash=a.hashCode();
		if(hash<=0) {
			hash=-hash;
		}
		Node temp=data[hash%31];
		while(temp.next!=null) {
			if(temp.key==a)
				return;
			temp=temp.next;
		}
		if(temp.key==a)
			return;
		temp.next=new Node(a,b);
	}
	public Value get(Key a) {
		int hash=a.hashCode();
		if(hash<=0) {
			hash=-hash;
		}
		Node temp=data[hash%31];
		while(temp!=null) {
			
			if(temp.key==a) {
				return (Value)temp.value;
			}
			temp=temp.next;
		}
		return null;
	}
	
}
