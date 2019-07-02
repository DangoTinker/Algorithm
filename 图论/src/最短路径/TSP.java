package ×î¶ÌÂ·¾¶;
import java.util.*;
public class TSP {
	private WeightDigraph graph;
	private int[][] dis;
	private int s;
	private boolean[] isMarked;
	private int feiyong=0;
	private LinkedList luxian;
	public TSP(WeightDigraph a,int n) {
		graph=a;
		s=n;
		luxian=new LinkedList();
		isMarked=new boolean[a.getCountsOfDots()];
		for(int i=0;i<a.getCountsOfDots();i++) {
			isMarked[i]=false;
		}
		
		dis=new int[a.getCountsOfDots()][a.getCountsOfDots()];
		for(int i=0;i<a.getCountsOfDots();i++) {
			for(int j=0;j<a.getCountsOfDots();j++) {
				dis[i][j]=(int)Double.POSITIVE_INFINITY;
			}
		}
		
		for(int i=0;i<a.getCountsOfDots();i++) {
			Dijkstra dij=new Dijkstra(graph,i);
			int[] d=dij.getDis();
			for(int j=0;j<a.getCountsOfDots();j++) {
				dis[i][j]=d[j];
			}
		}
		
		start(s);
		
	}
	
	public void start(int n) {
		isMarked[n]=true;
		LinkedList<Edge>[] adj=graph.getAdj();
		int min=0;
		boolean flag=false;
		for(int i=0;i<dis[n].length;i++) {
			if(dis[n][min]>dis[n][i]&&isMarked[i]!=true) {
				min=i;
				flag=true;
			}
		}
		if(flag==false)
			return;
		feiyong=feiyong+dis[n][min];
		luxian.add(min);
		start(min);
	}
	
	public void test() {
		System.out.println(feiyong);
		System.out.println();
		for(int i=0;i<luxian.size();i++) {
			System.out.println(luxian.get(i));
		}
		
	}
	
}
