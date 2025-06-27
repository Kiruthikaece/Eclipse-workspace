package cheatsheat;

public class DynamicPgm {

	public static void main(String[] args) {
//		int[] nums= {1,2,3,1};
//		System.out.println(findRob1(nums)); 
		
//		int[] nums= {1,2,3};
//		System.out.println(findRob2(nums)); 
		
//		int m=3,n=7;
//		System.out.println(findUniquePath(m,n));
		
//		int[][] grid= {{1,2,3},{4,5,6}};
//		System.out.println(minimumPathSum(grid));
		
		int[] nums= {2,3,1,1,4};
		System.out.println(jumpGame2(nums));
	}

	private static int jumpGame2(int[] nums) {
		int distance=0,jump=0,end=0;
		
		for(int i=0;i<nums.length-1;i++) {
			distance=Math.max(distance, i+nums[i]);
			if(end==i) {
				end=distance;
				jump++;
			}
		}
		
		return jump;
	}

	private static int minimumPathSum(int[][] grid) {
		int row=grid.length;
		int col=grid[0].length;
		
		int[][] dp=new int[row][col];
		dp[0][0]=grid[0][0];
		
		for(int i=1;i<col;i++)
			dp[0][i]=grid[0][i]+dp[0][i-1];
		
		for(int i=1;i<row;i++)
			dp[i][0]=grid[i][0]+dp[i-1][0];
		
		for(int i=1;i<row;i++) {
			for(int j=1;j<col;j++) {
				dp[i][j]=grid[i][j]+Math.min(dp[i-1][j],dp[i][j-1]);
				
			}
			
		}
		
		return dp[row-1][col-1];
	}

	private static int findUniquePath(int m, int n) {
		int[][] dp=new int[m][n];
		
		
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(i==0 && j==0) {
					dp[i][j]=1;
					continue;
				}
				int up=0,left=0;
				
				if(i>0)
				up=dp[i-1][j];
				
				if(j>0)
				left=dp[i][j-1];
				
				dp[i][j]=up+left;
			}
		}
		return dp[m-1][n-1];
	}

	private static int findRob2(int[] nums) {
		int[] odd=new int[nums.length-1];
		int[] even=new int[nums.length-1];
		
		
		for(int i=0;i<nums.length-1;i++) {
			odd[i]=nums[i];
			even[i]=nums[i+1];
		}
		
		int res1=findRob1(odd);
		int res2=findRob1(even);
		
		return Math.max(res1, res2);
	}

	private static int findRob1(int[] nums) {
		   int[] dp=new int[nums.length];
		   dp[0]=nums[0];
		   
		   for(int i=1;i<nums.length;i++) {
			   int pick=nums[i];
			   if(i>1)
				   pick+=dp[i-2];
			   
			   int nonpick=dp[i-1];
			   dp[i]=Math.max(pick, nonpick);
		   }
		   
		   return dp[nums.length-1];
		   
	}

}
