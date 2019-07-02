package 最大红包数;

public class FindBestWay {
	private int[][] data;
	private int ro,cl;
	public FindBestWay(int[][] a) {
		data=a;
		cl=a[0].length;
		ro=a.length;
	}
	
	public int value(int a,int b) {
		if(a-1>=0&&b-1>=0) {
			if(value(a-1,b)>value(a,b-1))
				return value(a-1,b)+data[a][b];
			else
				return value(a,b-1)+data[a][b];
		}
		else if(a-1<0&&b-1>=0) 
			return value(a,b-1)+data[a][b];
		else if(a-1>=0&&b-1<0)
			return value(a-1,b)+data[a][b];
		else
			return data[0][0];
			
	}
	
	
}
