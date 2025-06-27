package round2;

import java.util.*;

public class LuckyNumber {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter n");
		int n=sc.nextInt();
		
		int res=getLuckyNo(n,0,1);
		System.out.println(res);
	}

	private static int getLuckyNo(int n,int ind,int no) {
		
		
		
		if(checkisLucky(no))
			ind++;
		
		if(ind==n) 
			return no;
		
		
		
		
		
		  return getLuckyNo(n,ind,no+1);
     }

	private static boolean checkisLucky(int i) {
		int x=i;
		
		while(x!=0) {
			int d=x%10;
			if(d==3 || d==4)
				return true;
			x=x/10;
		}
		
		return false;
	}


}
