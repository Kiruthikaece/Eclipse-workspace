package repeatedpractice;

public class Pattern {
    public static void main(String[] x) {
    	//pattern18();
    	//pattern17();
    	//pattern15();
    	//pattern12();
    	pattern9();
    }

	private static void pattern9() {
		int n=5;
		int sp=n;
		for(int i=1;i<n*2;i=i+2) {
			for(int k=1;k<=sp;k++)
				System.out.print(" ");
			for(int j=1;j<=i;j++)
				System.out.print("*");
			sp--;
			System.out.println();
		}
		
		for(int i=n*2-1;i>=1;i-=2) {
			for(int k=1;k<=sp+1;k++)
				System.out.print(" ");
			for(int j=1;j<=i;j++)
				System.out.print("*");
			sp++;
			System.out.println();
		}
	}

	private static void pattern12() {
		int sp=(2*4);
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=i;j++)
				System.out.print(j);
			for(int k=1;k<=sp;k++)
				System.out.print(" ");
			for(int j=i;j>=1;j--)
				System.out.print(j);
			System.out.println();
			sp-=2;
		}
	}

	private static void pattern15() {
		for(int i=5;i>=1;i--) {
			 for(int j=1;j<=i;j++) 
				 System.out.print((char)(64+j));
			 System.out.println();
		}
		
	}

	private static void pattern17() {
		  int n=5,sp=10;
		  
		  for(int i=1;i<=5;i++) {
			  for(int k=1;k<=sp;k++)
				  System.out.print(" ");
			  for(int j=1;j<=i;j++)
				  System.out.print((char)(64+j));
			  
			  for(int j=i-1;j>=1;j--)
				  System.out.print((char)(64+j));
			  System.out.println();
			  sp--;
		  }
	}

	private static void pattern18() {
		int n=5;
		int x=n;
		
		for(int i=1;i<=n;i++) {
			 for(int j=1;j<=i;j++) 
				 System.out.print((char)(64+x+j-1));
			 System.out.println();
			 x--;
		}
		
	}
}
