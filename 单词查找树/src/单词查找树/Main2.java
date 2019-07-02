package µ¥´Ê²éÕÒÊ÷;

public class Main2 {
	public static void main(String[] args) {
		TST<Integer> tst=new TST<Integer>();
		tst.add("123", 123);
		tst.add("124", 124);
		tst.add("213¡£", 213);
		tst.add("443", 443);
		System.out.println(tst.get("443"));
	}
}
