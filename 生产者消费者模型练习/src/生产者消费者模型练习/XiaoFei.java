package ������������ģ����ϰ;

public class XiaoFei implements Runnable{
	private Product product;
	public XiaoFei(Product a) {
		product=a;
	}
	
	public void run() {
		try {
			product.take();
//			System.out.println("����"+product.count);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
