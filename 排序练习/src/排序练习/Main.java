package ≈≈–Ú¡∑œ∞;

public class Main {
	public static void main(String[] args) {
		int[] a=new int[5];
		a[0]=3;
		a[1]=1;
		a[2]=5;
		a[3]=4;
		a[4]=2;
//		a[5]=6;
		Test b=new Test(a);
//		b.InsertSort();
//		b.startGuiBing();
//		b.guibingSort2();
		b.quickSort(0,4);
		for(int i=0;i<b.length();i++) {
			System.out.println(a[i]);
		}
	}
}
