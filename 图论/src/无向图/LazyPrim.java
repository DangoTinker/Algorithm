package ÎÞÏòÍ¼;
import java.util.*;
public class LazyPrim {
	private LinkedList<Edge> list;
	private PriorityQueue<Edge> queue;
	private boolean[] isMarked;
	
	public LazyPrim(WeightGraph graph) {
		list=new LinkedList<Edge>();
		queue=new PriorityQueue<Edge>(graph.countsOfB());
		isMarked=new boolean[graph.countsOfDots()];
//		for(boolean i:isMarked) {
//			i=false;
//		}
		for(int i=0;i<graph.countsOfDots();i++) {
			isMarked[i]=false;
		}
		for(Edge i:graph.getAdj()[0]) {
			queue.add(i);
		}
		Edge max=queue.poll();
		list.add(max);
		isMarked[0]=true;
		isMarked[max.other(0)]=true;
		prim(graph,max.other(0));
		
	}
	
	public void prim(WeightGraph graph,int n) {
		for(Edge i:graph.getAdj()[n]) {
			queue.add(i);
//			System.out.println(i.getA()+" "+i.getB()+" "+i.getWeight());
			
		}
//		System.out.println();
		int count=0;
		while(true){
			if(queue.isEmpty())
				break;
			Edge max=queue.poll();
//			System.out.println(max.getA()+" "+max.getB()+" "+max.getWeight());
			
//			count++;
			if(isMarked[max.getA()]==false||isMarked[max.getB()]==false) {
//				System.out.println("asd");
				list.add(max);
				isMarked[max.getA()]=true;
				isMarked[max.getB()]=true;
				if(isMarked[max.getA()]==true)
					prim(graph,max.getB());
				else
					prim(graph,max.getA());
				break;
			}
			
		}
		
		
	}
	
	public LinkedList<Edge> getList(){
		return list;
	}
	
}
