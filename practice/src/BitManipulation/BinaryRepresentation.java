package BitManipulation;

import java.util.Scanner;

public class BinaryRepresentation {

	public static void main(String[] args) {
		 
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter n:");
		int N=sc.nextInt();
		
		String res=binaryNumber(N);
		System.out.println(res);
		
		binaryNumber1(N);
		
		
		 
	    }

	private static void binaryNumber1(int n) {
		for(int i=31;i>=0;i--) {
			int bit=(n>>i)&1;
			System.out.print(bit);
		}
	}

	private static String binaryNumber(int N) {
		StringBuilder str=new StringBuilder();
	       while(N!=0) {
	           int d=N%2;
	           str.append(d);
	           N=N/2;
	       }
	       int n=30-str.length();
	       
	       for(int i=1;i<=n;i++)
	       str.append("0");
	       return str.reverse().toString();
	}
		
}


