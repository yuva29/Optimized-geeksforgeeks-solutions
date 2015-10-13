package arrays;

public class MatrixRotation {

	public void printMatrix(int[][]  mat) {
		int m = mat.length;
		int n =  mat[0].length;
		for(int i = 0; i<m; i++){ 
			for(int j = 0; j<n; j++) {
				System.out.print(mat[i][j] + "\t");
			}
			System.out.println();
		}
	}
	
	public void rotateMatrix(int[][] mat) {
		int m = mat.length;
		int n =  mat[0].length;
		
		int startI = 0;
		int startJ = 0;
		int i = 0;
		while(startI<m && startJ<n) {
			int temp = mat[startI][startJ];
			
			//first col
			for(i = startI; i<m-1; i++) 
				mat[i][startJ] = mat[i+1][startJ];
			
			//last row
			for(i = startJ; i<n-1; i++)
				mat[m-1][i] = mat[m-1][i+1];
			
			// last col			
			for(i = m-1; i>startI; i--)
				mat[i][n-1] = mat[i-1][n-1];
			
			//first row
			for(i = n-1; i>startJ+1; i--) 
				mat[startI][i] = mat[startI][i-1];
			
			mat[startI][startJ+1] = temp;
			
			startI++;
			startJ++;
			n--;
			m--;			
		}
		printMatrix(mat);
	}
	public static void main(String[] args) {
		int[][] mat = {{1,2,3}, {4,5,6}, {7,8,9}};
	    int a[][] = { {1,  2,  3,  4},
	            {5,  6,  7,  8},
	            {9,  10, 11, 12},
	            {13, 14, 15, 16}  };	
		MatrixRotation mr = new MatrixRotation();
		mr.rotateMatrix(a);
	}
}
