package ÎŞÏòÍ¼;

public class CC {
	private Graph graph;
	private int count;
	private int[] id;
	private boolean[] isMarked;
	
	
	public CC(Graph a) {
		graph=a;
		count=0;
		id=new int[a.countsOfDots()];
		isMarked=new boolean[a.countsOfDots()];
		for(int i=0;i<isMarked.length;i++) {
			isMarked[i]=false;
		}
		
	}
	
	public boolean isConnected(int s,int v) {
		return id[s]==id[v];
	}
	
	
	public void dfs() {
		for(int i=0;i<graph.countsOfDots();i++) {
			if(isMarked[i]!=true) {
				dfs(i);
				count++;
			}
		}
	}
	public void dfs(int n) {
		isMarked[n]=true;
		id[n]=count;
		for(int i=0;i<graph.getAdj()[n].size();i++) {
			if(isMarked[graph.getAdj()[n].get(i)]!=true) {
				
				dfs(graph.getAdj()[n].get(i));
				
			}
			
		}
		
	}
	
	public int getCount() {
		return count;
	}
	
}
