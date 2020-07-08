import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class TopKFrequentlyMentionedKeywords {
	public static void main(String[] args) {
		int k = 2;
		String[] keywords = { "anacell", "cetracular", "betacellular" };
		String[] reviews = { "Anacell provides the best services in the city", "betacellular has awesome services",
				"Best services provided by anacell, everyone should use anacell" };
		
		HashMap<String,Integer> kc = new HashMap<String,Integer>();
		HashSet<String> ks = new HashSet<String>();
		for(String keyword : keywords){
			kc.put(keyword.toLowerCase(), 0);
		}
		
		for(String cre : reviews){
			for(String rew : cre.split(" ")){
				String rewTmp = rew.toLowerCase();
				if(!ks.contains(rewTmp) && null != kc.get(rewTmp)){
					kc.put(rewTmp, kc.get(rewTmp) + 1);
				}
				ks.add(rewTmp);
			}
		}
		
		List<String> kcl = new ArrayList<String>(kc.keySet());
		List<String> ls = new LinkedList<String>(kc.keySet());
		Collections.sort(kcl,(a,b) -> {
				return kc.get(b).compareTo(kc.get(a)) != 0 ? kc.get(b).compareTo(kc.get(a))  : a.compareTo(b) ; 
		});
		
		System.out.println(kcl);
	}
	
}
