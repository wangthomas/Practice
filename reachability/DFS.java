import java.util.*;

public class DFS {
	public static void main(String []args){

		int[][] matrix = {{0, 1, 0, 0, 0},
						  {0, 1, 0, 1, 0},
						  {0, 1, 0, 1, 0},
						  {0, 1, 0, 1, 0},
						  {0, 1, 0, 1, 0},
						  {0, 0, 0, 1, 0}};

		System.out.println(isReachable(matrix));
	}

	static boolean isReachable(int[][] matrix) {
		return dfs(matrix, 0, 0);
	}

	static boolean dfs(int[][] matrix, int row, int col) {
		int rowSize = matrix.length;
		int colSize = matrix[0].length;

		if (row == rowSize - 1 && col == colSize - 1 && matrix[row][col] == 0) 
			return true;

		if (row < 0 || row >= rowSize || col < 0 || col >= colSize || matrix[row][col] != 0) 
			return false;

		matrix[row][col] = 2;

		return dfs(matrix, row - 1, col) || dfs(matrix, row + 1, col) || dfs(matrix, row, col - 1) || dfs(matrix, row, col + 1);
	}

}