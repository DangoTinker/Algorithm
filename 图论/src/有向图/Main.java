package ÓÐÏòÍ¼;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		FileInputStream in=new FileInputStream("test.txt");
		DataInputStream input=new DataInputStream(in);
		Digraph digraph=new Digraph(input);
		
//		Digraph temp=digraph.reverse();
		LinkedList<Integer>[] adj=digraph.getAdj();
		for(int i=0;i<adj.length;i++) {
			System.out.print(i+" ");
			for(int j=0;j<adj[i].size();j++) {
				System.out.print(adj[i].get(j)+" ");
			}
			System.out.println();
		}
		DirectedDFS directDFS=new DirectedDFS(digraph);
		directDFS.Directed(0);
		LinkedList<Integer> list=directDFS.getList();
//		for(int i=0;i<list.size();i++) {
//			System.out.println(list.get(i));
//		}
		
//		System.out.println(directDFS.isDirectedDFS(5));
		KosarajuSCC kosara=new KosarajuSCC(digraph);
		kosara.judge();
		System.out.println(kosara.stronglyConnected(11,9));
		
	}
}
