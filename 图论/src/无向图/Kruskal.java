package ÎŞÏòÍ¼;
import java.util.*;

public class Kruskal {
	private LinkedList<Edge> list;
	private PriorityQueue<Edge> queue;
	private boolean[] isMarked;
	
	public Kruskal(WeightGraph graph) {
		list=new LinkedList<Edge>();
		queue=new PriorityQueue<Edge>(2*graph.countsOfB());
		isMarked=new boolean[graph.countsOfDots()];
		for(boolean i:isMarked) 
			i=false;
		
		for(int i=0;i<graph.countsOfDots();i++) {
			
			for(int j=0;j<graph.getAdj()[i].size();j++) {
//				if(isMarked[j]!=true)
					queue.add(graph.getAdj()[i].get(j));
			}
			isMarked[i]=true;
		}
		
//		Edge[] temp=queue.getData();
//		System.out.println(temp.length);
//		for(Edge i:temp) {
//			System.out.println(i.getA()+" "+i.getB()+" "+i.getWeight());
//		}
		
//		for(boolean i:isMarked) {
//			i=false;
//		}
		for(int i=0;i<graph.countsOfDots();i++) {
			isMarked[i]=false;
		}
		
//		for(boolean i:isMarked) 
//			System.out.println(i);
		
		while(!queue.isEmpty()) {
//			System.out.println("eee");
			Edge max=queue.poll();
//			System.out.println(max.getA()+" "+max.getB()+" "+max.getWeight());
//			System.out.println(isMarked[max.getA()]+" "+isMarked[max.getB()]);
			if(isMarked[max.getA()]==false||isMarked[max.getB()]==false) {
				isMarked[max.getA()]=true;
				isMarked[max.getB()]=true;
				list.add(max);
			}
		}
		
	}
	
	public LinkedList<Edge> getList(){
		return list;
	}
}
