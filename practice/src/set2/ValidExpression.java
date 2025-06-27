package set2;

import java.util.Stack;

public class ValidExpression {

	public static void main(String[] args) {
		String s="(a+b)";
		System.out.println(checkValid(s));
		
	}
	public static boolean checkValid(String s) {
		Stack<Integer> stack=new Stack<>();
		boolean[] visit=new boolean[s.length()];
		
		for(int i=0;i<s.length();i++) {
			char ch=s.charAt(i);
			  if(ch=='(')
				  stack.push(i);
			  else if(ch==')') {
				  if(stack.isEmpty()) {
					 return false;
				  }
				  stack.pop();
			  }else if(ch=='+' || ch=='-' ||ch=='*' ||ch=='/') {
				  if(i==0 || i==s.length()-1 || s.charAt(i-1)=='(' || s.charAt(i)==')')
					  return false;
			  }
			
		}
		
		 if (!stack.isEmpty()) {
	            return false;
	        }

	        return true;
	}

}
