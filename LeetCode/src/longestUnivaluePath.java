import java.util.*;
public class longestUnivaluePath {
	public int[] a;
	private LinkedList queue=new LinkedList();
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
	}
	   public void traverse(TreeNode *root){
		    if(root == NULL)
		        return ;
		    traverse(root->left);
		        queue.add(root.val);
		    traverse(root->right);
		    }
		    
		     public void traverse(TreeNode *root){
		    if(root == NULL)
		        return ;
		    traverse(root->left);
		        root.val=queue.first();
		        queue.removeFirst();
		    traverse(root->right);
		    }
		     
		     public void sort() {
		    	 for(int i=0;i<queue.size();i++) {
		    		 for(int j=i;j<queue.size();j++) {
		    			 if(queue.get(i)>=queue.get(j)) {
		    				 int temp=queue.get(i);
		    				 queue.set(i, queue.get(j));
		    				 queue.fir
		    				 queue.set(j, temp);
		    			 }
		    			 
		    		 }
		    	 }   	 
		     }
		    
		    
	public void zhongxu() {
		queue.
	}
	
	public void inZhongxu(TreeNode now,int father) {
		
	}
	
	
	public int longestUnivaluePath(TreeNode root) {
		 
	}
}
