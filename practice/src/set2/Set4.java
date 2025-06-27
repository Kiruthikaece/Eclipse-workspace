package set2;

import java.util.Arrays;

public class Set4 {

	public static void main(String[] args) {
		
		int[] arr= {8, 2, 3, 12, 16};
		sortFactors(arr);
		
		 int n=5;
		 countAndSay(n);
		 
		 int res=gasStation(new int[] {6,4,2},new 	int[] {1,5,3},2);
		 System.out.println(res);
		 
		 System.out.println();
		 int o=5,m=4;
		 printPattern(o,m);
	}

	private static void printPattern(int n, int m) {
		int top=0,bottom=n-1,left=0,right=m-1;
		char fill='X';
		
		char[][] board=new char[n][m];
		
		while(top<=bottom && left<=right) {
			
			for(int i=left;i<=right;i++)
				board[top][i]=fill;
			    top++;
			
			for(int i=top;i<=bottom;i++) 
				board[i][right]=fill;
				right--;
				
				if(top<=bottom) {
					for(int i=right;i>=left;i--)
						board[bottom][i]=fill;
					    bottom--;
				}
				
				if(left<=right) {
					for(int i=bottom;i>=top;i--)
						board[i][left]=fill;
					left++;
				}
			fill=(fill=='X')?'0':'X';
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++)
				System.out.print(board[i][j]);
			System.out.println();
		}
	}

	private static int gasStation(int[] gas, int[] distance, int startpertol) {
		int totalgas=0,totalDistance=0,currentPetrol=startpertol;
		
		for(int i=0;i<gas.length;i++) {
			totalgas+=gas[i];
			totalDistance+=distance[i];
			currentPetrol+=(gas[i]-distance[i]);	
			
			if(currentPetrol<0) 
				currentPetrol=0;
		}
		
		return currentPetrol;
	}

	private static void countAndSay(int n) {
		
		String res="1";
		for(int i=1;i<=5;i++) {
			System.out.println(res);
			res=pattern(res);
		}
	}

	private static String pattern(String s) {
		StringBuilder str=new StringBuilder();
		int count=1;
		
		for(int i=1;i<s.length();i++) {
			if(s.charAt(i)==s.charAt(i-1))
				count++;
			else {
				str.append(count).append(s.charAt(i-1));
				count=1;
			}
		}
		
		str.append(count).append(s.charAt(s.length()-1));
		return str.toString();
	}

	private static void sortFactors(int[] arr) {
		
		int[] countArr=new int[arr.length];
		for(int i=0;i<arr.length;i++) {
			int count=0;
			for(int j=0;j<arr.length;j++) {
				if(arr[i]%arr[j]==0)
					count++;
			}
			
			countArr[i]=count;
		}
		
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(countArr[i]<countArr[j]) {
					int temp=countArr[i];
					countArr[i]=countArr[j];
					countArr[j]=temp;
					
					int temp1=arr[i];
					arr[i]=arr[j];
					arr[j]=temp1;
				}
			}
		}
		
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(countArr));
		
	}

}
