package cheatsheat;

import java.util.Scanner;

public class Recursion {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter n:");
		int n=sc.nextInt();
		//printN(n);
		System.out.println(fib(n));
		
	}

	

	private static int fib(int n) {
	  if(n==0)
		  return 0;
	  if(n<=2)
		  return 1;
	  
	  return fib(n-2)+fib(n-1);
	}

	private static void printN(int n) {
		if(n==0)
			return;
		printN(n-1);
		System.out.print(n+" ");
	}

}
