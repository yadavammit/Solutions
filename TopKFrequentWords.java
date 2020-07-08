import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;


class TopKFrequentWords {
	public List<String> topKFrequent(String[] words, int k) {
		HashMap<String, Integer> wc = new HashMap<String, Integer>();
		for (String word : words) {
			wc.put(word, wc.getOrDefault(word, 0) + 1);
		}
		List<String> resultList = new ArrayList<String>();
		PriorityQueue<String> pq = new PriorityQueue<String>((a, b) -> {
			int com = wc.get(a).compareTo(wc.get(b));
			return com != 0 ? com : b.compareTo(a);
		});

		for (String word : wc.keySet()) {
			pq.offer(word);
			if (pq.size() > k) {
				pq.poll();
			}
		}
		
		while(!pq.isEmpty()){
			resultList.add(pq.poll());
		}
		Collections.reverse(resultList);
		return resultList;
	}
}