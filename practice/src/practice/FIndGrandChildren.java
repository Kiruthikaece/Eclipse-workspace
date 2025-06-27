package practice;

import java.util.Scanner;

public class FIndGrandChildren {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		String[][] arr= {{"luke","shaw"},{"wayne","ronney"},{"ronney","ronaldo"},{"shaw","ronney"},{"VVV","wayne"}};
		
		System.out.println("Enter father:");
		String father=sc.next();
		
		int Grandchild=0;
		
		for(int i=0;i<arr.length;i++) {
			String fath=arr[i][1];
			String child=arr[i][0];
			
			if(fath.equals(father)) {
				 for(int j=0;j<arr.length;j++) {
					 if(child.equals(arr[j][1]))
						 Grandchild++; 
				 }
			}
		}
		
		System.out.println("Grandchild:"+Grandchild);
	}

}
