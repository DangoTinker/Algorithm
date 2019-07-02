package ≈≈–Ú¡∑œ∞;

import java.util.Scanner;

public class Test {
	private int[] data;
	private int[] aux;
	public Test(int[] a) {
		data=a;
		aux=new int[a.length];
	}
	public int length() {
		return data.length;
	}
	int j;
	public void InsertSort() {
		for(int i=1;i<data.length;i++) {
			int temp=data[i];
			for(j=i-1;j>=0;j--) {
				
				if(temp<data[j]) {
					data[j+1]=data[j];
				}
				else
					break;
				
			}
			data[j+1]=temp;
		}
		
	}
	
	public void startGuiBing() {
		guibingSort(data,0,data.length-1);
	}
	
	public void guibingSort(int[] a,int low,int high) {
		int mid=low+(high-low)/2;

		if(high<=low) {
			return;
		}
		guibingSort(a,low,mid);
		
		guibingSort(a,mid+1,high);
		hebing(a,low,mid,high);
		
	}
	
	public void guibingSort2() {
		int j=0;
		for(int i=2;i<data.length;i=i*2) {
			for(j=0;j<=data.length-i;j=j+i) {
//				System.out.println(j);
//				if(j!=data.length-i)
					hebing(data,j,(2*j+i)/2-1,j+i-1);
//				else
//					hebing(data,j-i,(j-i+j)/2,j);
			}
		}
		
		hebing(data,0,j-1,data.length-1);
	}
	
	
	public void hebing(int[] a,int low,int mid,int high) {
		
		for(int i=low;i<=high;i++) {
			aux[i]=a[i];
		}
		int i=low;
		int j=mid+1;
		
		for(int k=low;k<=high;k++) {
			if(i>=mid+1)  
				a[k]=aux[j++];
			else if(j>high)
				a[k]=aux[i++];
			else if(aux[i]>aux[j])
				a[k]=aux[j++];
			else
				a[k]=aux[i++];
			
		}
		
	}
	
	
	public void quickSort(int left,int right) {
		if(left>right)
			return;
		
		int mid=qiefen(left,right);
		quickSort(left,mid-1);
		quickSort(mid+1,right);
		
	}
	
	public int qiefen(int left,int right) {
		int mid=left;
		int i=left;
		int j=right;
		
		while(i<j) {
		
		while(data[j]>=data[mid]&&i<j) {
			j--;
			
			
		}
		while(data[i]<=data[mid]&&i<j) {
			i++;
			
			
		}
		
		if(i<j) {
			int temp=data[i];
			data[i]=data[j];
			data[j]=temp;
		}
		
		}
		int temp=data[i];
		data[i]=data[mid];
		data[mid]=temp;
		mid=i;
		return mid;
		
	}
	
	
	
	
	
}
