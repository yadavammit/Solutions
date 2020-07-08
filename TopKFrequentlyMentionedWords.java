import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TopKFrequentlyMentionedWords {

	public static void main(String[] args) {
		int k = 2;
		String[] keywords = { "anacell", "betacellular", "cetracular", "deltacellular", "eurocell" };
		String[] reviews = {"I love anacell Best services; Best services provided by anacell",
				"betacellular has great services", "deltacellular provides much better services than betacellular",
				"cetracular is worse than anacell", "Betacellular is better than deltacellular."};
		TopKFrequentlyMentionedWords fmk = new TopKFrequentlyMentionedWords();
		fmk.topKFrequencyWords(k, keywords, reviews);
	}

	public String[] topKFrequencyWords(int k, String[] keywords, String[] reviews) {
		HashSet<String> hs = new HashSet<String>();
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		for (String keyword : keywords) {
			hs.add(keyword);
		}
		for (String review : reviews) {
			String[] reviewWords = review.split("\\W+");
			Set<String> hst = new HashSet<String>();
			for (String reviewword : reviewWords) {
				if (hs.contains(reviewword.toLowerCase()) && !hst.contains(reviewword.toLowerCase())) {
					hm.put(reviewword.toLowerCase(), hm.getOrDefault(reviewword.toLowerCase(), 0) + 1);
				}
				hst.add(reviewword.toLowerCase());
			}
		}

		List<String> kcl = new ArrayList<String>(hm.keySet());
		Collections.sort(kcl, (keyword1, keyword2) -> {
			return hm.get(keyword2).compareTo(hm.get(keyword1)) == 0 ? keyword1.compareTo(keyword2)
					: hm.get(keyword2).compareTo(hm.get(keyword1));
		});

		for (String l : kcl) {
			System.out.println(l);
		}

		return null;
	}

}
