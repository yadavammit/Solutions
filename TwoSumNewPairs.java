import java.util.HashSet;
import java.util.Set;

public class TwoSumNewPairs {
	public static void main(String[] args) {
		int[] numbers = { 1, 1, 2, 45, 46, 46 };
		int target = 47;
		Set<Integer> se = new HashSet<Integer>();
		Set<Integer> seen = new HashSet<Integer>();
		int totalNoOfPairs = 0;
		for (int number : numbers) {
			if(se.contains(target -number) && !seen.contains(target-number)){
				totalNoOfPairs++;
				se.add(number);
				seen.add(target-number);
			}else{
				se.add(number);
			}
		}
		
		System.out.println(totalNoOfPairs);
	}
}
