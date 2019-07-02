package ÎÞÏòÍ¼;
import java.io.*;
import java.util.Iterator;
public class Main {
	public static void main(String [] args) throws Exception{
		String fileName="test.txt";
		
		FileInputStream in=new FileInputStream(fileName);
		DataInputStream input=new DataInputStream(in);
		Graph graph=new Graph(input);
		DepthFirstPaths depthFirstPaths=new DepthFirstPaths(graph);
//		depthFirstPaths.addPaths();
//		for(int i:depthFirstPaths.printPathTo(0, 6)) {
//			System.out.println(i);
//		}
		CC cc=new CC(graph);
		cc.dfs();
		
		System.out.println(cc.isConnected(9, 11));
		System.out.println(cc.getCount());
		
	}
}
