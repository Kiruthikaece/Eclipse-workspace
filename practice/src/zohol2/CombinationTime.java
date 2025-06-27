package zohol2;

import java.util.*;

public class CombinationTime {

	public static void main(String[] args) {
		String s="19:24";
		int sum=0,i=0;
		
		while(i<s.length()) {
			char ch=s.charAt(i);
			if(Character.isDigit(ch))
				sum=sum*10+ch-'0';
			i++;
		}
		
		String ip=String.valueOf(sum);
		boolean[] arr=new boolean[ip.length()];
		List<String> list=new ArrayList<>();
		StringBuilder str=new StringBuilder();
		printCombination(ip,arr,list,str);
		
		Collections.sort(list);
		System.out.println(list);
		
		for(int j=0;j<list.size();j++) {
			if(Integer.parseInt(list.get(j))>sum) {
				System.out.println("res:"+Integer.parseInt(list.get(j)));
				break;
			}
		
		}
			
		
	}

	private static void printCombination(String ip, boolean[] arr, List<String> list,StringBuilder str) {
			
		    if(str.length()==ip.length()) {
		    	list.add(str.toString());
		    	return;
		    }
		    
		    for(int i=0;i<ip.length();i++) {
		    	if(!arr[i]) {
		    		str.append(ip.charAt(i));
		    		arr[i]=true;
		    		printCombination(ip,arr,list,str);
		    		str.deleteCharAt(str.length()-1);
		    		arr[i]=false;
		    	}
		    }
		    
	}
	
	

}
