package practice;

public class leetcode_213 {
       public static void main(String[] args)  {
    	  int[] arr= {2,3,2};
    	  int res=FindRobber(arr);
    	  System.out.println(res+"res");
       }
       public static int FindRobber(int[] nums) {
    	   int s1=0,s2=0;
    	   
    	   if(nums.length==0)
    	    return 0;
    	   if(nums.length==1)
    	    return nums[0];
    	   
    	   for(int i=0;i<nums.length-1;i++) {
    		   s1=s1+nums[i];
    		   
    		   s2=s2+nums[i+1];
    	   }
    	   
    	   return Math.min(s1, s2);
    	   
    	        
       }
}
