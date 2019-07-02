package ¹þ·òÂüÑ¹Ëõ;
import java.io.*;
public class Main {
	public static void main(String args[]) throws Exception{
		FileInputStream in=new FileInputStream("test.txt");
		DataInputStream input=new DataInputStream(in);
	
//		HuffmanTree h=new HuffmanTree(input);
		HuffmanTree2 h=new HuffmanTree2(input);
//		HuffmanTree h3=new HuffmanTree(input);
		FileOutputStream out=new FileOutputStream("asd.txt");
		DataOutputStream output=new DataOutputStream(out);
		h.zip(output);

		in=new FileInputStream("asd.txt");
		input=new DataInputStream(in);

		
//		HuffmanTree x=new HuffmanTree();
		HuffmanTree2 x=new HuffmanTree2();
		
		FileOutputStream temp=new FileOutputStream("o.txt");
		DataOutputStream tempoutput=new DataOutputStream(temp);
		
		
		x.unzip(input,tempoutput);
//		System.out.println("aaaaa-");
//		InputStream te=new FileInputStream("o.txt");
//		BufferedInputStream test=new BufferedInputStream(te);
		

		
	}
}
