package Pattern;

public class Pattern {

	public static void main(String[] args) {
		Pattern p1=new Pattern();
		p1.pattern1();
		System.out.println("--------------");
		p1.pattern2();
		System.out.println("--------------");
		p1.pattern3();
		System.out.println("--------------");
		p1.pattern4();
		System.out.println("--------------");
		p1.pattern5();
		System.out.println("--------------");
		p1.pattern6();
		System.out.println("--------------");
		p1.pattern7();
		System.out.println("--------------");
		p1.pattern8();
		System.out.println("--------------");
		p1.pattern9();
		System.out.println("--------------");
		p1.pattern10();
		System.out.println("--------------");
		p1.pattern11();
		System.out.println("--------------");
		p1.pattern12();
		System.out.println("--------------");
		p1.pattern13();
		System.out.println("--------------");
		p1.pattern14();
		System.out.println("--------------");
		p1.pattern15();
		System.out.println("--------------");
		p1.pattern16();
		System.out.println("--------------");
		p1.pattern17();
		System.out.println("--------------");
		p1.pattern18();
		System.out.println("--------------");
		p1.pattern19();
		System.out.println("--------------");
		p1.pattern20();
		System.out.println("--------------");
		p1.pattern21();
		System.out.println("--------------");
		p1.pattern22();
	}
	
	

