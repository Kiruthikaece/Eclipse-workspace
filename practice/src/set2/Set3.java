package set2;

import java.util.*;

public class Set3 {

	public static void main(String[] args) {
		String s="b3c6d15";
		expandString(s);
		
		System.out.println();
		int[] arr= {1,2,3,4,5,6,7,8,9};
		sort(arr);
		
		System.out.println();
		String str="program";
		pattern(str);
		
		System.out.println();
		String input1="test123string";
		String input2="1234";
		int res=isSubstring(input1,input2);
		System.out.println(res);
		
		
		System.out.println();
		int[] arr1= {2,4,5,6,7,9,10,13};
		int[] arr2= {2,3,4,5,6,7,8,9,11,15};
		sortUnique(arr1,arr2);
		
		String input="I love india";
		reverseString(input);
	}

	private static void reverseString(String s) {
		  
		  int n=s.length();
		  int count=0;
		  for(int i=n-1;i>=0;i--) {
			  
			  if(s.charAt(i)==' ' ||i==0) { 
				  int start=(i==0) ? 0:i+1;
				 for(int k=start;k<=i+count;k++) 
					  System.out.print(s.charAt(k));
				  System.out.print(" ");
				  count=0;
			  } else
				  count++;
		  }
	}

	private static void sortUnique(int[] arr1, int[] arr2) {
		int n=arr1.length;
		int m=arr2.length;
		int i=0,j=0;
		
		List<Integer> res=new ArrayList<>();
		int ind=0;
		
		while(i<n && j<m) {
			if(arr1[i]<arr2[j]) {
				if(res.size()==0|| arr1[i]!=res.get(res.size()-1))
					res.add(arr1[i]);
				i++;
			} else {
				if(res.size()==0|| arr2[j]!=res.get(res.size()-1))
					res.add(arr2[j]);
				j++;
			}
		}
		
		while(i<n) {
			if(arr1[i]!=res.get(res.size()-1))
				res.add(arr1[i]);
			   i++;
		}
		
		while(j<m) {
			if(arr2[j]!=res.get(res.size()-1))
				res.add(arr2[j]);
			   j++;
		}
		
		System.out.println(Arrays.toString(res.toArray()));
	}

	private static int isSubstring(String input1, String input2) {
		  if(input2.contains(input2)) {
			  return input1.indexOf(input2);
		  }
		  
		  return -1;
	}

	private static void pattern(String str) {
		int n=str.length();
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				
				if(i==j)
					System.out.print(str.charAt(i));
				else if((n-i-1)==j)
					System.out.print(str.charAt(n-i-1));
				else
					System.out.print(" ");
			}
			System.out.println();
		}
	}

	private static void sort(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			if(i%2==0) {
				for(int j=i;j<arr.length;j=j+2) {
					for(int k=i+2;k<arr.length;k=k+2) {
						if(arr[j]<arr[k]) {
							int temp=arr[j];
							arr[j]=arr[k];
							arr[k]=temp;
						}
					}
				}
			} else {
				for(int j=i;j<arr.length;j=j+2) {
					for(int k=i+2;k<arr.length;k=k+2) {
						if(arr[j]>arr[k]) {
							int temp=arr[j];
							arr[j]=arr[k];
							arr[k]=temp;
						}
					}
				}
			}
			
		}
		
		System.out.println(Arrays.toString(arr));
	}

	private static void expandString(String s) {
		
		
		for(int i=0;i<s.length();i++) {
			char ch=s.charAt(i);
			if(Character.isDigit(ch) && i>0) {
				char c=s.charAt(i-1);
				int count=ch-'0';
				
				while(i+1<s.length() && Character.isDigit(s.charAt(i+1))) {
					i++;
					count=count*10+(s.charAt(i)-'0');
					
				}
				
				
				for(int k=0;k<count;k++) {
					System.out.print(c);
				}
			}
			
			
		}
	}

}
