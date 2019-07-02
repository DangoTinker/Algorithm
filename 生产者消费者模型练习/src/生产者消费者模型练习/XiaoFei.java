package 生产者消费者模型练习;

public class XiaoFei implements Runnable{
	private Product product;
	public XiaoFei(Product a) {
		product=a;
	}
	
	public void run() {
		try {
			product.take();
//			System.out.println("消费"+product.count);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
