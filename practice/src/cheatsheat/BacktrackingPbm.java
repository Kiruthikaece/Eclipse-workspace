package cheatsheat;

import java.util.*;

public class BacktrackingPbm {

	public static void main(String[] args) {
		
//		 String s="ABC";
//	     List<String> list=new ArrayList<>();
//	     boolean[] visit=new boolean[s.length()];
//	     StringBuilder str=new StringBuilder();
//	     permute(s,str,list,visit);
//	     System.out.println(list);
	     
	     int[] arr= {1,2,3};
	     List<Integer> list=new ArrayList<>();
	     List<List<Integer>> res=new ArrayList<>();
	     subset(0,arr,list,res);
	     System.out.println(res);
	     
	}

	private static void subset(int ind,int[] arr, List<Integer> list, List<List<Integer>> res) {
		if(ind==arr.length) {
			res.add(new ArrayList<>(list));
			return;
		}
		
		list.add(arr[ind]);
		subset(ind+1,arr,list,res);
		list.remove(list.size()-1);
		subset(ind+1,arr,list,res);
	}

	private static void permute(String s, StringBuilder str, List<String> res,boolean[] visit) {
		if(str.length()==s.length()) {
			res.add(str.toString());
			return;
		}
		
		for(int i=0;i<s.length();i++) {
			if(!visit[i]) {
				str.append(s.charAt(i));
				visit[i]=true;
				permute(s,str,res,visit);
				visit[i]=false;
				str.deleteCharAt(str.length()-1);
			}
		}
	}
	
	

}
