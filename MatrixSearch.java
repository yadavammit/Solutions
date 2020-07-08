
public class MatrixSearch {
	private int[][] matrix;
	private int target;

	public static void main(String[] args) {
		MatrixSearch ms = new MatrixSearch();
		int[][] matrix = { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 }, { 10, 13, 14, 17, 24 },
				{ 18, 21, 23, 26, 30 } };
		// int[][] matrix = { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6,
		// 9, 16, 22 }, { 10, 13, 14, 17, 24 },
		// { 18, 21, 23, 26, 30 } };
		// //int[][] matrix = { { 5 }, { 6 } };
		System.out.println(ms.searchMatrix(matrix, 20));
	}

	private boolean searchRec(int left, int up, int right, int down) {
		if (left > right || up > down) {
			return false;
		}

		int mid = (left + right) / 2;

		if (matrix[up][mid] > target) {
			return searchRec(left, up, mid - 1, down);
		} else if (target > matrix[up][mid]) {
			int row = up;
			while (row <= down && matrix[row][mid] <= target) {
				if (matrix[row][mid] == target) {
					return true;
				}
				row++;
			}
			return (searchRec(left, row, mid - 1, down) || searchRec(mid + 1, up, right, row - 1));
		} else {
			return true;
		}
	}

	public boolean searchMatrix(int[][] mat, int targ) {
		matrix = mat;
		target = targ;
		if (matrix == null || matrix.length == 0) {
			return false;
		}
		return searchRec(0, 0, matrix[0].length - 1, matrix.length - 1);
	}
}
