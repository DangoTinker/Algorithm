package ¹þ·òÂüÑ¹Ëõ;
import java.io.*;
import java.util.*;
public class HuffmanTree {
	private Node head;
	private int R=256;
	private String file;
	private String[] HC=new String[R];
	private int[] count=new int[R];
	public HuffmanTree(DataInputStream a) throws Exception{
		DataInputStream in=a;
		file=new String(in.readAllBytes());
		int[] count=countsOfChar();
		this.count=count;
		head=buildTree(count);
		creatHC(head,"");
//		System.out.println("a:"+HC[(int)'a']);
//		System.out.println("b:"+HC[(int)'b']);
//		System.out.println("c:"+HC[(int)'c']);
	}
	
	public HuffmanTree() {
		
	}
	
	public int[] countsOfChar() {
		int[] count=new int[R];
		for(int i=0;i<R;i++) {
			count[i]=0;
		}
		for(int i=0;i<file.length();i++) {
			count[file.charAt(i)]++;
		}
		return count;
		
	}
	
	public Node buildTree(int[] count) {
		
		PriorityQueue<Node> pq=new PriorityQueue<Node>();
		for(int i=0;i<count.length;i++) {
			pq.add(new Node((char)i,count[i],null,null));
		}
		while(pq.size()!=1) {
			Node temp1=pq.poll();
			Node temp2=pq.poll();
			Node temp3=new Node(null,temp1.getWeight()+temp2.getWeight(),temp1,temp2);
			pq.add(temp3);
		}
		return pq.poll();
	}
	
	public void creatHC(Node now,String code) {

		if(now.getVal()!=null) {
			HC[now.getVal()]=code;

			return;
		}
		creatHC(now.getLeft(),code+"0");
		creatHC(now.getRight(),code+"1");
		
		
	}
	
	public void zip(DataOutputStream a) throws Exception {
		DataOutputStream out=a;
		String o="";
		
		for(int i=0;i<count.length;i++) {
			if(count[i]!=0) {
				a.writeInt(i);
				a.writeInt(count[i]);
			}
		}
		a.writeInt(-1);
		
		int intBit=0,index=1;
		for(int i=0;i<file.length();i++) {

			
			for(int j=0;j<HC[file.charAt(i)].length();j++) {
				if(HC[file.charAt(i)].charAt(j)=='0') {
					intBit=writeBitToInt(intBit,'0',index);
					index++;
					if(index==32) {
						intBit=writeBitToInt(intBit,'0',32);
						out.writeInt(intBit);
						intBit=0;
						index=1;
					}
					
				}
				else {
					intBit=writeBitToInt(intBit,'1',index);
					index++;
					if(index==32) {
						intBit=writeBitToInt(intBit,'0',32);
						out.writeInt(intBit);
						intBit=0;
						index=1;
					}

				}
			}
			
			

		}
		
		if(index!=1) {
			out.writeInt(-300);
			out.writeInt(index);
			out.writeInt(intBit);
		}
		
		

		out.flush();
		out.close();
	}
	
	public String unzip(DataInputStream in,DataOutputStream out) throws Exception{
		int temp;
		while((temp=in.readInt())!=-1) {
			count[temp]=in.readInt();
//			System.out.println(temp);
//			System.out.println(count[temp]);
		}
		String o="";
		int t;
		char b;
		try {
			while(true) {
				t=in.readInt();
				
				if(t==-300) {
					int index=in.readInt();
					t=in.readInt();
					for(int i=1;i<=index;i++) {
						b=getBitFromInt(t,i);
						if(b=='0') {
							o=o+"0";
						}
						else {
							o=o+"1";
						}
					}
				}
				else
				
				for(int i=1;i<=31;i++) {
					b=getBitFromInt(t,i);
					if(b=='0') {
						o=o+"0";
					}
					else {
						o=o+"1";
					}
				}
				
			}
			
			
		}catch(EOFException e) {
			
		}
//		System.out.println(o);
		String x="";
		head=buildTree(count);
		Node now=head;
		for(int i=0;i<o.length();i++) {
			if(now.getVal()!=null) {
				x=x+String.valueOf(now.getVal());
				now=head;
				i--;
			}
			else if(o.charAt(i)=='0') {
				now=now.getLeft();
			}
			else {
				now=now.getRight();
			}
		}
		
		out.write(x.getBytes());
	
		return x;
		
	}

	public static int writeBitToInt(int a,char bit,int index) {
        if (bit=='0' || index<0 || index>32)
            return a;
        return 1<<index-1 | a;
    }
	
	public static char getBitFromInt(int a, int index) {
        if (index<0 || index>32)
            return '0';
        return (a>>index-1 & 0x00000001) == 1 ? '1' : '0';
    }



	
}
