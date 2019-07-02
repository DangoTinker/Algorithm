package ÓĞÏòÍ¼;
import java.util.*;
public class KosarajuSCC {
	private Digraph digraph;
	private boolean[] isMarked;
	private int count;
	private int[] counts;
	private Stack<Integer> stack;
	public KosarajuSCC(Digraph a) {
		digraph=a;
		isMarked=new boolean[a.countsOfDonts()];
		count=0;
		counts=new int[a.countsOfDonts()];
	}
	
	public void judge() {
		Digraph temp=digraph.reverse();
		DepthFirstOrder order=new DepthFirstOrder(temp);
		order.order();
		stack=order.reversePost();
		for(int i:stack) {
			if(isMarked[i]!=true) {
				dfs(i);
				count++;
			}
		}
	
	
	}
	
	
	public void dfs(int n) {
		isMarked[n]=true;
		counts[n]=count;
		for(int i=0;i<digraph.getAdj()[n].size();i++) {
			if(isMarked[digraph.getAdj()[n].get(i)]!=true) {
				
				dfs(digraph.getAdj()[n].get(i));
			}
			
			
		}
	}
	
	public boolean stronglyConnected(int s,int v) {
		System.out.println(counts[s]+" "+counts[v]);
//		if(counts[s]!=0&&counts[v]!=0)
		return counts[s]==counts[v];
//		return false;
	}
	
}
