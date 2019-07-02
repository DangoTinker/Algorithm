package øº ‘¡∑œ∞;

public class ShengChan implements Runnable{
	private Product product;
	
	public ShengChan(Product product) {
		this.product=product;
	}
	
	public void run() {
			
		try {
			product.cun();
		}catch(Exception e) {
			
		}
		
	}
	
}
