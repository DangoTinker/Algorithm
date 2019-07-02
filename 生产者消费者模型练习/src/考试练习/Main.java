package øº ‘¡∑œ∞;

public class Main {
	public static void main(String args[]) {
		Product product=new Product(50);
		Thread t1=new Thread(new ShengChan(product));
		XiaoFei sd=new XiaoFei(product);
		Thread t2=new Thread(sd);
		t1.start();
		t2.start();
	}
}
