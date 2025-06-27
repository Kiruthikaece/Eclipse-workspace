package practice;

import java.util.Scanner;

public class WordSearch {
	
	 int startR;
	 int startC;
	 int endR;
	 int endC;

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter word:");
		String word=sc.next();
		
		char[][] mat= {{'w','e','l','c','o'},{'m','e','t','o','z'},{'o','h','o','c','o'},{'r','p','o','r','a'},{'t','i','o','n'}};
		
		new WordSearch().findWord(word,mat);
		
		
	}

	private  void findWord(String word, char[][] mat) {
		
		int row=mat.length;
		for(int i=0;i<mat.length;i++) {
			int col=mat[i].length;
			for(int j=0;j<mat[i].length;j++) {
				if(backtrack(i,j,row,col,mat,word,0)) {
		
					startR=i;
					startC=j;
					
					System.out.println("Start: (" + startR + ", " + startC + ")");
                    System.out.println("End: (" + endR + ", " + endC + ")");
                    return;
				}
			}
		}
	}

	private  boolean backtrack(int i,int j,int row,int col,char[][] mat,String word,int ind) {
		  
		 if (ind == word.length()) {
	            return true;
	        }

	        
	        if (i < 0 || j < 0 || i >= row || j >= col || mat[i][j] != word.charAt(ind)) {
	            return false;
	        }

	        

	        
	        boolean found = backtrack(i + 1, j, row, col, mat, word, ind + 1) || 
	                        backtrack(i - 1, j, row, col, mat, word, ind + 1) ||
	                        backtrack(i, j + 1, row, col, mat, word, ind + 1) || 
	                        backtrack(i, j - 1, row, col, mat, word, ind + 1);

	        
	       
	        if (found && ind == word.length() - 1) {
	            endR = i;
	            endC = j;
	        }

	        return found;
	}

	    
	
}
