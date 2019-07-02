package ¶þ²æ²éÕÒÊ÷;

public class BinarySearchTree {
	
	class Node{
		int key;
		int data;
		Node leftChild=null;
		Node rightChild=null;
	}
	
	private Node first=null;
	public Node getFirst() {
		return first;
	}
	public BinarySearchTree(Node a) {
		first=a;
	}
	
	public void add(int a,int b) {
		if(first==null) {
			first=new Node();
			first.data=b;
			first.key=a;
			return;
		}
		inAdd(first,a,b);
		
	}
	
	public void inAdd(Node now,int b,int a) {
		
		if(b>now.key&&now.rightChild==null) {
			
			Node temp=new Node();
			temp.data=a;
			temp.key=b;

			
			now.rightChild=temp;
			return;
		}
		
		if(b<now.key&&now.leftChild==null) {
			Node temp=new Node();
			temp.data=a;
			temp.key=b;

			
			now.leftChild=temp;
			return;
		}
		
		
		if(b<now.key) {
			inAdd(now.leftChild,b,a);
		}
		if(b>now.key) {
			inAdd(now.rightChild,b,a);
		}
		
		
	}
	
	
	public void traversal() {
		inTraversal(first);
	}
	public void inTraversal(Node a) {
		if(a==null) {
			return;
		}
		
		inTraversal(a.leftChild);
		
		System.out.println(a.data);
		inTraversal(a.rightChild);
	}
	
	public Integer get(Node a,int k) {
	
		
		if(a==null)
			return null;
		
		
		if(k<a.key) {
			return get(a.leftChild,k);
			
		}
		else if(k>a.key) {
			return get(a.rightChild,k);
			
		}
		else{
			
			return a.data;
		}
		
	}
	
	
	public void put(Node a,int k,int d) {

		if(k<a.key) {
			if(a.leftChild==null) {
				a.leftChild=new Node();
				a.leftChild.data=d;
				a.leftChild.key=k;
				return;
			}
			put(a.leftChild,k,d);
		}
		else if(k>a.key) {
			
			if(a.rightChild==null) {
				a.rightChild=new Node();
				a.rightChild.data=d;
				a.rightChild.key=k;
				return;
			}
			
			put(a.rightChild,k,d);
		}
		else {
			a.data=d;
		}
		
		
	}
	
	public void deleteNode(int k) {
		
		inDeleteNode(first,first,k);
	}
	public void inDeleteNode(Node a,Node b,int k) {
		if(a==null)
			return;
	
		if(a.key<k)
			inDeleteNode(a.rightChild,a,k);
		else if(a.key>k)
			inDeleteNode(a.leftChild,a,k);
		else {
			if(a.rightChild!=null&&a.leftChild!=null) {
				Node temp=a;
				a=a.rightChild;
				while(a.leftChild.leftChild!=null) {
					a=a.leftChild.leftChild;
				}
				
				temp.data=a.leftChild.data;
				temp.key=a.leftChild.key;
				inDeleteNode(a.leftChild,a,a.leftChild.key);	
			}
			else {

				if(a.rightChild!=null) {
					Node temp=a;
					a=a.rightChild;
					temp.data=a.data;
					temp.key=a.key;
					temp.leftChild=a.leftChild;
					temp.rightChild=a.rightChild;
				}
					
				else  if(a.leftChild!=null){
					Node temp=a;
					a=a.leftChild;
					temp.data=a.data;
					temp.key=a.key;
					temp.rightChild=a.rightChild;
					temp.leftChild=a.leftChild;
				}
				else {
					if(b.leftChild==a)
						b.leftChild=null;
					else
						b.rightChild=null;
					
				}
							
			}
			
			
			
			
		}
		
		
		
		
		/*if(a==null)
			return;
		
		if(k<a.key) {
			inDeleteNode(a.leftChild,k);
		}
		else if(k>a.key) {
			inDeleteNode(a.rightChild,k);
		}
		else {
			Node temp=a;
			if(a.leftChild==null&&a.rightChild==null) {
				
			}
			else if(a.leftChild==null) {
				a=a.rightChild;
				temp.data=a.data;
				temp.key=a.key;
				temp.leftChild=a.leftChild;
				temp.rightChild=a.rightChild;
			}
			else {
				a=a.leftChild;
				
				if(a.rightChild==null) {
					temp.data=a.data;
					temp.key=a.key;
					temp.leftChild=a.leftChild;
				}
				else {
					while(a.rightChild.rightChild!=null) {
						a=a.rightChild;
					}
					temp.data=a.rightChild.data;
					temp.key=a.rightChild.key;
					
					a.rightChild=null;
				}
			}
			
			return;
			
			
		}*/
		
	}
	
	
}
