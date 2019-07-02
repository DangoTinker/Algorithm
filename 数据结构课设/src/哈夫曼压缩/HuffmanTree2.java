package ¹þ·òÂüÑ¹Ëõ;
import java.io.*;
import java.util.*;
public class HuffmanTree2 {
	private Node head;
	private int R=256;
	private String file;
	private String[] HC=new String[R];
	private int[] count=new int[R];
	public HuffmanTree2(DataInputStream a) throws Exception{
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
	
	public HuffmanTree2() {
		
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
	
	public void zip(OutputStream in) throws Exception {
		BufferedOutputStream buffer=new BufferedOutputStream(in);
		DataOutputStream a=new DataOutputStream(in);
		String o="";
		
		for(int i=0;i<count.length;i++) {
			if(count[i]!=0) {
//				a.writeInt(i);
				buffer.write(intToByteArray(i));
//				System.out.println(intToBytes(i));
//				System.out.println(byteArrayToInt(intToBytes(i),0));
//				Integer asd=new Integer(i);
//				buffer.write(i.);
//				a.writeInt(count[i]);
				buffer.write(intToByteArray(count[i]));
			}
		}
//		a.writeInt(-1);
//		System.out.println("asd");
		buffer.write(intToByteArray(-1));
		
		int intBit=0,index=1;
		for(int i=0;i<file.length();i++) {

			
			for(int j=0;j<HC[file.charAt(i)].length();j++) {
				if(HC[file.charAt(i)].charAt(j)=='0') {
					intBit=writeBitToInt(intBit,'0',index);
					index++;
					if(index==32) {
						intBit=writeBitToInt(intBit,'0',32);
//						Integer inte=new Integer(intBit);
						buffer.write(intToByteArray(intBit));
						
						intBit=0;
						index=1;
					}
					
				}
				else {
					intBit=writeBitToInt(intBit,'1',index);
					index++;
					if(index==32) {
						intBit=writeBitToInt(intBit,'0',32);
//						Integer inte=new Integer(intBit);
						buffer.write(intToByteArray(intBit));
						intBit=0;
						index=1;
					}

				}
			}
			
			

		}
		
		if(index!=1) {
//			a.writeInt(-300);
			buffer.write(intToByteArray(-300));
//			a.writeInt(index);
			buffer.write(intToByteArray(index));
//			a.writeInt(intBit);
			buffer.write(intToByteArray(intBit));
		}
		
		
		buffer.flush();
		buffer.close();
		a.flush();
		a.close();
	}
	
	public String unzip(DataInputStream in,DataOutputStream out) throws Exception{
		int temp=0;
		byte[] bytes=in.readAllBytes();
//		System.out.println(bytes.length);
//		byte[] bytesTemp;
		int[] ints=new int[bytes.length/4];
//		int c=0;
 		for(int i=0;i<bytes.length;i=i+4) {		
			ints[temp++]=byteArrayToInt(bytes,i);
//			if(ints[temp-1]==0) {
//				System.out.println(i+"--");
//			}
//			c++;
 		}
// 		System.out.println(c+" "+ints.length);
//		for(int i=0;i<ints.length;i++) {
//			System.out.println(ints[i]);
//		}
 		
 		temp=0;
 		
		while(true) {
//			System.out.println("1");
			if(ints[temp]==-1)
				break;
//			System.out.println(ints[2]);
			count[ints[temp]]=ints[temp+1];
			temp=temp+2;
			
		}
		System.out.println("a"+" "+count['a']);
		System.out.println("b"+" "+count['b']);
		System.out.println("c"+" "+count['c']);
		String o="";
		int t;
		char b;
		
			while(true) {
//				System.out.println("2");
				if(temp>=ints.length)
					break;
//				t=in.readInt();
				t=ints[temp++];
				if(t==-300) {
					int index=ints[temp++];
					t=ints[temp++];
					for(int i=1;i<=index;i++) {
						b=getBitFromInt(t,i);
						if(b=='0') {
							o=o+"0";
						}
						else {
							o=o+"1";
						}
					}
					break;
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
			
			
		
		System.out.println(o);
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
		System.out.println("------");
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

	public static int byteArrayToInt(byte[] b,int i) {   
		return   b[i+3] & 0xFF |   
		            (b[i+2] & 0xFF) << 8 |   
		            (b[i+1] & 0xFF) << 16 |   
		            (b[i] & 0xFF) << 24;   
		}   
		public static byte[] intToByteArray(int a) {   
		return new byte[] {   
		        (byte) ((a >> 24) & 0xFF),   
		        (byte) ((a >> 16) & 0xFF),      
		        (byte) ((a >> 8) & 0xFF),      
		        (byte) (a & 0xFF)   
		    };   
		}  
}
