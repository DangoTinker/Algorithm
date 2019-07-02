package πÈ≤¢≈≈–Ú;
import java.util.*;
import java.lang.*;
public class Stack<Item> implements Iterable<Item>{
	private Item[] data;
	private int size=0;
	
	class A implements Iterator<Item> {
		private int i=size;
		
		public boolean hasNext() {
			return i>0;
		}
		
		public Item next(){
			int temp=i-1;
			i--;
			return data[temp];
		}
	}
	
	
	public Iterator<Item> iterator(){
		return new A();
	}
	
	public Stack() {
		
	}
	
	
	public Stack(int n) {
		data=(Item[])new Object[n];
	}
	
	public void pop(Item item) {
		if(data.length==size) {
			Item[] temp=(Item[])new Object[size*2];
			for(int i=0;i<size;i++) {
				temp[i]=data[i];
			}
			data=temp;
		}
		
		data[size]=item;
		size++;
	}
	
	public Item push() {
		if(size==0)
			return null;
		Item temp=data[size-1];
		data[size-1]=null;
		size--;
		return temp;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	public int getLength() {
		return size;
	}
}
