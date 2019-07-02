package 优先队列;


public class PriorityQueueOrigin {
	private int[] data;
	private int size=0;
	
	public PriorityQueueOrigin(){
		
	}
	
	public PriorityQueueOrigin(int n){
		data=new int[n+1];
		
	}
	
	public void swim(int k){
		while(k>1&&data[k]>data[k/2]){
			int temp=data[k];
			data[k]=data[k/2];
			data[k/2]=temp;
			k=k/2;
		}
		
	}
	
	public void sink(int k){
		
		while(k<=size){
			
			int j=2*k;
			if(j<size&&data[j+1]>data[j]){
				j++;
			}
			if(j<=size&&data[k]>data[j]){
				break;
			}
			if(j<=size) {
				int temp=data[k];
				data[k]=data[j];
				data[j]=temp;
			}
			k=k*2;
		}
		
		
		
	}
	
	public void insert(int item){
		data[size+1]=item;
		size++;
		swim(size);
		
	}
	
	public int delMax(){
		int max=data[1];
		data[1]=data[size];
		data[size]=0;
		size--;
		sink(1);
		return max;
	}
	
	public int[] getData(){
		return data;
	}
	
	public  void sort(int[] a){
		
		int n=a.length-1;
		data=a;
		size=a.length-1;
		for(int i=n/2;i>=1;i--){
			sink(i);
			
			
		}
		
		while(size>1){
			
			int x=a[1];
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
	
}