	public void pattern1() {
		int n=6;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) 
				System.out.print("* ");
			System.out.println();
		}
	}
	
	public void pattern2() {
		int n=5;
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=i;j++)
				System.out.print("* ");
			System.out.println();
		}
	}
	
	private void pattern3() {
		int n=6;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=i;j++)
				System.out.print(j+" ");
			System.out.println();
		}
	}
	
	private void pattern4() {
		int n=6;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=i;j++) 
				System.out.print(i+" ");
			System.out.println();
		}
	}
	
	public void pattern5() {
		int n=5;
		for(int i=n;i>=1;i--) {
			for(int j=1;j<=i;j++)
				System.out.print("* ");
			System.out.println();
		}
	}
	
	public void pattern6() {
		int n=5;
		for(int i=n;i>=1;i--) {
			for(int j=1;j<=i;j++)
				System.out.print(j+" ");
			System.out.println();
		}
	}
	
	private void pattern7() {
		
		int n=5,sp=n,l=1;
		
		for(int i=1;i<=n;i++) {
			for(int k=1;k<=sp;k++)
				System.out.print(" ");
			for(int j=1;j<=l;j++)
				System.out.print("*");
			System.out.println();
			l+=2;
			sp--;
		}
	}
	
	public void pattern8() {
		 int n=5,sp=1;
		 
		 for(int i=n;i>=1;i--) {
			 for(int k=1;k<=sp;k++)
				 System.out.print(" ");
			 for(int j=1;j<=2*i-1;j++)
				 System.out.print("*");
			     System.out.println();
			     sp++;
		 }
	}
	
	public void pattern9() {
		int n=9,sp=9;
		for(int i=0;i<n;i++) {
			for(int k=1;k<=sp;k++)
				System.out.print(" ");
			for(int j=0;j<2*i+1;j++)
				System.out.print("*");
			    System.out.println();
			    sp--;
		}
		sp=1;
		for(int i=n-1;i>=0;i--) {
			for(int k=1;k<=sp;k++)
				System.out.print(" ");
			for(int j=1;j<=2*i+1;j++)
				System.out.print("*");
			System.out.println();
			sp++;
		}
	}
	
	public void pattern10() {
		int n=5;
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=i;j++)
				System.out.print("*");
			System.out.println();
		}
		
		for(int i=n-1;i>0;i--) {
			for(int j=1;j<=i;j++)
				System.out.print("*");
			System.out.println();
		}
	}
	
	

	private void pattern11() {
		for(int i=1;i<=5;i++) {
			if(i%2!=0) {
				for(int j=1;j<=i;j++)  
					if(j%2!=0)
					System.out.print("1");
					else
					System.out.print("0");	
				
					
			}else {
				for(int j=1;j<=i;j++)  
					if(j%2!=0)
					System.out.print("0");
					else
					System.out.print("1");	
			}
			
			System.out.println();
		}
	}
	
	public void pattern12() {
		int sp=2*(5-1);
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
	
	public void pattern13() {
		int n=1;
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=i;j++)
				System.out.print(n++ +" ");
			System.out.println();
		}
	}
	
	public void pattern14() {
		char ch='A';
		for(int i=1;i<6;i++) {
			for(int j=1;j<=i;j++)
				System.out.print((char)(ch+j-1) +" ");
			System.out.println();
		}
	}
	
	public void pattern15() {
		char ch='A';
		
		for(int i=5;i>=1;i--) {
			for(int j=1;j<=i;j++) 
				System.out.print((char)(ch+j- 1)+" ");
			System.out.println();
		}
	}
	
	public void pattern16() {
		char ch='A';
		
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=i;j++) 
				System.out.print((char)(ch+i- 1)+" ");
			System.out.println();
		}
	}
	
	public void pattern17() {
		char ch='A',sp=5;
		
		for(int i=0;i<5;i++) {
			for(int k=1;k<=sp;k++) 
				System.out.print(" ");
			for(int j=0;j<=i;j++)
				System.out.print((char)(ch+j));
			for(int j=i-1;j>=0;j--)
				System.out.print((char)(ch+j));
			    System.out.println();
			    sp--;
		}
	}
	
	public void pattern18() {
		char ch='A';
		for(int i=5;i>=1;i--) {
			for(int j=i;j<=5;j++)
				System.out.print((char)(ch+j-1));
			System.out.println();
		}
	}
	
	public void pattern19() {
		 int sp=0;
		for(int i=5;i>=1;i--) {
			for(int j=1;j<=i;j++)
				System.out.print("*");
			for(int k=1;k<=sp;k++)
				System.out.print(" ");
			for(int j=1;j<=i;j++)
				System.out.print("*");
			System.out.println();
			sp+=2;
		}
		sp=8;
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=i;j++)
				System.out.print("*");
			for(int k=1;k<=sp;k++)
				System.out.print(" ");
			for(int j=1;j<=i;j++)
				System.out.print("*");
			System.out.println();
			sp-=2;
		}
	}
	
	public void pattern20() {
		int n=5,sp=8;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=i;j++)
				System.out.print("*");
			for(int k=1;k<=sp;k++)
				System.out.print(" ");
			for(int j=1;j<=i;j++)
				System.out.print("*");
			System.out.println();
			sp-=2;
		}
		sp=2;
		for(int i=n-1;i>=1;i--) {
			for(int j=1;j<=i;j++)
				System.out.print("*");
			for(int k=1;k<=sp;k++)
				System.out.print(" ");
			for(int j=1;j<=i;j++)
				System.out.print("*");
			System.out.println();
			sp+=2;
			
		}
	}
	 public void pattern21() {
		 int n=3;
		 
		 for(int i=0;i<n;i++) {
			 for(int j=0;j<n;j++)
				 if(i==0 || i==n-1)
					 System.out.print("*");
				 else if(j==0 || j==n-1)
					 System.out.print("*");
				 else
					 System.out.print(" ");
			 System.out.println();
		 }
	 }
	 
	 
	 public void pattern22() {
		    int n = 4;
		    int left = 0, right = n * 2 - 2, top = 0, bottom = n * 2 - 2;
		    int[][] mat = new int[n * 2 - 1][n * 2 - 1];

		    while (left <= right && top <= bottom) {

		        for (int i = left; i <= right; i++)
		            mat[top][i] = n;
		        top++;

		        for (int i = top; i <= bottom; i++)
		            mat[i][right] = n;
		        right--;

		        if (top <= bottom) {
		            for (int i = right; i >= left; i--)
		                mat[bottom][i] = n;
		            bottom--;
		        }

		        if (left <= right) {
		            for (int i = bottom; i >= top; i--)
		                mat[i][left] = n;
		            left++;
		        }
		        n--;
		    }

		    for (int i = 0; i < mat.length; i++) {
		        for (int j = 0; j < mat[i].length; j++)
		            System.out.print(mat[i][j] + " ");
		        System.out.println();
		    }
		}

}
