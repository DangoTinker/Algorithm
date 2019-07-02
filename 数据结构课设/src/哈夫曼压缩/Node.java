package ¹ş·òÂüÑ¹Ëõ;

public class Node implements Comparable<Node>{
	private Character val;
	private int weight;
	private Node left,right;
	
	public Node(Character a,int b,Node c,Node d) {
		val=a;
		weight=b;
		left=c;
		right=d;
	}
	
	public Node getLeft() {
		return left;
	}
	public Node getRight() {
		return right;
	}
	
	public Character getVal() {
		return val;
	}
	public int getWeight() {
		return weight;
	}
	public int compareTo(Node a) {
		if(weight>a.weight) return 1;
		else if(weight<a.weight) return -1;
		else return 0;
	}
	
}
