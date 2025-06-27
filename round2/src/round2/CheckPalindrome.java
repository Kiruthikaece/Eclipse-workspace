package round2;

import java.util.Arrays;
import java.util.Scanner;

public class CheckPalindrome {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter n");
		int n=sc.nextInt();
		boolean res=checkPalindrome(n);
		System.out.println(res);
	}

	private static boolean checkPalindrome(int n) {
		
//		String s=Integer.toBinaryString(-5);
//		System.out.println(s+".....111");
		
		if(n<0)
			return false;
		
		int[] bin=new int[10];
		int k=0;
		
		while(n!=0) {
			if(n%2==0)
				bin[k++]=0;
			else
				bin[k++]=1;
			n=n/2;
		}
		
		for(int i=0;i<k;i++)
			System.out.print(bin[i]);
		System.out.println();
		
		int left=0,right=k-1;
		
		while(left<right) {
			if(bin[left]!=bin[right])
				return false;
			left++;
			right--;
		}
		
		return true;
		
//		int x=bin,reverse=0;
//		
//		while(x!=0) {
//			int d=x%10;
//			reverse=reverse*10+d;
//			x=x/10;
//		}
//		
//		//System.out.println(Arrays.toString(bin));
//		return reverse==bin;
	}
	
	

}
