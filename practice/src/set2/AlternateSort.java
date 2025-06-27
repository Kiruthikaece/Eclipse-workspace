package set2;

import java.util.Arrays;

public class AlternateSort {

	public static void main(String[] args) {
		int[] arr= {1,2,3,4,5,6,7};
		withAlter(arr);
		
	}

	private static void withAlter(int[] arr) {
		 int[] res=new int[arr.length];
		 
		int left=0,right=arr.length-1,index=0;
		
		while(left<=right) {
			if(index%2==0) {
				res[index]=arr[right];
				right--;
			} else {
				res[index]=arr[left];
				left++;
			}
			index++;
		}
		
		System.out.println(Arrays.toString(res));
	}
}
