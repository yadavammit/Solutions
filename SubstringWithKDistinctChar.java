import java.util.HashMap;

public class SubstringWithKDistinctChar {
	public static void main(String[] args) {

		int[] integerArr = { 1, 2, 1, 2, 3 };
		int k = 2;
		System.out.println(atMostKDistChar(integerArr, k) - atMostKDistChar(integerArr, k - 1));

	}

	private static int atMostKDistChar(int[] integerArr, int k) {
		int count = 0;
		int window1 = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int window2 = 0; window2 < integerArr.length; window2++) {
			map.put(integerArr[window2], map.getOrDefault(integerArr[window2], 0) + 1);
			if (map.size() <= k) {
				count += window2 - window1 + 1;
			} else {
				while (map.size() != k) {
					if (map.get(integerArr[window1]) == 1) {
						map.remove(integerArr[window1]);
					} else {
						map.put(integerArr[window1], map.get(integerArr[window1]) - 1);
					}
					window1 = window1 +1 ;
				}
				count += window2 - window1 +1 ;
			}

		}
		return count;
	}

}
