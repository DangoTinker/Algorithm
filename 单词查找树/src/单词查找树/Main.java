package µ•¥ ≤È’“ ˜;
import java.util.*;
public class Main {
	public static void main(String[] args) {
		TrieST<Integer> st=new TrieST<Integer>(); 
		
		st.put("AAA", 111);
		st.put("ABB", 222);
		st.put("ACC", 121);
		st.put("ABC", 121);
		st.put("ABD", 121);
//		st.delete("AAA");
//		System.out.println(st.get("ABB"));
//		st.traversal();
		st.search("AB.");
		
		Queue<String> queue=st.getQueue();
		
		for(String i:queue) {
			System.out.println(i);
		}
		
	}
}
