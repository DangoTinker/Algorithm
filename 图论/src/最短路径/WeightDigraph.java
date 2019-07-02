package ×î¶ÌÂ·¾¶;
import java.util.*;
public class WeightDigraph {
	private LinkedList<Edge>[] adj;
	private int d;
	private int b;
	
	public WeightDigraph(LinkedList<Edge>[] a,int c,int f) {
		adj=a;
		d=c;
		b=f;
	}
	
	public int getCountsOfDots() {
		return d;
	}
	public LinkedList<Edge>[] getAdj() {
		return adj;
	}
	
}
