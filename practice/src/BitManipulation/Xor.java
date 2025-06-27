package BitManipulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Xor {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter n:");
		int n=sc.nextInt();
		
		int res1=computeXor(n);
		System.out.println(res1);
		
		int res2=countNumbers(n);
		System.out.println(res2);
		
		boolean res3=PowerOf2(n);
		System.out.println(res3);
		
		int res4=XorSubsets(new int[] {1,2,3,4,5});
		System.out.println(res4);
		
		findLeadingAndTrailingAndCountOnes(n);
		
		swapNumber(10,8);
	}
	
	private static void swapNumber(int no1, int no2) {
		
		  System.out.println("Before swap:");
		  System.out.println("First number:"+no1);;
		  System.out.println("Second number:"+no2);
		  no1=no1^no2;
		  no2=no1^no2;
		  no1=no1^no2;
		  System.out.println("After swap:");
		  System.out.println("First number:"+no1);;
		  System.out.println("Second number:"+no2);
	}

	private static int computeXor(int n) {
		if(n%4==0)
			return n;
		else if(n%4==1)
			return 1;
		else if(n%4==2)
			return n+1;
		else
			return 0;
	}

    private static int countNumbers(int n) {
    	 int unset_bits = 0;
    	    while (n > 0)
    	    {
    	      if ((n & 1) == 0)
    	        unset_bits++;
    	      n = n>>1;
    	    }

    	    
    	    return 1 << unset_bits;
				
	}
    
    private static boolean PowerOf2(int n) {
		if(n<=0)
			return false;
		
		return ((n&n-1)==0);
	}

    private static int XorSubsets(int[] arr) {
		if(arr.length==1)
			return arr[0];
		else
			return 0;
	}
    
    private static void findLeadingAndTrailingAndCountOnes(int n) {
		int leadingZeros=Integer.numberOfLeadingZeros(n);
		System.out.println("leadingZeros"+leadingZeros);
		
		int trailingZeros=Integer.numberOfTrailingZeros(n);
		System.out.println("trailingZeros"+trailingZeros);
		
		int ones=Integer.bitCount(n);
		System.out.println("Ones count:"+ones);
	}


}

class GFG {

  public static void main(String[] args) throws IOException {
      BufferedReader br =
          new BufferedReader(new InputStreamReader(System.in));
      int t = Integer.parseInt(br.readLine().trim());
      while (t-- > 0) {
          System.out.println(
              new Solution().infixToPostfix(br.readLine().trim()));
      }
  }
}
//} Driver Code Ends


class Solution {
  // Function to convert an infix expression to a postfix expression.
  public static String infixToPostfix(String exp) {
      Stack<Character> stack=new Stack<>();
      StringBuilder str=new StringBuilder();
      
      for(int i=0;i<exp.length();i++) {
          char ch=exp.charAt(i);
          if(Character.isAlphabetic(ch))
          str.append(ch);
          else if(ch==')'){
              while(!stack.isEmpty() && stack.peek()=='(') 
                  str.append(stack.pop());
              
              stack.pop();
          } else {
              if(!stack.isEmpty() && (stack.peek()=='*' || stack.peek()=='\\' || stack.peek()=='^')) {
                 while(!stack.isEmpty() && (stack.peek()=='-' || stack.peek()=='+'))
                 str.append(stack.pop());
              } 
              stack.push(ch);
          }
      }
      
      return str.toString();
  }
}
