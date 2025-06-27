package set2;

import java.util.Stack;

public class RemoveInvalidParenthesis {

	public static void main(String[] args) {
		String s="((abc)((de))";
		
		Stack<Integer> stack=new Stack<>();
		
		boolean[] isvalid=new boolean[s.length()];
		
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='(') {
				stack.push(i);
			} else if(s.charAt(i)==')'){
				if(!stack.isEmpty()) 
				{
					isvalid[stack.pop()]=true;
					isvalid[i]=true;
				}
					
			}else 
				isvalid[i]=true;
		}
		
		
		StringBuilder str=new StringBuilder();
		
		for(int i=0;i<s.length();i++) {
			if(isvalid[i])
				str.append(s.charAt(i));
		}
		
		
		System.out.println(str);
	}

}
