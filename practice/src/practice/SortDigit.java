package practice;

import java.util.Arrays;

class SortDigit {
	public static void main(String[] args) {
		int[] arr= {10,36,54,89,12};
		
		int[] weight=new int[arr.length];
		
		  for(int i=0;i<arr.length;i++) {
			 int x= findWight(arr[i]);
			  weight[i]=x;
		  }
		  
		  
		  for(int i=0;i<weight.length;i++) {
			  for(int j=i+1;j<weight.length;j++) {
				  if(weight[i]>weight[j]) {
					  int temp=weight[i];
					  weight[i]=weight[j];
					  weight[j]=temp;
					  
					  int temp1=arr[i];
					  arr[i]=arr[j];
					  arr[j]=temp1;
				  }
			  }
		  }
		  System.out.println(Arrays.toString(arr));
		  System.out.println(Arrays.toString(weight));
		  
	}

	private static int findWight(int n) {
		int weight=0;
		if(isPerfectSquare(n))
			weight+=5;
		
		 if(n%4==0 && n%6==0)
			 weight+=4;
		 
		 if(n%2==0)
			 weight+=3;
		 
		 return weight;
	}

	private static boolean isPerfectSquare(int n) {
		int sqrt=(int) Math.sqrt(n);
		return sqrt*sqrt==n;
	}
}