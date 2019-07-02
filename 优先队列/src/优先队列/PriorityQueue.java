package 优先队列;
import java.lang.*;
import java.lang.reflect.*;
public class PriorityQueue<Item extends Comparable<Item>> {
	private Item[] data;
	private int size=0;
	
	public PriorityQueue(){
		
	}
	
	@SuppressWarnings("unchecked")
	public PriorityQueue(int n){
//		data=(Item[])new Object[n+1];

		data = (Item[]) Array.newInstance(Integer.class, n+1);
	}
	
	public void swim(int k){
		while(k>1&&data[k].compareTo(data[k/2])==-1){
			Item temp=data[k];
			data[k]=data[k/2];
			data[k/2]=temp;
			k=k/2;
		}
		
	}
	
	public void sink(int k){
		
		while(k<=size){
			
			int j=2*k;
			if(j<size&&data[j+1].compareTo(data[j])==-1){
				j++;
			}
			if(j<=size&&data[k].compareTo(data[j])==-1){
				break;
			}
			if(j<=size) {
				Item temp=data[k];
				data[k]=data[j];
				data[j]=temp;
			}
			k=k*2;
		}
		
		
		
	}
	
	public void insert(Item item){
		data[size+1]=item;
		size++;
		swim(size);
		
	}
	
	public Item delMax(){
		Item max=data[1];
		data[1]=data[size];
		data[size]=null;//使用泛型后可能有问题
		size--;
		sink(1);
		return max;
	}
	
	public Item[] getData(){
		return data;
	}
	
	public  void sort(Item[] a){
		
		int n=a.length-1;
		data=a;
		size=a.length-1;
		for(int i=n/2;i>=1;i--){
			sink(i);
			
			
		}
		
		while(size>1){
			
			Item x=a[1];
			a[1]=a[size];
			a[size]=x;
			size--;
			sink(1);
			
		}
		
	}
	
	public void traversal() {
		for(int i=1;i<size+1;i++) {
			System.out.print(data[i]);
		}
	}
	
	public boolean isEmpty() {
		if(size==0)
			return true;
		return false;
	}
}

