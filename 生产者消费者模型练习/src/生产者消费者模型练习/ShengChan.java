package ������������ģ����ϰ;

public class ShengChan implements Runnable{
	private Product product;
	
	public ShengChan(Product a) {
		product=a;
	}
	
	
	public void run() {
		try {
			product.cun();
//			System.out.println("����"+product.count);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
