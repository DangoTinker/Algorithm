package πÈ≤¢≈≈–Ú;

public class Main {
	public static void main(String[] args) {
		int[] a=new int[5];
		a[0]=3;
		a[1]=4;
		a[2]=2;
		a[3]=0;
		a[4]=5;

		Sorts test=new Sorts(a);
		test.quickSort2();
//		test.insetSort(0, 4);
		for(int i=0;i<5;i++){
			System.out.print(a[i]+" ");
		}
	}
}
