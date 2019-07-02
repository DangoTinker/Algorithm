package ÇĞ¸î¸ÖÌõ;

public class Main {
	public static void main(String[] args) {
		int[] a=new int[5];
		a[1]=2;
		a[2]=5;
		a[3]=2;
		a[4]=11;
		BestSplit bs=new BestSplit(a);
		System.out.println(bs.split2(3));
	}
}
