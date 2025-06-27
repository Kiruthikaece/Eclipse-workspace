package BitManipulation;

public class AddBinary {

	public static void main(String[] args) {
		 String a="1010";
		 String b="1011";
		 
		 StringBuilder res=new StringBuilder();
		 int i=a.length()-1;
		 int j=b.length()-1;
		 int carry=0;
		 
		 while(i>=0 || j>=0) {
			 int sum=carry;
			 sum+=a.charAt(i)-'0';
			 sum+=b.charAt(i)-'0';
			 carry =sum>1?1:0;
			 res.append(sum%2);
			 i--;
			 j--;
		 }
		 
		 if(carry!=0)
			 res.append(carry);	 
		 
		 System.out.println(res.toString());
	}

}
