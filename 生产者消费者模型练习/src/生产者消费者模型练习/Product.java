package ������������ģ����ϰ;

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
		System.out.println("�Ѽ�ȥ");
		
		
		this.notify();
		
	}
	
	public synchronized void cun() throws Exception{
		while(count==5) {
			this.wait();
		}
		count++;
		System.out.println("�Ѽ���");
		
		this.notify();
	}
}
