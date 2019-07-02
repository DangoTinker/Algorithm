package KMP;

public class Main {
	public static void main(String[] args) {
		BoyerMoore kmp=new BoyerMoore("ABC",256);
		System.out.println(kmp.search("CCCABC"));
//		BoyerMoore boyer=new BoyerMoore("ABC",256);
//		System.out.println(boyer.search("ABABC"));
	}
}
