package cheatsheat;

import java.util.*;
import java.util.HashSet;
import java.util.Set;

public class ArraysPbm {

	public static void main(String[] args) {
		//int[] arr= {3,70,45,600,1000,90};
		
		
//		int res1=findThirdElement(arr);
//		System.out.println("Third Element:"+res1);
		
//		int[] arr1= {1,2,3,4,6};
//		int res2=missingNumber(arr1);
//		System.out.println("Missing number:"+res2);
//		
//		int[] arr2= {1,2,2,3,4};
//		int res3=repeatingNo(arr2);
//		System.out.println("repeating Number:"+res3);
		
//		int[] arr3= {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
//		int[] res4=sortArr(arr3);
//		System.out.println("sort Array:"+Arrays.toString(res4));
		
//		int[] arr4= {4,3,5,1,2};
//		int[] arr5= {1,2,3,4,5};
//		boolean res5=checkEquals(arr4,arr5);
//		System.out.println("Two Array are equals:"+res5);
		
//		int[] arr= {1,2,3,4,5};
//		int k=2;
//		int[] res6=rightRotate(arr,k);
//		System.out.println(Arrays.toString(res6));
		
//		int[] res7=leftrotate(arr,k);
//		System.out.println(Arrays.toString(res7));
		
//		int[] arr1= {4,3,5,1,2};
//		int[] arr2= {1,2,3,4,5};
//		boolean res8=isSubset(arr1,arr2);
//		System.out.println(res8);
		
//		int[] arr= {1, 2, 4, 3, 6};
//		int target=10;
//		boolean res9=twoSum(arr,target);
//		System.out.println("Two sum:"+res9);
		
//		int[] arr= {40, 20, 10, 3, 6, 7};
//		int target=67;
//		boolean res9=threeSum(arr,target);
//		System.out.println("Three sum:"+res9);
		
//		int[] arr= {2,2,2,2,2};
//		int target=8;
//		boolean res10=fourSum(arr,target);
//		System.out.println("Four sum:"+res10);
		
//		int[] arr= {3, 0, 1, 0, 4, 0 ,2};
//		int res11=trappingRainWater(arr);
//		System.out.println(res11);
		
//		int[] arr= {2,2,1,1,1,2,2};
//		int res12=MajorityElement(arr);
//		System.out.println("Majority element n/2:"+res12);
		
//		int[] arr= {-2,-4};
//		int res13=kadeneAlg(arr);
//		System.out.println("Max Sum:"+res13);
		
//		int[] arr= {-2, 6, -3, -10, 0, 2};
//		int res14=maxProdArr(arr);
//		System.out.println("Maximum product array:"+res14);
	
		int[][] arr= {{1,3},{2,4},{6,8},{9,10}};
	    mergeIntervals(arr);
		

		
		
	}

	

