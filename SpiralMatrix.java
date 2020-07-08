
public class SpiralMatrix {
	int[][] matrix;
	int number =1;

	public static void main(String[] args) {
		SpiralMatrix sm = new SpiralMatrix();
		int matrixSize = 3;
		sm.matrix = new int[matrixSize][matrixSize];
		sm.createMatrix(0, matrixSize -1, 0, matrixSize-1, 0);
		System.out.println(sm.matrix);

	}

	private void createMatrix(int left, int right, int top, int bottom, int dir) {
		if(left > right || top > bottom){
			return;
		}
		int temp;
		if (dir == 0) {
			temp = left;
			while (temp <= right) {
				matrix[top][temp] = number++;
				temp++;
			}
			createMatrix(left, right, top + 1, bottom, 1);
		}
		if (dir == 1) {
			temp = top;
			while (temp <= bottom) {
				matrix[temp][right] = number++;
				temp++;
			}
			createMatrix(left, right - 1, top, bottom, 2);
		}
		if (dir == 2) {
			temp = right;
			while (left <= temp) {
				matrix[bottom][temp] = number++;
				temp--;
			}
			createMatrix(left, right, top, bottom - 1, 3);
		}
		if (dir == 3) {
			temp = bottom;
			while (top <= temp) {
				matrix[temp][left] = number++;
				temp--;
			}
			createMatrix(left + 1, right, top, bottom, 0);
		}

	}

}
