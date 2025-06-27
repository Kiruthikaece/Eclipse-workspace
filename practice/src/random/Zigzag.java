package random;

public class Zigzag {

	public static void main(String[] args) {
		printPattern("PAYPALISHIRING",4);
	}

	private static void printPattern(String s, int numRow) {
		int one=numRow*2-2;
		
		StringBuilder[] res=new StringBuilder[numRow];
		for (int i = 0; i < numRow; i++) {
            res[i] = new StringBuilder(); 
        }
		
		for(int i=0;i<numRow;i++) {
			
			int two=i*2;
			for(int j=i;j<s.length();j=j+one) {
				res[i].append(s.charAt(j));
				if(two>0 && two<one && (j+one)-two<s.length())
					res[i].append(s.charAt((j+one)-two));
			}
			
		}
		
		for(StringBuilder x:res)
			System.out.println(x);
	}

}
