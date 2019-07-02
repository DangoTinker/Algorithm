package ÎŞÏòÍ¼;
import java.util.*;
public class DepthFirstPaths {
	private Graph graph;
	private boolean[] isMarked;
	private int[] edgeTo;
	
	public DepthFirstPaths(Graph a) {
		graph=a;
		isMarked=new boolean[a.countsOfDots()];
		for(int i=0;i<isMarked.length;i++) {
			isMarked[i]=false;
		}
		edgeTo=new int[a.countsOfDots()];
	}
	
	public void addPaths() {
		dfs(0);
	}
	
	
	public void dfs(int n) {
		isMarked[n]=true;
		for(int i=0;i<graph.getAdj()[n].size();i++) {
			if(isMarked[graph.getAdj()[n].get(i)]!=true) {
				edgeTo[graph.getAdj()[n].get(i)]=n;
//				System.out..println(graph.getAdj()[n].get(i));
				dfs(graph.getAdj()[n].get(i));
			}
		}
		
	}
	
	public Iterable<Integer>  printPathTo(int s,int v) {
		Stack<Integer> stack=new Stack<Integer>();
		for(int i=v;i!=s;i=edgeTo[i]) {
//			if(i==0)
//				break;
			stack.add(i);
		}
		stack.add(s);
		return stack;
	}
	
}
