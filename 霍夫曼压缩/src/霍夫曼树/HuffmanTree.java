package »ô·òÂüÊ÷;
import java.util.*;
import java.io.*;
public class HuffmanTree<Value> {
	private static int R=256;
	private Node<Value> node=null;
	private String fileName;
	public HuffmanTree(Value[] a,String fileName) {
		this.fileName=fileName;
		PriorityQueue<Node<Value>> pq=new PriorityQueue<Node<Value>>();
		int[] temp=new int[R];
//		System.out.println(a.length);
		for(int i=0;i<a.length;i++) {
			temp[(char)a[i]]=0;
		}
		for(int i=0;i<a.length;i++) {
			temp[(char)a[i]]++;
		}
//		System.out.println(temp['a']);
		for(int i=0;i<a.length;i++) {
			if(temp[(char)a[i]]!=0) {
				pq.add(new Node(a[i],temp[(char)a[i]],null,null));
				temp[(char)a[i]]=0;
			}
		}
//		System.out.println(pq.size());
		int ttt=pq.size();
//		for(int i=0;i<ttt;i++) {
//			System.out.println(i+" "+pq.poll().getCh());
//		}
//		System.out.println("----------------------");
		Node<Value> t=null;
		while(pq.size()!=1) {
			Node<Value> n1=null;
			Node<Value> n2=null;
			
			n1=pq.poll();
			n2=pq.poll();
			
//			System.out.println(n1.getCh()+" "+n2.getCh());
			
			
			t=new Node<Value>(null,n1.getWeight()+n2.getWeight(),n1,n2);
			
			pq.add(t);
		}
		
//		System.out.println(pq.size());
		node=pq.poll();
//		System.out.println(pq.isEmpty());
	}
	
	public void traversal() {
		inTraversal(node);
	}
	public void inTraversal(Node now) {
			
		inTraversal(now.getLeft());
		inTraversal(now.getRight());
		
	}
	public void writeTree() throws Exception{
		FileOutputStream out=new FileOutputStream(fileName);
	}
	public void inWriteTree(Node now,FileOutputStream out) throws Exception{
		if(now.getLeft()==null&&now.getRight()==null) {
			out.write(1);
			out.write(Byte.parseByte((int)now.getCh()));
		}
		
		
	}
	
	
	
	
}
