package ×Ö·û´®ÅÅÐò;

public class Main {
	public static void main(String[] agrs) {
		String[] test=new String[5];
		test[0]="AFCAA";
		test[1]="FDDBA";
		test[2]="FCDUA";
		test[3]="DADFB";
		test[4]="DBFZC";
		String[] res;
		LSD lsd=new LSD(test);
		String[] aux=lsd.getAux();
		res=lsd.sort(test, 5);
		for(String i:res) {
			System.out.println(i);
		}
		
	}
}
