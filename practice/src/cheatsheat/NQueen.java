package cheatsheat;

import java.util.*;

public class NQueen {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter n");
		int n=sc.nextInt();
		char[][] board=new char[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++)
				board[i][j]='.';
		}
		
		List<List<String>> res=new ArrayList<>();
		List<String> list=new ArrayList<>();
		dfs(0,board,res,list);
		System.out.println(res);
	}
	
	public static void dfs(int col,char[][] board,List<List<String>> res,List<String> list) {
		if(col==board.length) {
			res.add(construct(board));
			return;
		}
		
		for(int row=0;row<board.length;row++) {
			if(check(row,col,board)) {
				board[row][col]='Q';
				dfs(col+1,board,res,list);
				board[row][col]='.';
			}
		}
	}
	
	private static List<String> construct(char[][] board) {
		List<String> list=new ArrayList<>();
		
		for(int i=0;i<board.length;i++) {
			String s=new String(board[i]);
			list.add(s);
		}
		
		return list;
	}

	public static boolean check(int row,int col,char[][] board) {
		 int newRow=row,newCol=col;
		 
		 while(col>=0) {
			 if(board[row][col]=='Q')
					 return false;
			 col--;
		 }
		 
		 col=newCol;
		 
		 
		 while(row>=0 && col>=0) {
			 if(board[row][col]=='Q')
				 return false;
			 row--;
			 col--;
		 }
		 
		 row=newRow;
		 col=newCol;
		 
		 while(row<board.length && col>=0) {
			 if(board[row][col]=='Q')
				 return false;
			 row++;
			 col--;
		 }
		 
		 return true;
	}

}
