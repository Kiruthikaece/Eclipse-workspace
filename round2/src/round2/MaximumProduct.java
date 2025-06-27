package round2;

import java.util.Scanner;

public class MaximumProduct {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
//		System.out.println("Enter row:");
//		int row=sc.nextInt();
//		System.out.println("Enter col:");
//		int col=sc.nextInt();
//		
//		int[][] mat=new int[row][col];
//		
//		for(int i=0;i<row;i++) {
//			for(int j=0;j<col;j++)
//				mat[i][j]=sc.nextInt();
//		}
//		
//		System.out.println("Enter k");
//		int k=sc.nextInt();
		
		int[][] mat= {{1,2,0,-1,4},{3,1,2,4,6},{0,2,3,1,4},{1,3,2,0,7},{2,1,3,2,9}};
		int k=4;
		
		 System.out.println(findMaxProduct(mat,k));
		 
		 
	   }

	private static int  findMaxProduct(int[][] mat,int k) {
		
		int max=Integer.MIN_VALUE;
		
		    for(int i=0;i<mat.length;i++) {
		    	for(int j=0;j<mat[0].length;j++) {
		    		int res=checkMax(mat,i,j,k);
		    		if(res>max)
		    			max=res;
		    	}
		    }
		    
		    return max;
	}

	private static int checkMax(int[][] mat, int row, int col, int k) {
		int sum1=1,sum2=1;
		  
		for(int i=0;i<mat[0].length;i++) {
			int s1=sum1;sum1=1;
			for(int j=i;j<k+i;j++) {
				if(k+i>mat[0].length)
					break;
				sum1*=mat[row][j];
			}
			 sum1=Math.max(sum1,s1); 
		 }
		
		for(int i=0;i<mat.length;i++) {
			int s2=sum2;sum2=1;
			for(int j=i;j<k+i;j++) {
				if(k+i>mat.length)
					break;
				sum2*=mat[j][col];
			}
			 sum2=Math.max(sum2,s2); 
		 }
		
//		for(int i=0;i<k;i++) {
//			sum3*=mat[i][i];
//		}
//		
		
		System.out.println(sum1+".."+sum2+"..."+row+"row"+col+"..col");
		return Math.max(sum1,sum2);
			   
	}
	
	
}