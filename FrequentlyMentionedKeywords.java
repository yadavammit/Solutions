import java.util.HashMap;
import java.util.LinkedList;

public class FrequentlyMentionedKeywords {

	public static void main(String[] args) {
		int k = 2;
		String[] keywords = { "anacell", "cetracular", "betacellular" };
		String[] reviews = { "Anacell provides the best services in the city", "betacellular has awesome services",
				"Best services provided by anacell, everyone should use anacell" };

		HashMap<String, Integer> mapKeyWords = new HashMap<String, Integer>();
		int[] noOfTimes = new int[keywords.length];

		for (int i = 0; i < keywords.length; i++) {
			mapKeyWords.put(keywords[i].toLowerCase(), i);
		}

		Integer index = 0;
		for (int i = 0; i < reviews.length; i++) {
			boolean[] exists = new boolean[keywords.length];
			String[] subStrings = reviews[i].split(" ");
			for (int j = 0; j < subStrings.length; j++) {
				index = mapKeyWords.get(subStrings[j].toLowerCase());
				if (null != index && !exists[index]) {
					noOfTimes[index] += 1;
				}
			}
		}
		
		for(int i=0 ;i< noOfTimes.length ; i++){
			System.out.println(noOfTimes[i] + " ");
		}
		
	}

}
