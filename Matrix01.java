class Matrix01 {
	public static void main(String[] args) {
		Matrix01 ma = new Matrix01();
		int[][] matrix = { { 1, 0, 1, 1, 0, 0, 1, 0, 0, 1 }, { 0, 1, 1, 0, 1, 0, 1, 0, 1, 1 },
				{ 0, 0, 1, 0, 1, 0, 0, 1, 0, 0 }, { 1, 0, 1, 0, 1, 1, 1, 1, 1, 1 }, { 0, 1, 0, 1, 1, 0, 0, 0, 0, 1 },
				{ 0, 0, 1, 0, 1, 1, 1, 0, 1, 0 }, { 0, 1, 0, 1, 0, 1, 0, 0, 1, 1 }, { 1, 0, 0, 0, 1, 1, 1, 1, 0, 1 },
				{ 1, 1, 1, 1, 1, 1, 1, 0, 1, 0 }, { 1, 1, 1, 1, 0, 1, 0, 0, 1, 1 } };
		System.out.println(ma.updateMatrix(matrix));
	}

	public int[][] updateMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 1) {
					matrix[i][j] = Integer.MAX_VALUE;
				}
			}
		}
		for (int i = 1; i < matrix.length; i++) {
			if (matrix[i][0] != 0) {
				matrix[i][0] = matrix[i - 1][0] != Integer.MAX_VALUE ? matrix[i - 1][0] + 1 : Integer.MAX_VALUE;
			}
		}

		for (int i = 1; i < matrix[0].length; i++) {
			if (matrix[0][i] != 0) {
				matrix[0][i] = matrix[0][i - 1] != Integer.MAX_VALUE ? matrix[0][i - 1] + 1 : Integer.MAX_VALUE;
			}
		}

		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[i][j] != 0) {
					matrix[i][j] = Math.min(matrix[i - 1][j], matrix[i][j - 1]) != Integer.MAX_VALUE
							? Math.min(matrix[i - 1][j], matrix[i][j - 1]) + 1 : Integer.MAX_VALUE;
				}
			}
		}

		int r = matrix.length - 1;
		int c = matrix[0].length - 1;
		for (int i = r - 1; i >= 0; i--) {
			matrix[i][c] = Math.min(matrix[i + 1][c] + 1, matrix[i][c]) != Integer.MAX_VALUE
					? Math.min(matrix[i + 1][c] + 1, matrix[i][c]) : Integer.MAX_VALUE;
		}

		for (int i = c - 1; i >= 0; i--) {
			matrix[r][i] = Math.min(matrix[r][i + 1] + 1, matrix[r][i]) != Integer.MAX_VALUE
					? Math.min(matrix[r][i + 1] + 1, matrix[r][i]) : Integer.MAX_VALUE;
		}

		for (int i = r - 1; i >= 0; i--) {
			for (int j = c - 1; j >= 0; j--) {
				matrix[i][j] = Math.min(matrix[i][j], Math.min(matrix[i + 1][j], matrix[i][j + 1]) + 1);
			}
		}

		return matrix;
	}

}