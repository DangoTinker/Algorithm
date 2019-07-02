package »ô·òÂüÊ÷;

public class Main {
	public static void main(String[] args) {
		String a="asdaaasdd";
		Character[] b=new Character[5];
		b[0]='a';
		b[1]='b';
		b[2]='d';
		b[3]='a';
		b[4]='c';
//		b[5]='c';
		HuffmanTree<Character> tree=new HuffmanTree<Character>(b);
		tree.traversal();
	}
}	
