package 老师例子;


public class Consumer implements Runnable {
    private Clerk clerk; 
    
    public Consumer(Clerk clerk) { 
        this.clerk = clerk; 
    } 
    
    public void run() { 
        System.out.println("消費者开始消耗整数......"); 
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
