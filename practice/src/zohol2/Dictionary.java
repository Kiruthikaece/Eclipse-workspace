package zohol2;

public class Dictionary {

	public static void main(String[] args) {
		String s="sprint";
		
		StringBuilder str=new StringBuilder(s);
		 
		while(str.length()>1) {
			 System.out.print(str+" ");
		      str.deleteCharAt(0);
		 }
		 System.out.print(str);
	}

}
