package round2;

import java.util.Scanner;

public class RotateString {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
//		System.out.println("Enter s1");
//		String s1=sc.nextLine();
//		System.out.println("Enter s2");
//		String s2=sc.nextLine();
		
		String s1="an apple eating";
		String s2="apple eating an";
		
		
		boolean res=checkRotation(s1,s2);
		System.out.println(res);
		
		
		
	}

	private static boolean checkRotation(String s1, String s2) {
		String[] arr=s1.split(" ");
		int n=arr.length,i=0;
		
		while(i<n) {
			StringBuilder str=new StringBuilder();
			String temp=arr[0];
			System.out.println(temp+"...3");
			for(int j=1;j<n;j++) {
				str.append(arr[i]);
				str.append(" ");
			}
			str.append(temp);
			System.out.println(str.toString()+"....1");
			System.out.println(s2);
			if(str.toString().equals(s2))
				return true;
			else
				str.setLength(0);
			
			i++;
				
		}
		
		return false;
	}

}
