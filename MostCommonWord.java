import java.util.HashMap;
import java.util.HashSet;

public class MostCommonWord {
	public static void main(String[] args) {
		MostCommonWord mcw = new MostCommonWord();
		System.out.println(mcw.mostCommonWord("Bob. hIt, baLl", new String[] { "bob", "hit" }));
	}

	public String mostCommonWord(String paragraph, String[] banned) {
		HashSet<Character> pun = new HashSet<Character>();
		pun.add('!');
		pun.add('?');
		pun.add('\'');
		pun.add(';');
		pun.add('.');
		pun.add(',');

		HashSet<String> ban = new HashSet<String>();
		for (String s : banned) {
			ban.add(s);
		}
		HashMap<String, Integer> wor = new HashMap<String, Integer>();
		StringBuilder sb = new StringBuilder();
		int max = 0;
		int cnt;
		// for(char c : paragraph){
		for (int i = 0; i < paragraph.length(); i++) {
			char c = paragraph.charAt(i);
			if (c != ' ' && !pun.contains(c)) {
				sb.append(c);
			} else {
				if (ban.contains(sb.toString().toLowerCase())) {
					sb = new StringBuilder();
					continue;
				}
				cnt = wor.getOrDefault(sb.toString().toLowerCase(), 0) + 1;
				if (cnt > max) {
					max = cnt;
				}
				if (sb.length() > 0) {
					wor.put(sb.toString().toLowerCase(), cnt);
					sb = new StringBuilder();
				}
			}
		}

		if (sb.length() > 0) {
			if (ban.contains(sb.toString().toLowerCase())) {
				sb = new StringBuilder();
			}
			cnt = wor.getOrDefault(sb.toString().toLowerCase(), 0) + 1;
			if (cnt > max) {
				max = cnt;
			}
			if (sb.length() > 0) {
				wor.put(sb.toString().toLowerCase(), cnt);
			}
		}

		for (String s : wor.keySet()) {
			if (wor.get(s) == max) {
				return s;
			}
		}
		return "";
	}
}
