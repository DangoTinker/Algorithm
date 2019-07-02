package µ•¥ ≤È’“ ˜;

public class TST<Value> {
	private class Node{
		private char c;
		private Node left=null,mid=null,right=null;
		private Value value;
	}
	private Node root=null;
	
	public Value get(String key) {
		Node temp=root;
		for(int i=0;i<key.length();i++) {
			if(temp==null) {
				break;
			}
			else if(key.charAt(i)<temp.c) {
				temp=temp.left;
				i--;
			}
			else if(key.charAt(i)>temp.c) {
				temp=temp.right;
				i--;
			}
			else {
				if(i==key.length()-1) {
					return temp.value;
				}
				else {
					temp=temp.mid;
				}
			}
		}
		return null;
	}
	
	
	
	public void add(String key,Value val) {
		if(root==null) {
			root=new Node();
			root.c=key.charAt(0);
			Node temp=root;
			
			for(int i=1;i<key.length();i++) {
				
				temp.mid=new Node();
				temp.mid.c=key.charAt(i);
				
				if(i==key.length()-1) {
					temp.mid.value=val;
				}
				temp=temp.mid;
			}
			return;
		}
		Node temp=root;
		for(int i=0;i<key.length();i++) {
			if(key.charAt(i)<temp.c) {
				if(temp.left==null) {
					temp.left=new Node();
					temp.left.c=key.charAt(i);
					if(i==key.length()-1)
						temp.left.value=val;
					temp=temp.left;
				}
				else {
					temp=temp.left;
					
				}
				i--;
			}
			
			else if(key.charAt(i)>temp.c) {
				if(temp.right==null) {
					temp.right=new Node();
					temp.right.c=key.charAt(i);
					if(i==key.length()-1)
						temp.right.value=val;
					temp=temp.right;
				}
				else {
					temp=temp.right;
					
				}
				i--;
			}
			
			else {
				if(i==key.length()-1)
					temp.value=val;
				else {
					if(temp.mid==null) {
						temp.mid=new Node();
						temp.mid.c=key.charAt(i+1);
					}
					temp=temp.mid;
				}
				
			}
			
		}
		
		
	}
	
	
	
	
}
