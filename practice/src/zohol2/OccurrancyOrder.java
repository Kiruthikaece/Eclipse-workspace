package zohol2;

import java.util.Arrays;

public class OccurrancyOrder {

	public static void main(String[] args) {
		int[] arr= {4,2,2,4,3,2,1,2,3,4,4,3};
		int[] count=new int[arr.length];
		
		for(int i=0;i<arr.length;i++) {
			int cou=1;
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]==arr[j]) {
					arr[j]=-1;
					cou++;
				}
			}
			if(arr[i]!=-1)
				count[i]=cou;
		}
		
		for(int i=0;i<count.length;i++) {
			for(int j=i+1;j<count.length;j++) {
				
				if(count[i]==count[j]) {
					if(arr[i]>arr[j]) {
						int temp=count[i];int temp1=arr[i];
						count[i]=count[j];arr[i]=arr[j];
						count[j]=temp;arr[j]=temp1;
					}
				}
				else if(count[i]<count[j]) {
					int temp=count[i];int temp1=arr[i];
					count[i]=count[j];arr[i]=arr[j];
					count[j]=temp;arr[j]=temp1;
				}
			}
		}
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<count[i];j++) 
				System.out.print(arr[i]+" ");
		}
		//System.out.println(Arrays.toString(count));
	}

}
