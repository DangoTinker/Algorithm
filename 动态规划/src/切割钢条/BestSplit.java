package ÇĞ¸î¸ÖÌõ;

public class BestSplit {
	private int[] data;
	private int[] rec;
	public BestSplit(int [] a) {
		data=a;
		rec=new int[a.length];
		for(int i=0;i<rec.length;i++) {
			rec[i]=0;
		}
	}
	
	public int split(int n) {
		if(n==0)
			return 0;
		int max=0;
		int temp=0;
		int r=0;
		for(int i=0;i<n;i++) {
			if(rec[i]!=0) {
				r=rec[i];
			}
			else {
				r=split(i);
				rec[i]=r;
			}
			temp=data[n-i]+r;
			if(temp>max) {
				max=temp;
			}
		}
		return max;
		
		
	}
	
	
	public int split2(int n) {
		n=n+1;
		int[] r=new int[n];
		for(int i=0;i<n;i++) {
			r[i]=0;
		}
		int max=0,temp;
		for(int i=1;i<n;i++) {
			for(int j=1;j<=i;j++) {
				temp=data[j]+r[i-j];
				
				if(temp>max) {
					max=temp;
				}
			}
			r[i]=max;
		}
		
		
		return r[n-1];
	}
	
}
