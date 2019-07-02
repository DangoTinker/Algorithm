package 最大红包数;

public class Main {
	public static void main(String[] args) {
		int[][] a=new int[3][3];
		
		a[0][0]=1;
		a[0][1]=1;
		a[0][2]=17;
		a[1][0]=1;
		a[1][1]=12;
		a[1][2]=3;
		a[2][0]=24;
		a[2][1]=1;
		a[2][2]=4;
		FindBestWay f=new FindBestWay(a);
		System.out.println(f.value(2, 2));
	}
}
