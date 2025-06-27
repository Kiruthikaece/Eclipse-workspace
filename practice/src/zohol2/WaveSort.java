package zohol2;

import java.util.Arrays;

public class WaveSort {

	public static void main(String[] args) {
		int[] arr= {2,4,8,10,20,30,12};
		Arrays.sort(arr);
		
		for(int i=1;i<arr.length;i+=2) {
			int temp=arr[i-1];
			arr[i-1]=arr[i];
			arr[i]=temp;
		}
		System.out.println(Arrays.toString(arr));
	}

}
