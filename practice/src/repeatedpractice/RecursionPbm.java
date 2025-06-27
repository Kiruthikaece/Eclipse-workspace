package repeatedpractice;

import java.util.Scanner;

public class RecursionPbm {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		int n=sc.nextInt();
		//printNames(n);
		//print1ton(1,n);
		//printnto1(n);
//		int sum=printSum1ton(n,0);
//		System.out.println("Sum="+sum);
		
//		int res=findFactorial(n,1);
//		System.out.println("factorial:"+res);
		
//		int[] arr= {5,4,3,2,1};
//		reverseArray(arr,arr.length);
		
//		String s=sc.nextLine();
//		boolean res=checkPalindrome(s,0);
//		System.out.println(res);
		
//		int res=fibannocci(n);
//		System.out.println(res);
		
		fib(n);
		
		
	}

	private static void fib(int n) {
		int first=0;
		int sec=1;
		int sum=1;
		for(int i=2;i<n;i++) {
			sum=sum+sec;
			sec=sum;
			System.out.println("sum:"+sum);
		}
		
		
	}

	private static int fibannocci(int n) {
		  if(n==0)
			  return 0;
		  else if(n==1)
			  return 1;
		  else
			  return fibannocci(n-1)+fibannocci(n-2);  
	}

	private static boolean checkPalindrome(String s, int i) {
		if(i>=s.length()/2)
			return true;
		
		if(s.charAt(i)!=s.charAt(s.length()-i-1))
			return false;
		
		return checkPalindrome(s,i+1);
	}

	private static void reverseArray(int[] arr,int n) {
		 if(n==0)
		 return;
		 System.out.println(arr[n-1]);
		 
		 reverseArray(arr,n-1);
	}

	private static int findFactorial(int n,int f) {
		if(n==0)
			return f;
		
		f=f*n;
		return findFactorial(n-1,f);
	}

	private static int printSum1ton(int n, int sum) {
		if(n==0)
			return sum;
		sum=sum+n;
		return printSum1ton(n-1,sum);
	}

	private static void printnto1(int n) {
		if(n==0)
			return;
		
		System.out.println(n);
		printnto1(n-1);
	}

	private static void print1ton(int i, int n) {
		if(i>n)
			return;
		System.out.println(i);
		
		print1ton(i+1,n);	
	}

	private static void printNames(int n) {
		if(n==0)
			return;
		System.out.println("Tamil");
		printNames(n-1);
	}

}
