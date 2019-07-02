package ÎÞÏòÍ¼;

import java.util.*;
import java.io.*; 
public class WeightGraph {
	private LinkedList<Edge>[] adj;
	private int d;
	private int b;
	
	public WeightGraph() {
		
	}
	public int countsOfDots() {
		return d;
	}
	public LinkedList<Edge>[] getAdj(){
		return adj;
	}
	public int countsOfB() {
		return b;
	}
	
	
	
	public WeightGraph(DataInputStream in) throws Exception{
		d=Integer.valueOf(in.readLine());
//		System.out.println(d);
		b=Integer.valueOf(in.readLine());
		adj=new LinkedList[d];
		for(int i=0;i<d;i++) {
			adj[i]=new LinkedList<Edge>();
		}
		for(int i=0;i<b;i++) {
			int temp1=Integer.valueOf(in.readLine());
			int temp2=Integer.valueOf(in.readLine());
			double temp3=Double.valueOf(in.readLine());
			adj[temp1].add(new Edge(temp1,temp2,temp3));
			adj[temp2].add(new Edge(temp2,temp1,temp3));
		}
	}
	
	
}
