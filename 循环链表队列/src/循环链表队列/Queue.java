package 循环链表队列;

public class Queue<Item> {
	
	class Node<Item>{
		private Item data;
		private Node next=null;
		public Node() {
			
		}
		public Node(Item a,Node b) {
			data=a;
			next=b;
		}
		
	}
	
	private Node head=new Node();
	private Node tail=null;
	
	public Queue() {
		
	}
	
	public void taversal() {
		Node temp=head.next;
		while(temp!=head) {
			System.out.print(temp.data);
			temp=temp.next;
		}
	}
	
	public void enqueue(Item item) {
		if(head.next==null) {
			Node newNode=new Node(item,head);
			head.next=newNode;
			tail=newNode;
		}
		else {
			Node temp=head;
			while(temp.next!=head) {
				temp=temp.next;
			}
			Node newNode=new Node(item,head);
			temp.next=newNode;
			tail=newNode;
		}
	}
	
	public Item dequeue() {
		if(tail==null)
			return null;
		Node temp=tail.next.next;
		tail.next.next=tail.next.next.next;
		return (Item)temp.data;
		
	}
	
	
}
