import java.util.Arrays;
import java.util.HashMap;

public class KClosestPointToOrigin {
	
	public static void main(String[] args) {
		int i = 100000000;
		System.out.println(i);
		KClosestPointToOrigin kc = new KClosestPointToOrigin();
		int[][] test = { { 1, 3 }, { -2, 2 } };
		System.out.println(kc.kClosest(test, 1));
	}

	public int[][] kClosest(int[][] points, int k) {
		int[] distance = new int[points.length];
		HashMap<Integer, Integer[]> hm = new HashMap<Integer, Integer[]>();
		for (int i = 0; i < points.length; i++) {
			distance[i] = points[i][0] * points[i][0] + points[i][1] * points[i][1];
			hm.put(distance[i], new Integer[] { points[i][0], points[i][1] });
		}

		Arrays.sort(distance);
		int[][] result = new int[k][2];
		for (int i = 0; i < k; i++) {
			result[i][0] = hm.get(distance[i])[0];
			result[i][1] = hm.get(distance[i])[1];
		}
		return result;
	}

}
