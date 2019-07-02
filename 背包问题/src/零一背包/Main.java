package ÁãÒ»±³°ü;

public class Main {
	public static void main(String[] args) {
		int[] a=new int[5];
		int[] b=new int[5];
		int[] c=new int[5];
		a[0]=2;
		a[1]=3;
		a[2]=4;
		a[3]=5;
		a[4]=9;
		
		b[0]=3;
		b[1]=4;
		b[2]=5;
		b[3]=8;
		b[4]=10;
		
		c[0]=2;
		c[1]=2;
		c[2]=2;
		c[3]=2;
		c[4]=2;
		
		Bag01 bag=new Bag01(a,b,c);
		System.out.println(bag.start2(20));
		
	}
}
