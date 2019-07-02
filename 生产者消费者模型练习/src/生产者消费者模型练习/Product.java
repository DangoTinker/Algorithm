package 生产者消费者模型练习;

public class Product {
	 int count;
	public Product(int a){
		count=a;
	}
	
	public synchronized void take() throws Exception{
		while(count==0) {
			this.wait();
		}
		count--;
		System.out.println("已减去");
		
		
		this.notify();
		
	}
	
	public synchronized void cun() throws Exception{
		while(count==5) {
			this.wait();
		}
		count++;
		System.out.println("已加上");
		
		this.notify();
	}
}
