package practice;

import java.util.Scanner;

public class DecimalToBinary {
public static void main(String[] args) {
	System.out.println("Enter a number");
	Scanner sc=new Scanner(System.in);
	int x=sc.nextInt();
	int count=0;
	int s=0;
	for(int i=0;i<10;i++) {
	  int d=x%2;
	  if(d==1)
	   count++;
	  s=d+(s*10);
	//  System.out.print(d+" ");
	  x=x/2;
	}
	System.out.print(s);
		
}
}
