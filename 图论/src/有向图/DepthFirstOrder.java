package ÓÐÏòÍ¼;
import java.util.*;
public class DepthFirstOrder {
	private Digraph digraph;
	private boolean[] isMarked;
	private Queue<Integer> pre;
	private Queue<Integer> post;
	private Stack<Integer> reversePost;
	
	public DepthFirstOrder(Digraph a) {
		digraph=a;
		isMarked=new boolean[a.countsOfDonts()];
		for(int i=0;i<a.countsOfDonts();i++) {
			isMarked[i]=false;
		}
		pre=new LinkedList<Integer>();
		post=new LinkedList<Integer>();
		reversePost=new Stack<Integer>();
	}
	public void order() {
		for(int i=0;i<digraph.countsOfDonts();i++) {
			if(isMarked[i]!=true)
				dfs(i);
		}
	}
	public void dfs(int n) {
		isMarked[n]=true;
		pre.add(n);
		for(int i=0;i<digraph.getAdj()[n].size();i++) {
			if(isMarked[digraph.getAdj()[n].get(i)]!=true) {
				
				dfs(digraph.getAdj()[n].get(i));
				
			}
		}
		post.add(n);
		reversePost.push(n); 
	}
	
	public Stack<Integer> reversePost(){
		return reversePost;
	}
	
}
