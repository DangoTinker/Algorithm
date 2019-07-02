package 优先队列;

public class Main {
	public static void main(String[] args){
		/*
		FirstQueue firstQueue=new FirstQueue(10);
		firstQueue.insert(3);
		firstQueue.insert(1);
		firstQueue.insert(2);
		firstQueue.insert(5);
		firstQueue.insert(4);
		int[] a=firstQueue.getData();
		firstQueue.traversal();
		System.out.println();
		firstQueue.delMax();
		firstQueue.delMax();
		firstQueue.traversal();
		*/
		
		
		Integer[] a=new Integer[6];
		PriorityQueue firstQueue=new PriorityQueue(10);
		a[0]=0;
		a[1]=3;
		a[2]=1;
		a[3]=2;
		a[4]=5;
		a[5]=4;
		firstQueue.insert(0);
		firstQueue.insert(3);
		firstQueue.insert(1);
		firstQueue.insert(2);
		firstQueue.insert(3);
		firstQueue.insert(3);
		while(!firstQueue.isEmpty()) {
			System.out.println(firstQueue.delMax());
		}
		
		firstQueue.sort(a);
		
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]);
		}
		/*
		System.out.println();
		firstQueue.sort(a);
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]);
		}*/

	}
}
