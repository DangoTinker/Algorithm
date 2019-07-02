package 旅行商问题;

public class Edge implements Comparable<Edge>{
	private int a;
	private int b;
	private double weight;
	
	public Edge(int c,int d,int e) {
		a=c;
		b=d;
		weight=e;
	}
	
	public int getA() {
		return a;
	}
	public int getB() {
		return b;
	}
	public Integer getOther(int x) {
		if(x==a)
			return b;
		else if(x==b) 
			return a;
		else
			return null;
	}
	public double getWeight() {
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
