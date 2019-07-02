package ÓĞÏòÍ¼;
import java.util.*;
public class DirectedDFS {
	private Digraph digraph;
	private boolean[] isMarked;
	private LinkedList<Integer> list=new LinkedList<Integer>();
	public DirectedDFS(Digraph a) {
		digraph=a;
		isMarked=new boolean[digraph.countsOfDonts()];
		for(int i=0;i<isMarked.length;i++) {
			isMarked[i]=false;
		}
	}
	
	public void Directed(int n){
		for(int i=0;i<isMarked.length;i++) {
			isMarked[i]=false;
		}
		dfs(n);
		
		
	}
	public LinkedList<Integer> getList(){
		return list;
	}
	
	public void dfs(int n) {
		isMarked[n]=true;
		list.add(n);
		for(int i=0;i<digraph.getAdj()[n].size();i++) {
			if(isMarked[digraph.getAdj()[n].get(i)]!=true) {
				dfs(digraph.getAdj()[n].get(i));
			}
			
		}
		
		
	}
	
	public boolean isDirectedDFS(int s) {
		return isMarked[s];
	}
	
	
}
