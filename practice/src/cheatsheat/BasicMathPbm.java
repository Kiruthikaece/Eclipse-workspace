package cheatsheat;

import java.util.Scanner;

public class BasicMathPbm {

	public static void main(String[] args) {
		  Scanner sc=new Scanner(System.in);
		  
//		  System.out.println("Enter number:");
//		  int num=sc.nextInt();
		  
		  //pbm-1
//		  boolean res1=findOddEven(num);
//		  System.out.println("Is Even:"+res1);
//		  
//		  System.out.println("Enter num1:");
//		  String num1=sc.next();
//		  System.out.println("Enter num2:");
//		  String num2=sc.next();
		  
		  //pbm-2
//		  int res2=getLastDigit(num1,num2);
//		  System.out.println("Last digit:"+res2);
	  
		  //pbm-3
//		  int res3=countDigits(num);
//		  System.out.println(res3);
		  
		  //pbm-4
//		  int res4=reverseDigits(num);
//		  System.out.println("reverse number:"+res4);
		  
		  //pbm-5
		  
//		  int res5=reverseExponentiation(num);
//		  System.out.println("power:"+res5);
		  
		  //pbm-6
		  
		  System.out.println("Enter num1:");
		  int num1=sc.nextInt();
		  System.out.println("Enter num2:");
		  int num2=sc.nextInt();
	  
//		  int res6=gcd(num1,num2);
//		  System.out.println("GCD:"+res6);
		  
//		  boolean res7=prime(num1);
//		  System.out.println("is prime number:"+res7);
		  
//		  boolean res8=armstrongNo(num1);
//		  System.out.println("Is Armstrong number:"+res8);
		  
//		  boolean res9=isPalindrome(num1);
//		  System.out.println("Is Palindrome number:"+res9);
		  
//		  int res10=squareRoot(num1);
//		  System.out.println("square Root:"+res10);
		  
//		  boolean res11=isPerfectNumber(num1);
//		  System.out.println("is perfect number:"+res11);
		  
		  
		  int res12=lcm(num1,num2);
		  System.out.println("LCM:"+res12);
	}

	private static boolean findOddEven(int num) {
		
		return num%2==0;
	}

	public static int getLastDigit(String a, String b) {
        
        if(b.equals("0"))
        return 1;
      
       int n2=Integer.parseInt(b);
       int base=a.charAt(a.length()-1)-'0';
       int power=(n2%4==0)?4:n2%4;
       
       int res=(int)Math.pow(base,power)%10;
       
       return res;
    }
	
	public static int countDigits(int n) {
		int x=n;
		
		int count=0;
		
		while(x!=0) {
			int d=x%10;
			if(n%d==0)
				count++;
			x=x/10;
		}
		
		return count;
	}
	
	  public static int reverseDigits(int n) {
	        
	        int x=n,sum=0;
	        while(n!=0) {
	            int d=n%10;
	            if(d!=0)
	            sum=sum*10+d;
	            n=n/10;
	        }
	        
	        return sum;
	    }
	  
	  public static int reverseExponentiation(int n) {
	       int pow=0,x=n;
	       while(x!=0) {
	           int d=x%10;
	           if(d!=0)
	           pow=pow*10+d;
	           x=x/10;
	       }
	       
	       return (int)Math.pow(n,pow);
	    }
	  
	  public static int gcd(int a,int b) {
		  if(b==0)
			  return a;
		  else {
			  System.out.println(a+".."+b);
			  return gcd(b,a%b);
		  }
	  }
	  
	  public static boolean prime(int n) {
		  for(int i=2;i<=n/2;i++) {
			  if(n%i==0)
				  return false;
		  }
		  
		  return true;
	  }
	  
	  public static boolean armstrongNo(int num) {
		  
		  if(num<100 && num>=1000)
			  return false;
		  int sum=0,n=num;
		  while(n!=0) {
			  int d=n%10;
			  sum+=Math.pow(d,3);
			  n=n/10;
		  }
		  
		  return sum==num;
	  }
	  
	  public static boolean isPalindrome(int n) {
	         int rev=n,sum=0;
	         
	         while(rev!=0) {
	             int d=rev%10;
	             sum=sum*10+d;
	             rev=rev/10;
	         }
	         
	         return sum==n;
	    }
	  
	  public static int squareRoot(int n) {
	        
	        int i=1;
	        
	        while(i*i<=n) {
	            i++;
	        }
	        
	        return i-1;
	    }
	  
	  static boolean isPerfectNumber(int n) {
	       int sum=1;
	       for(int i=2;i<=Math.sqrt(n);i++) {
	           if(n%i==0) {
	               if(n/i==i)
	               sum+=i;
	               else {
	                   sum+=i;
	                   sum+=n/i;
	               }
	           }
	       }
	       
	       if(sum==n && n!=1 )
	       return true;
	       
	       return false;
	    }
	  
	  static int lcm(int a,int b) {
		  int small=Math.min(a, b);
		  int big=Math.max(a, b);
		  int lcm=0;
		  for(int i=big;;i=i+big) {
			  if(i%small==0) {
				  lcm=i;
				  break;
			  }
		  }
		  
		  return lcm;
	  }
}
