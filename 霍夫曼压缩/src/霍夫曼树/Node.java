package »ô·òÂüÊ÷;

public class Node<Value> implements Comparable<Node<Value>>{	
	private Value ch;
	private int weight;
	private Node left,right;
	
	public Node(Value a,int b,Node c,Node d) {
		ch=a;
		weight=b;
		left=c;
		right=d;
		
	}
	
	public Node getLeft() {
		return left;
	}
	
	public Node getRight() {
		return right;
	}
	
	
	public int getWeight() {
		return weight;
	}
	public Value getCh() {
		return ch;
	}
	
	
	@Override
	public int compareTo(Node a) {
		if(weight>a.weight) return 1;
		else if(weight<a.weight) return -1;
		else return 0;
	}

	
	
}
