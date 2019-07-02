package 老师例子;

public class Clerk {
    private int product = -1;   
    public synchronized void setProduct(int product) { 
            while(this.product != -1) { 
                try { 
                    wait();
                } catch(InterruptedException ex) { 
                    throw new RuntimeException(ex);
                } 
            }  
            this.product = product; 
            System.out.printf("生产者设定 (%d)%n", this.product); 
            notify();
    } 
    
    public synchronized int getProduct() {  
            while(this.product == -1) { 
                try { 
                    wait();
                } catch(InterruptedException ex) { 
                    throw new RuntimeException(ex);
                } 
            } 
            int p = this.product; 
            System.out.printf("\t\t\t ----- 消费者取走 (%d)%n", this.product); 
            this.product = -1; 
            notify();
            return p;  
    } 
} 



/** 另一种效率高的做法   
package cn.edu.dlnu;

import java.util.concurrent.locks.*;

public class Clerk {
    private int product = -1; 
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
 
    public void setProduct(int product) {
        try {
            lock.lock();
            while(this.product != -1) { 
                try { 
                    condition.await();
                } catch(InterruptedException ex) { 
                    throw new RuntimeException(ex);
                } 
            }  
            this.product = product; 
            System.out.printf("生产者设定 (%d)%n", this.product); 
            condition.signal();
        } finally {
            lock.unlock();
        }
    } 
    
    public int getProduct() { 
        try {
            lock.lock();
            while(this.product == -1) { 
                try { 
                    condition.await();
                } catch(InterruptedException ex) { 
                    throw new RuntimeException(ex);
                } 
            } 
            int p = this.product; 
            System.out.printf("\t\t\t ----- 消费者取走 (%d)%n", this.product); 
            this.product = -1; 
            condition.signal();
            return p; 
        } finally {
            lock.unlock();
        }
    } 
} 

*/