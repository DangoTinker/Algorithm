package 最大连续子数组;

public class Main {
	public static void main(String[] args) {
		int[] a=new int[5];
		
		a[0]=1;
		a[1]=-1;
		a[2]=0;
		a[3]=-1;
		a[4]=2;
		
		FindMaxArray findMaxArray=new FindMaxArray(a);
		System.out.print(findMaxArray.findMax(0, 4));
		
		
	}
}
