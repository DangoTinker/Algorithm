package HashMap;

public class Main {
	public static void main(String[] args) {
		HashMap<String,Integer> a=new HashMap();
		a.put("111", 1);
		a.put("222", 2);
		a.put("333", 3);
		System.out.println(a.get("222"));
	}
}
