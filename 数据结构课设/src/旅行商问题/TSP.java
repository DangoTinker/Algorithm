package 旅行商问题;
import java.util.*;
public class TSP {
	private WeightGraph graph;
	private double[][] dis;
	private int s;
	private boolean[] isMarked;
	private double feiyong=0;
	private LinkedList luxian;
	public TSP(WeightGraph a,int n) {
		graph=a;
		s=n;
		luxian=new LinkedList();
		isMarked=new boolean[a.getCountsOfDots()];
		for(int i=0;i<a.getCountsOfDots();i++) {
			isMarked[i]=false;
		}
		
		dis=new double[a.getCountsOfDots()][a.getCountsOfDots()];
		for(int i=0;i<a.getCountsOfDots();i++) {
			for(int j=0;j<a.getCountsOfDots();j++) {
				dis[i][j]=Double.POSITIVE_INFINITY;
				
			}
		}
		
		for(int i=0;i<a.getCountsOfDots();i++) {
			Dijkstra dij=new Dijkstra(graph,i);
			double[] d=dij.getDis();
			for(int j=0;j<a.getCountsOfDots();j++) {
				dis[i][j]=d[j];
//				System.out.println(d[j]+" "+i);
			}
//			System.out.println();
		}
		
		for(int i=0;i<a.getCountsOfDots();i++) {
			Dijkstra dij=new Dijkstra(graph,i);
			double[] d=dij.getDis();
			for(int j=0;j<a.getCountsOfDots();j++) {
				System.out.print(dis[i][j]+"       ");
			}
			System.out.println();
		}
		
		
		start(s);
		
	}
	
	public void start(int n) {
		
		isMarked[n]=true;
		LinkedList<Edge>[] adj=graph.getAdj();
		int min=0;
		boolean flag=false;
		for(int i=0;i<dis[n].length;i++) {
			if(i==n)
				continue;
			if(isMarked[i]!=true)
			if((dis[n][min]>dis[n][i]||dis[n][min]==0)) {
				min=i;
//				System.out.println(min+"========");
				flag=true;
			}
		}
		System.out.println(n+" "+flag);
		
		if(judge()==false)
			return;
		feiyong=feiyong+dis[n][min];
		luxian.add(min);
		start(min);
	}
	
	public void test() {
//		System.out.println("Asd");
		System.out.println(feiyong);
		System.out.println();
		for(int i=0;i<luxian.size();i++) {
			System.out.println(luxian.get(i));
		}
		
	}
	
	public boolean judge() {
		for(int i=0;i<isMarked.length;i++) {
			if(isMarked[i]==false)
				return true;
		}
		return false;
	}
}
