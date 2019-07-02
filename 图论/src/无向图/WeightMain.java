package ÎÞÏòÍ¼;
import java.io.*;
import java.util.*;
public class WeightMain{
	public static void main(String [] args) throws Exception{
		FileInputStream in=new FileInputStream("weight.txt");
		DataInputStream input=new DataInputStream(in);
		WeightGraph graph=new WeightGraph(input);
		LinkedList<Edge>[] adj=graph.getAdj();
	/*	for(LinkedList<Edge> i:adj) {
			for(Edge j:i) {
				System.out.println(j.getA()+" "+j.getB()+" "+j.getWeight());
			}
		}*/
		LazyPrim prim=new LazyPrim(graph);
		LinkedList<Edge> list=prim.getList();
		
//		Kruskal kruskal=new Kruskal(graph);
//		LinkedList<Edge> list=kruskal.getList();
//		System.out.println("asd");
		for(Edge i:list) {
//			System.out.println("qqq");
			System.out.println(i.getA()+" "+i.getB()+" "+i.getWeight());
		}
		
	}
}
