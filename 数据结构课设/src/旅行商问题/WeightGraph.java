package 旅行商问题;
import java.util.*;


public class WeightGraph {
	private LinkedList<Edge>[] adj;
	private int d;
	private int b;
	
	public WeightGraph(int n) {
		d=n;
		adj=(LinkedList<Edge>[])new Object[n];
		
		for(int i=0;i<n;i++) {
			adj[i]=new LinkedList<Edge>();
		}
	}
	
	public void addEdge(Edge a) {
		adj[a.getA()].add(a);
		adj[a.getB()].add(a);
	}
	public WeightGraph(LinkedList<Edge>[] a,int c,int f) {
		adj=a;
		d=c;
		b=f;
	}
	public int getCountsOfDots() {
		return d;
	}
	public LinkedList<Edge>[] getAdj(){
		return adj;
	}
	
}
