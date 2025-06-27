package practice;

import java.util.Scanner;

public class AlternateNumber {

	public static void main(String[] args) {
		System.out.println("Enter a number");
		Scanner sc=new Scanner(System.in);
		int x=sc.nextInt();
		int count=0;
		int current=-1;
		for(int i=0;i<10;i++) {
		  int d=x%2;
		  if(d!=current) {
			  count++;
			  current=d;
		  }  
		  x=x/2;
		}
		
		System.out.println("count:"+count);

	}

}
