package ÎŞÏòÍ¼;

import java.util.*;
import java.io.*; 
public class Graph {
	private LinkedList<Integer>[] adj;
	private int d;
	private int b;

	public Graph() {
		
	}
	public int countsOfDots() {
		return d;
	}
	public LinkedList<Integer>[] getAdj(){
		return adj;
	}
	public Graph(DataInputStream in) throws Exception{
		d=Integer.valueOf(in.readLine());
//		System.out.println(d);
		b=Integer.valueOf(in.readLine());
		adj=new LinkedList[d];
		for(int i=0;i<d;i++) {
			adj[i]=new LinkedList<Integer>();
		}
		for(int i=0;i<b;i++) {
			int temp1=Integer.valueOf(in.readLine());
			int temp2=Integer.valueOf(in.readLine());
			adj[temp1].add(temp2);
			adj[temp2].add(temp1);
		}
	}
	
	
}
