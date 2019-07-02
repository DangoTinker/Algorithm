package ×î¶ÌÂ·¾¶;

import java.util.LinkedList;

public class Dijkstra {
	private WeightDigraph digraph;
	private boolean[] isMarked;
	private int[] dis;
	public Dijkstra(WeightDigraph a,int n) {
		digraph=a;
		isMarked=new boolean[a.getCountsOfDots()];
		dis=new int[a.getCountsOfDots()];
		for(int i=0;i<a.getCountsOfDots();i++) {
			isMarked[i]=false;
			dis[i]=(int)Double.POSITIVE_INFINITY;
		}
		dis[n]=0;
		
		
		shortestPath(n);
		
	}
	public int[] getDis() {
		return dis;
	}
	
	public void shortestPath(int n) {
		LinkedList<Edge>[] adj=digraph.getAdj();
		for(int i=0;i<adj[n].size();i++) {
			dis[adj[n].get(i).to()]=adj[n].get(i).getWeight();
//			System.out.println(dis[1]);
		}
		
		
		while(judgeIsMarked()) {
			int a=findMin();
			isMarked[a]=true;
			for(int i=0;i<adj[a].size();i++) {
				if(dis[a]+adj[a].get(i).getWeight()<dis[adj[a].get(i).to()]) {
					dis[adj[a].get(i).to()]=dis[a]+adj[a].get(i).getWeight();
				}
			}
//			for(int i=0;i<dis.length;i++) {
//	 			System.out.println(dis[i]);
//	 		}
//			for(int i=0;i<isMarked.length;i++) {
//				System.out.print(isMarked[i]);
//			}
			
			
//			System.out.println();
			
			
			
		}
		
	}
	
	private int findMin() {
		int min=(int)Double.POSITIVE_INFINITY;
		int a=0;
		for(int i=1;i<dis.length;i++) {
			if(min>=dis[i]&&isMarked[i]!=true) {
				a=i;
				min=dis[i];
			}
		}
		
		return a;
	}
	
	private boolean judgeIsMarked() {
		for(int i=0;i<isMarked.length;i++) {
			if(isMarked[i]==false&&dis[i]!=0&&dis[i]!=(int)Double.POSITIVE_INFINITY) {
				
				return true;
			}
		}
		return false;
	}
	
}
