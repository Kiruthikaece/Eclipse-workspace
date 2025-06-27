package repeatedpractice;

public class HasingPbm {

	public static void main(String[] args) {
		
		int[] arr=  {10,5,10,15,10,5};
		countFreq(arr);

	}

	private static void countFreq(int[] arr) {
		
		int max=Integer.MIN_VALUE;
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>max)
				max=arr[i];
		}
		
		int[] count=new int[max+1];
		
		for(int i=0;i<arr.length;i++) {
			count[arr[i]]++;
		}
		
		int maxE=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
		int maxI=0,minI=0;
		for(int i=0;i<count.length;i++) {
			if(count[i]>maxE) {
				maxE=count[i];
				maxI=i;
			}
			
			if(count[i]!=0 && count[i]<min) {
				min=count[i];
				minI=i;
			}
		}
		
		System.out.println("MAX:"+maxI);
		System.out.println("Min:"+minI);
		
	}

}