	public static int findThirdElement(int[] arr) {
		int first=Integer.MIN_VALUE,second=Integer.MIN_VALUE,third=Integer.MIN_VALUE;
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>=first) {
				third=second;
				second=first;
				first=arr[i];
			} else if(arr[i]>=second && arr[i]<=first) {
				third=second;
				second=arr[i];
			} else
				third=arr[i];
		}
		
		return third;
	}
	
	public static int missingNumber(int[] arr) {
		int n=arr.length;
		int sum1=n*(n+1)/2;
		int sum2=0;
		for(int i=0;i<n-1;i++)
			sum2+=arr[i];
		
		return sum1-sum2;
	}
	
	public static int repeatingNo(int[] arr) {
		Set<Integer> set=new HashSet<>();
		
		for(int num:arr) {
			if(set.contains(num))
				return num;
			set.add(num);
		}
			
		
		return -1;
	}
	
	public static int[] sortArr(int[] arr) {
		int[] hash=new int[3];
		for(int i=0;i<arr.length;i++)
			hash[arr[i]]++;
		
		int k=0;
		for(int i=0;i<3;i++) {
			for(int j=0;j<hash[i];j++) 
				arr[k++]=i;
		}
		
		return arr;
	}
	
	public static boolean checkEquals(int[] arr1,int[] arr2) {
		int xor=0,sum1=0,sum2=0;
		if(arr1.length!=arr2.length)
			return false;
		for(int i=0;i<arr1.length;i++) {
			sum1+=arr1[i];
			sum2+=arr2[i];
			xor=xor^arr1[i]^arr2[i];
		}
		
		return (xor==0 && sum1==sum2);
	}

	public static int[] rightRotate(int[] arr,int k) {
		int[] rotate=new int[arr.length];
		
		for(int i=0;i<arr.length;i++) {
			rotate[(i+k)%arr.length]=arr[i];
		}
		
		return rotate;  
	}
	
	public static int[] leftrotate(int[] arr,int k) {
		int target=k%arr.length;
		
		int[] res=new int[target];
		
		for(int i=0;i<target;i++)
		res[i]=arr[i];
		
		int ind=0;
		
		for(int i=target;i<arr.length;i++)
			arr[ind++]=arr[i];
		
		for(int i=0;i<target;i++)
			arr[ind++]=res[i];
		
		return arr;
	}
	
	private static boolean isSubset(int[] arr1, int[] arr2) {
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		
		int i=0,j=0,c=0;
		
		while(i<arr1.length && i<arr2.length) {
			if(arr1[i]==arr2[j]) {
				i++;
				j++;
				c++;
			}else
			 i++;
		}
		
		return c==arr2.length;
	}
	
	public static boolean twoSum(int[] arr,int target) {
		Map<Integer,Integer> map=new HashMap<>();
		
		for(int i=0;i<arr.length;i++) {
			if(map.containsKey(target-arr[i]))
				return true;
			
			map.put(arr[i], i);
		}
		
		return false;
	}
	
	public static boolean threeSum(int[] arr,int target) {
		  
		  
		  Arrays.sort(arr);
		  
		  for(int i=0;i<arr.length;i++) {
			  if(i!=0 && arr[i]==arr[i-1])
				  continue;
			  int j=i+1;
			  int k=arr.length-1;
			  
			  while(j<k) {
				  int sum=arr[i]+arr[j]+arr[k];
				  if(sum<target) {
					  j++;
				  }else if(sum>target)
					  k--;
				  else {
					  return true;
				  }
					  
			  }
		  }
		  
		  return false;
	}
	
	public static boolean fourSum(int[] arr,int target) {
		 Arrays.sort(arr);
		 
		 for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				int k=j+1;
				int l=arr.length-1;
				
				while(k<l) {
					int sum=arr[i]+arr[j]+arr[k]+arr[l];
					if(sum==target)
						return true;
					else if(sum<target)
						k++;
					else
						l--;
				}
			}
		 }
		 
		 return false;
	}
	

	private static int trappingRainWater(int[] arr) {
	   int leftmax=0,rightmax=0,left=0,right=arr.length-1,res=0;
	   
	     while(left<=right) {
	    	 if(arr[left]<arr[right]) {
	    		 if(arr[left]>leftmax)
	    			 leftmax=arr[left];
	    		 else
	    			 res+=leftmax-arr[left];
	    		 left++;
	    	 } else {
	    		 if(arr[right]>rightmax)
	    			 rightmax=arr[right];
	    		 else
	    			 res+=rightmax-arr[right];
	    		 right--;
	    	 }
	     }
	     
	     return res;
	}

	
	private static int MajorityElement(int[] arr) {
		int maxEle=0,count=0;
		
		for(int i=0;i<arr.length;i++) {
			if(count==0) {
				maxEle=arr[i];
			    count=1;
			}else if(maxEle==arr[i])
				count++;
			else
				count--;
				
		}
		
		return maxEle;
	}



	private static int kadeneAlg(int[] arr) {
		int sum=0,max=Integer.MIN_VALUE;
		int start=0,startInd=0,end=0;
		
		for(int i=0;i<arr.length;i++) {
			
			if(sum==0)
				startInd=i;
			
			sum+=arr[i];
			
			if(sum>max) {
				start=startInd;
				end=i;
				max=sum;
			}
				
			
			if(sum<0)
				sum=0;
		}
		
		System.out.println("from : "+start+"To:"+end);
		return max;
	}

	private static int maxProdArr(int[] arr) {
		int prefix=1,suffix=1,res=Integer.MIN_VALUE;
		
		for(int i=0;i<arr.length;i++) {
			if(prefix==0) prefix=1;
			if(suffix==0) suffix=1;
			
			prefix=prefix*arr[i];
			suffix=suffix*arr[arr.length-i-1];
			res=Math.max(res,Math.max(prefix,suffix));
			System.out.println("prefix.."+prefix+"..suffix "+suffix+"..res.."+res);
		}
		
		return res;
	}
	
	public static void mergeIntervals(int[][] arr) {
		
		Arrays.sort(arr,new Comparator<int[]>() {
			public int compare(int[] a,int[] b) {
				return a[0]-b[0];
			}
			
		});
		List<int[]> list=new ArrayList<>();
		
		int[] newInter=arr[0];
		list.add(newInter);
		
		for(int[] inter:arr) {
			if(inter[0]<newInter[1]) {
				newInter[1]=Math.max(inter[1],newInter[1]);
			}else {
				list.add(inter);
				newInter=inter;
			}
		}
		
		  int[][] res=list.toArray(new int[list.size()][]);
		  
		  for(int[] res1:res)
			  System.out.println(Arrays.toString(res1));
	}
}
