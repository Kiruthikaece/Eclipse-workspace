package round2;
import java.util.*;

public class finaCombinations {

	public static void main(String[] args) {
//	     int[] arr= {5,1,8,3,9,2};
//	     int N=11;
	     
		 Scanner sc=new Scanner(System.in);
		 
		 System.out.println("Enter array length");
		 int n=sc.nextInt();
		 int[] arr=new int[n];
		 
		 System.out.println("Enter array elements:");
		 for(int i=0;i<n;i++)
		 arr[i]=sc.nextInt();
		 
		 System.out.println("Enter target:");
		 int N=sc.nextInt();
		 
	     List<List<Integer>> res=new ArrayList<>();
	     List<Integer> list=new ArrayList<>();
	     findCombinations(arr,res,list,0,N);
	     System.out.println(res);
	}

	private static void findCombinations(int[] arr, List<List<Integer>> res, List<Integer> list, int ind,int target) {
		if(ind==arr.length) {
			if(checkCombination(list,target))
				res.add(new ArrayList<>(list));
			return;
		}
		
		list.add(arr[ind]);
		findCombinations(arr,res,list,ind+1,target);
		list.remove(list.size()-1);
		findCombinations(arr,res,list,ind+1,target);
	}

	private static boolean checkCombination(List<Integer> list,int target) {
		int sum=0;
		
		for(int i=0;i<list.size();i++)
			sum+=list.get(i);
		
		return sum==target;
	}

}
