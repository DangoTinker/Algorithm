package 旅行商问题;
import java.util.*;



public class Main {
	public static void main(String[] args) {
		
		LinkedList<Edge>[] adj=new LinkedList[6];
		for(int i=0;i<adj.length;i++) {
			adj[i]=new LinkedList<Edge>();
		}
		adj[0].add(new Edge(0,2,10));
		adj[0].add(new Edge(0,4,30));
		adj[0].add(new Edge(0,5,100));
		adj[1].add(new Edge(1,2,5));
		adj[2].add(new Edge(2,3,50));
		adj[3].add(new Edge(3,5,10));
		adj[4].add(new Edge(4,3,20));
		adj[4].add(new Edge(4,5,60));
		
		adj[2].add(new Edge(2,0,10));
		adj[2].add(new Edge(2,1,5));
		adj[5].add(new Edge(5,0,100));
		adj[4].add(new Edge(4,0,30));
		adj[3].add(new Edge(3,2,50));
		adj[5].add(new Edge(5,3,10));
		adj[3].add(new Edge(3,4,20));
		adj[5].add(new Edge(5,4,60));
		
		
//		System.out.println("Asd");
		WeightGraph digraph=new WeightGraph(adj,6,8);
		Dijkstra dij=new Dijkstra(digraph,0);
		double[] dis=dij.getDis();
 		for(int i=0;i<dis.length;i++) {
// 			System.out.println(dis[i]);
 		}
 		System.out.println();
 		TSP tsp=new TSP(digraph,2);
// 		System.out.println("Asd");
 		tsp.test();
// 		System.out.println("Asd");
	}
}	
