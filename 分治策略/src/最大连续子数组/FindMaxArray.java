package 最大连续子数组;

public class FindMaxArray {
	private  int[] data;
	private	int leftLow,leftHigh,rightLow,rightHigh,crossLow,crossHigh;
	private int max,maxLeft,maxRight,maxCross;
	public FindMaxArray(int[] a) {
		data=a;
	}
	
	public int findCrossMax(int crossLow,int crossHigh) {
		int mid=(crossLow+crossHigh)/2;
		int sumLeft=0;
		int tempLeft=0;
		int i,j;
		for(i=mid;i>=crossLow;i--) {
			sumLeft=sumLeft+data[i];
			if(sumLeft>tempLeft) {
				tempLeft=sumLeft;
			}
			else 
				break;
			
		}
		int sumRight=0;
		int tempRight=0;
		for(j=mid;j<=crossHigh;j++) {
			sumRight=sumRight+data[j];
			if(sumRight>tempRight) {
				tempRight=sumRight;
			}
			else
				break;
			
		}
		
		
		crossLow=i;
		crossHigh=j;
		maxCross=sumLeft+sumRight;
		return maxCross;
	}
	
	
	public int  findMax(int low,int high) {
		
		if(low==high) {
			
			return data[low];
		}
		int mid=(low+high)/2;
		int maxLeft=findMax(low,mid);
		int maxRight=findMax(mid+1,high);
		int maxCross=findCrossMax(low,high);
		
		if(maxLeft>maxRight&&maxLeft>maxCross) {
			max=maxLeft;
			return maxLeft;
		}
		else if(maxRight>maxLeft&&maxRight>maxCross) {
			max=maxRight;
			return maxRight;
		}
		else {
			max=maxCross;
			return maxCross;
		}
			
		
		
	}
	
	
	
	
}
