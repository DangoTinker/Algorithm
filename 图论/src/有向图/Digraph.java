package ÓÐÏòÍ¼;
import java.util.*;
import java.io.*;
public class Digraph {
	private LinkedList<Integer>[] adj;
	private int d;
	private int b;
	public Digraph(int v) {
		adj=new LinkedList[v];
		d=v;
		for(int i=0;i<d;i++) {
			adj[i]=new LinkedList<Integer>();
		}
	}
	
	
	public Digraph(DataInputStream in) throws Exception{
		d=Integer.valueOf(in.readLine());
		b=Integer.valueOf(in.readLine());
		adj=new LinkedList[d];
		for(int i=0;i<d;i++) {
			adj[i]=new LinkedList<Integer>();
		}
		for(int i=0;i<b;i++) {
			adj[Integer.valueOf(in.readLine())].add(Integer.valueOf(in.readLine()));
		}
		
	}
	public int countsOfDonts() {
		return d;
	}
	public LinkedList<Integer>[] getAdj(){
		return adj;
	}
	public void add(int s,int v) {
		adj[s].add(v);
	}
	
	
	public Digraph reverse() {
//		LinkedList<Integer>[] temp=new LinkedList[d];
		
		Digraph temp=new Digraph(d);
		
		for(int i=0;i<d;i++) {
			for(int j=0;j<adj[i].size();j++) {
			
				temp.add(adj[i].get(j), i);
			}	
		}
		
		return temp;
		
	}
	
	
}
