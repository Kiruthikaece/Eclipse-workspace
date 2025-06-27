package cheatsheat;

public class MatrixPbm {

	public static void main(String[] args) {
		int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
		boolean res1=search(matrix,38);
		System.out.println(res1);
	}

	private static boolean search(int[][] matrix, int target) {
		int i=0,j=matrix.length-1;
		
		while(i<matrix.length &&j>=0) {
			int mid=matrix[i][j];
			if(mid==target)
				return true;
			else if(matrix[i][j]<target)
				i++;
			else
				j--;
		}
		
		return false;
	}

}
