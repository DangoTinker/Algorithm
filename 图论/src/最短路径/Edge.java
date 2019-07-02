package ×î¶ÌÂ·¾¶;



public class Edge implements Comparable<Edge>{
	private int a;
	private int b;
	private int weight;
	
	public Edge(int a,int b,int w) {
		this.a=a;
		this.b=b;
		weight=w;
	}
	
	public int from() {
		return a;
	}
	public int to() {
		return b;
	}
	public int getWeight() {
		return weight;
	}
	public int compareTo(Edge x) {
		if(weight>x.getWeight())
			return 1;
		else if(weight<x.getWeight())
			return -1;
		else 
			return 0;
		
		
	}
}
