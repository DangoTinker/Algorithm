package ÁãÒ»±³°ü;

public class Bag01 {
	private int[] wi;
	private int[] vi;
	private int[] count;
	private int[][] f;
	public Bag01(int [] a,int[] b) {
		wi=a;
		vi=b;
		f=new int[100][100];
	}
	public Bag01(int[] a,int[] b,int[] c) {
		wi=a;
		vi=b;
		count=c;
		f=new int[100][100];
	}
	
	public int start(int n) {
		return dp(wi.length-1,n);
	}
	
	public int dp(int i,int j) {
		
		if(i==-1||j==-1)
			return 0;
		if(f[i][j]!=0) {
			return f[i][j];
		}
		if(wi[i]>j) {
			return dp(i-1,j);
		}
		else {
			int k=j/wi[i];
			
			int a=dp(i-1,j);
			int b=dp(i-1,j-wi[i]*k)+vi[i]*k;
			if(a>b) {
				f[i][j]=b;
				return a;
			
			}
			else {
				f[i][j]=a;
				return b;
			}
		}
		
	}
	
	
	public int start2(int n) {
		return dp2(wi.length-1,n);
	}
	
	public int dp2(int i,int j) {
		
		if(i==-1||j==-1)
			return 0;
		if(f[i][j]!=0) {
			return f[i][j];
		}
		if(wi[i]>j) {
			return dp(i-1,j);
		}
		else {
			int k=j/wi[i];
			if(count[i]<=k) {
				k=count[i];
			}
			
			int a=dp2(i-1,j);
			int b=dp2(i-1,j-wi[i]*k)+vi[i]*k;
			if(a>b) {
				f[i][j]=b;
				return a;
			
			}
			else {
				f[i][j]=a;
				return b;
			}
		}
		
	}
	
	
	
	
	
	public int loopVer(int weight) {
		
		f=new int[vi.length][weight+1];
		
		for(int i=1;i<vi.length;i++) {
			for(int j=0;j<=weight;j++) {
				
				if(wi[i]>j) {
					f[i][j]=f[i-1][j];
				}
				else {
					int a=f[i-1][j];
					int b=f[i-1][j-wi[i]]+vi[i];
					if(a>b)
						f[i][j]=a;
					else
						f[i][j]=b;
				}
				
				
			}
		}
		
		return f[vi.length-1][weight];
	}
	
	
}
