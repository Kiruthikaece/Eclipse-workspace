package repeatedpractice;

public class ArraysPbm {

	public static void main(String[] args) {
		
		 // largestElement();
		    
		    secondLargestElement();

	}

	private static void secondLargestElement() {
		int[] arr= {1,2,4,7,7,5};
		
	}

	private static void largestElement() {
		int[] arr= {8,10,5,7,9};
		int max=arr[0];
		for(int i=1;i<arr.length;i++) {
			if(arr[i]>max) 
				max=arr[i];
		}
		
		System.out.println("MAX:"+max);
	}

}
