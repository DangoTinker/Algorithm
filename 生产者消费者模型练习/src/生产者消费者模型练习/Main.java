package 生产者消费者模型练习;

public class Main {
	public static void main(String[] args) {
		Product product=new Product(0);
		Runnable r1=new ShengChan(product);
		Runnable r2=new XiaoFei(product);
		
		Thread t1=new Thread(r1);
		Thread t2=new Thread(r2);
		t2.start();
		t1.start();
	}
}
