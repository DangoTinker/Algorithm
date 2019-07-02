package øº ‘¡∑œ∞;

public class XiaoFei implements Runnable{
	private Product product;
	
	public XiaoFei (Product a) {
		product=a;
	}
	
	public void run() {
		try {
			product.take();
		}catch(Exception ex) {
			
		}
		
	}
}
