package 生产者消费者模型练习;

public class ShengChan implements Runnable{
	private Product product;
	
	public ShengChan(Product a) {
		product=a;
	}
	
	
	public void run() {
		try {
			product.cun();
//			System.out.println("生产"+product.count);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
