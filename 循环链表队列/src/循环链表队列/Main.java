package 循环链表队列;

public class Main {
	public static void main(String[] args) {
		Queue<Integer> queue=new Queue();
		queue.enqueue(0);
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		
		queue.taversal();
		System.out.println("");
		queue.dequeue();
		queue.taversal();
		System.out.println("");
		queue.dequeue();
		queue.taversal();
	}
	
}
