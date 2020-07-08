import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PartitionLabels {

	public static void main(String[] args) {
		String s = "ababcbacadefegdehijhklij";
		List<Integer> paritionLabels = new ArrayList<Integer>();
		HashMap<Character, Integer> maxPos = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			maxPos.put(s.charAt(i), i);
		}
		int partitionPos = 0;
		int cnt = 0;
		for (int i = 0; i < s.length(); i++) {
			cnt++;
			partitionPos = maxPos.get(s.charAt(i)) > partitionPos ? maxPos.get(s.charAt(i)) : partitionPos;
			if (i == partitionPos) {
				paritionLabels.add(cnt);
				cnt = 0;
			}
		}
		System.out.println(paritionLabels);
	}
}
