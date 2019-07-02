package µ•¥ ≤È’“ ˜;
import java.util.*;


public class TrieST<Value> {
	private static int R=256;
	private Node root=new Node();
	private Queue<String> q=new LinkedList<String>();
	private static class Node{
		private Object val=null;
		private Node[] next=new Node[R];
		public Node() {
			
		}
		
	}
	
	public Value get(String key) {
		Node temp=root;
		boolean judge=false;
		for(int i=0;i<key.length();i++) {
			if(temp.next[key.charAt(i)]==null) {
				judge=true;
				break;
			}
			else {
				temp=temp.next[key.charAt(i)];
			}
		}
		
		if(judge==false)
			return (Value)temp.val;
		else
			return null;
		
	}
	
	
	public void put(String key,Value value) {
		Node temp=root;
		
		for(int i=0;i<key.length();i++){
			Node newNode=new Node();
			if(temp.next[key.charAt(i)]==null) {
				temp.next[key.charAt(i)]=newNode;
				temp=newNode;
			}
			else {
				temp=temp.next[key.charAt(i)];
			}
				
		}
		temp.val=value;
		
	}
	
	public void traversal() {
		collect(root,"");
	}
	
	
	public Queue<String> getQueue(){
		return q;
	}
	
	public void collect(Node x,String pre) {
		if(x==null) return;
		if(x.val!=null) q.add(pre);
		
		for(int i=0;i<R;i++) {
			collect(x.next[i],pre+(char)i);
		}

	}
	
	public void search(String pat) {
		collectT(root,"",pat);
	}
	
	
	public void collectT(Node x,String pre,String pat) {
		if(x==null) return;
		if(x.val!=null&&pre.length()==pat.length()) q.add(pre);
		if(pre.length()==pat.length()) return;
		
			for(int i=0;i<R;i++) {
				if(pat.charAt(pre.length())=='.'||(char)i==pat.charAt(pre.length()))
					collectT(x.next[i],pre+(char)i,pat);
			}
				
			
			
		
		

	}
	
	
	
	public void delete(String pre) {
		Node temp=root;
		Node last=null;
		Integer count=null;
		for(int i=0;i<pre.length();i++) {
			if(i!=pre.length()-1&&temp.val!=null) {
				count=i;
				last=temp;
			}
			temp=temp.next[pre.charAt(i)];
		}
		temp.val=null;
		boolean judge=false;
		for(int i=0;i<R;i++) {
			if(temp.next[i]!=null)
				judge=true;
		}
		
		if(judge==true)
			return;
		
		if(last!=null)
			last.next[count]=null;
		else
			root.next[count]=null;
		
		
	}
	
	
}
