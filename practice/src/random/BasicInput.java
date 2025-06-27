package random;

public class BasicInput {

	public static void main(String[] args) {
		int x=Integer.parseInt(args[0]);
		int y=Integer.parseInt(args[1]);
		
		float z= (x*x)/(2*x-y);
		
		System.out.println("z value="+z);
	}

}
