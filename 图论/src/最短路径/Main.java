package ×î¶ÌÂ·¾¶;
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
		
		//
	
		
		WeightDigraph digraph=new WeightDigraph(adj,6,8);
		Dijkstra dij=new Dijkstra(digraph,2);
		int[] dis=dij.getDis();
 		for(int i=0;i<dis.length;i++) {
// 			System.out.println(dis[i]);
 		}
 		
 		TSP tsp=new TSP(digraph,5);
 		tsp.test();
	}
}	
