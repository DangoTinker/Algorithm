package ��ʦ����;


public class Consumer implements Runnable {
    private Clerk clerk; 
    
    public Consumer(Clerk clerk) { 
        this.clerk = clerk; 
    } 
    
    public void run() { 
        System.out.println("���M�߿�ʼ��������......"); 
        for(int i = 1; i <= 10; i++) { 
            try { 
                Thread.sleep((int) (Math.random() * 3000)); 
            } catch(InterruptedException ex) { 
                throw new RuntimeException(ex);
            } 
            int product = clerk.getProduct(); 
        } 
    } 
 } 
