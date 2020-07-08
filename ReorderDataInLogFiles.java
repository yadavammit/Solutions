import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class ReorderDataInLogFiles {
	public static void main(String[] args) {

		String[] logs = {"1 n u", "r 527", "j 893", "6 14", "6 82"};
		LinkedList<String> digitLogs = new LinkedList<String>();
		ArrayList<String> letterLogs = new ArrayList<String>();
		for (String s : logs) {
			if (s.split(" ")[1].matches("[0-9]+")) {
				digitLogs.add(s);
			} else {
				letterLogs.add(s);
			}
		}
		Collections.sort(letterLogs, (string1, string2) -> {
			String[] st1 = string1.split(" ");
			String[] st2 = string2.split(" ");
			for (int i = 1; i < Math.min(st1.length, st2.length); i++) {
				if (!st1[i].equals(st2[i])) {
					return st1[i].compareTo(st2[i]);
				}
			}
			if (st1.length > st2.length) {
				return 1;
			}
			if (st1.length < st2.length) {
				return -1;
			}
			return st1[0].compareTo(st2[0]);
		});

		for (String digitA : digitLogs) {
			letterLogs.add(digitA);
		}
		System.out.println(letterLogs);
	}
}
