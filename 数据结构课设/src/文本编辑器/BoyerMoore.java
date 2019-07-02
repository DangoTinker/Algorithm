package ÎÄ±¾±à¼­Æ÷;

public class BoyerMoore {
	private int[] right;
	private String pat;
	
	public BoyerMoore(String p,int R) {
		pat=p;
		right=new int[R];
		for(int i=0;i<R;i++)
			right[i]=-1;
		
		for(int i=0;i<pat.length();i++) {
			right[pat.charAt(i)]=i;
		}	
	}
	
	public int search(String txt) {
		int skip=0;
		int j=0;
		for(int i=0;i<=txt.length()-pat.length();i+=skip) {
			skip=0;
			for(j=pat.length()-1;j>=0;j--) {
				if(txt.charAt(i+j)==pat.charAt(j)||pat.charAt(j)=='?') {
					
				}
				else {
					skip=j-right[txt.charAt(i+j)];
					int temp=j-right['?'];
					if(skip>temp) {
						skip=temp;
					}
					if(skip<1) skip=1;
					break;
				}
			} 
			
			if(j==-1) return i+pat.length()-1;
		}
		return -1;
		
	}
	
}
