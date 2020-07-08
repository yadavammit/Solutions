import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Anagrams {

	public static void main(String[] args) {
		Anagrams an = new Anagrams();
		String[] anagrams = { "eat", "tea", "tan", "ate", "nat", "bat" };
		an.groupAnagrams(anagrams);
	}

	public List<List<String>> groupAnagrams(String[] strs) {
		HashMap<String, LinkedList<String>> ls = new HashMap<String, LinkedList<String>>();
		for (String s : strs) {
			char[] arr = s.toCharArray();
			Arrays.sort(arr);
			String tempStr = new String(arr);
			LinkedList<String> l = ls.getOrDefault(tempStr, new LinkedList<String>());
			l.add(s);
			ls.put(tempStr, l);
		}

		List<List<String>> output = new LinkedList<List<String>>();
		for (String keyStr : ls.keySet()) {
			output.add(ls.get(keyStr));
		}
		return output;
	}

}
