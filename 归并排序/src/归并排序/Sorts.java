package πÈ≤¢≈≈–Ú;

public class Sorts {
	private int[] a;
	private int[] aux;
	
	public Sorts(int []a) {
		this.a=a;
		aux=new int[a.length];
	}
	
	public void insertSort(int left,int right) {
		int temp;
		int j;
		for(int i=left+1;i<=right;i++) {
			temp=a[i];
			for(j=i-1;j>=0;j--) {
				
				if(temp<a[j]) {
					a[j+1]=a[j];
				}
				else
					break;
			}
			a[j+1]=temp;
			
		}
		
	}
	
	
	public void sort() {
		sort(0,a.length-1);
	}
	
	public void sort(int left,int right) {
//		System.out.println("asd");
		
//		if(left>=right)
//			return;
		
		int mid=(left+right)/2;
		
		if(right-left<=3) {
			insertSort(left,right);
		}
		
		else {
			sort(left,mid);
			sort(mid+1,right);
		}
		hebing(left,right);
		
		
	}
	
	public void hebing(int left,int right) {
		
		int mid=(left+right)/2;
		if(a[mid]<=a[mid+1])
			return;
		
		
		int j=mid+1;
		for(int i=left;i<=right;i++) {
			aux[i]=a[i];
		}
		int i=left;
		for(int k=left;k<=right;k++) {
			if(i>mid)
				a[k]=aux[j++];
			else if(j>right)
				a[k]=aux[i++];
			else if(a[i]<a[j])
				a[k]=aux[i++];
			else 
				a[k]=aux[j++];
			
			
		}
		
	}
	
	public void quickSort() {
		quickSort(0,a.length-1);
		
	}
	public void quickSort(int left,int right) {
		if(left>=right)
			return;
		int mid=parts(left,right);
		quickSort(left,mid);
		quickSort(mid+1,right);
		
		
	}
	
	public int parts(int left,int right) {
		int mid=left;
//		int tempmid=a[mid];
//		System.out.println(a[mid]+" "+tempmid);
		while(left<right) {
			while(a[right]>a[mid]&&left<right) {
				right--;
			}
			while(a[left]<=a[mid]&&left<right) {
				left++;
			}
			
			int temp=a[left];
			a[left]=a[right];
			a[right]=temp;
		}
//		System.out.println(a[mid]+" "+tempmid);
		int temp=a[mid];
		a[mid]=a[right];
		a[right]=temp;
		return right;
	}
	
	
	public void quickSort2() {
		
		Stack<int[]> stack=new Stack<int[]>();
		
//		stack.pop(a);
		int mid=parts(0,a.length-1);
		int mid2=mid+1;
		int mid1=mid;
		while(true) {
			if(mid1<=1) {
				break;
			}
				
				
			mid1=parts(0,mid1);
			mid2=parts(mid2,a.length-1);
			
			
			
		}
		
		
	}
	
}
