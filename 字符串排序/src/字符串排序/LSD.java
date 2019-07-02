package 字符串排序;
import java.util.*;
public class LSD {
	private String[] aux;
	public LSD(String[] data) {
	/*	int[] count=new int[26];
		aux=new String[data.length];
//		System.out.println(data.length);
		for(int i=data[0].length()-1;i>=0;i--) {
			
			for(int j=0;j<count.length;j++) {
				count[j]=0;
			}
			
			for(int j=0;j<data.length;j++) {
				count[data[j].charAt(i)-65]++;//char自动转化为int?
			}
			
			for(int j=1;j<count.length;j++) {
				count[j]=count[j]+count[j-1];
			}
			

			
			for(int j=0;j<count.length;j++) {
				if(count[j]!=0) {
					count[j]=1;
					break;
				}
			}
			
			for(int j=0;j<data.length;j++) {
				aux[count[data[j].charAt(i)-65]-1]=data[j];
				count[data[j].charAt(i)-65]--;
			}
		}*/
	}
		
	
	
	public String[] getAux() {
		return aux;
	}
	
	
	public static String[] sort(String[] a,int w) {
		int N=a.length;
		int R=256;
		String[] au=new String[N];
		for(int d=w-1;d>=0;d--) {
			int[] count=new int[R+1];
			for(int i=0;i<N;i++) 
				count[a[i].charAt(d)+1]++;
			
//			for(int i:count)
//				System.out.print(i);
//			System.out.println();
//			System.out.println("asd:"+a[0].charAt(d)+" "+count[a[0].charAt(d)]);
			for(int r=0;r<R;r++)
				count[r+1]=count[r+1]+count[r];
			
//			for(int i:count) {
				
//			}
//			System.out.println();
			
			for(int i=0;i<N;i++) {
//				System.out.println(a[i].charAt(d)+" "+count[a[i].charAt(d)]);
				au[count[a[i].charAt(d)]++]=a[i];
				
				
			}
			for(int i=0;i<N;i++)
				a[i]=au[i];
			
		}
		
		return au;
	}
	
	
}
