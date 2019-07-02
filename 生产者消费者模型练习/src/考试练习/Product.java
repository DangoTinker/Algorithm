package øº ‘¡∑œ∞;
import java.util.concurrent.locks.*;
public class Product {
	private int count;
	private Lock lock;
	private Condition condition=lock.newCondition();
	public Product() {
		
	}
	public Product(int count) {
		this.count=count;
	}
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count=count;
	}
	
	public void take() throws Exception{
		lock.lock();
		while(count==0) {
			wait();
			
		}
		count--;
		
		condition.signal();
		lock.unlock();
		
		
	}
	
	public void cun() throws Exception{
		lock.lock();
		while(count==100) {
			wait();
		}
		count++;
		condition.signal();
		lock.unlock();
		
	}
	
}
