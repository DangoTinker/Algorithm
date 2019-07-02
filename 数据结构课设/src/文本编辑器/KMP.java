package ÎÄ±¾±à¼­Æ÷;

public class KMP {
	private int[][] dfa;
	private int R;
	private String pat;
	
	public KMP(String p,int n) {
		pat=p;
		R=n;
		dfa=new int[R][pat.length()];
		int X=0;
		dfa[pat.charAt(0)][0]=1;
		for(int i=1;i<pat.length();i++) {
			for(int j=0;j<R;j++) {
				dfa[j][i]=dfa[j][X];
			}
			dfa[pat.charAt(i)][i]=i+1;
			X=dfa[pat.charAt(i)][X];
		}
		for(int i=0;i<pat.length();i++) {
			if(pat.charAt(i)=='?') {
				for(int j=0;j<R;j++) {
					dfa[j][i]=i+1;
				}
			}
		}
		
	}
	
	public int search(String txt) {
		for(int i=0,j=0;i<txt.length();i++) {
		
			
			j=dfa[txt.charAt(i)][j];
			if(j==pat.length()) return i;
			
		}
		
		return -1;
	}
	
	
	
}
