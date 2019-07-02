package ÎŞÏòÍ¼;

public class Edge implements Comparable<Edge>{
	private int a;
	private int b;
	private double weight;
	
	public Edge() {
		
	}
	public Edge(int a,int b,double weight) {
		this.a=a;
		this.b=b;
		this.weight=weight;
	}
	
	public int getA() {
		return a;
	}
	public int getB() {
		return b;
	}
	public double getWeight() {
		return weight;
	}
	public int other(int s) {
		if(s==a) return b;
		else if(s==b) return a;
		else throw new RuntimeException("error");
	}
	
	public int compareTo(Edge that) {
		if(this.weight>that.weight) return 1;
		else if(this.weight<that.weight) return -1;
		else	return 0;
	}
	
}
