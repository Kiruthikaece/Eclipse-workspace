package set18;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Add2Array {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter array1 size:");
		int n=sc.nextInt();
		int[] arr1=new int[n];
		System.out.println("Enter array1 elements:");
        for(int i=0;i<n;i++) {
        	arr1[i]=sc.nextInt();
        }
        
        System.out.println("Enter array2 size:");
		int m=sc.nextInt();
		int[] arr2=new int[m];
		System.out.println("Enter array1 elements:");
        for(int i=0;i<m;i++) {
        	arr2[i]=sc.nextInt();
        }
        
        addArray(arr1,arr2);
        
        
	}

	private static void addArray(int[] arr1, int[] arr2) {
		List<Integer> list=new ArrayList<>();
		
		 int n=arr1.length-1;
		 int m=arr2.length-1;
		 int i=Math.max(n, m);
		 
		 int carry=0,sum=0;
		 for(;i>=0;i--) {
			 sum=0;
			  sum=sum+carry;
			 if(n>=0)
				sum+=arr1[n];
			 
			 if(m>=0)
				 sum+=arr2[m];
			 
			 list.add(sum%10);
			 carry=sum/10;
			 
			 n--;
			 m--;
				 
		 }
		 
		 
		 System.out.println(list.reversed());
		 
	}

}
