import java.util.ArrayList;
import java.util.List;

class Node {
	boolean wordEndCh;
	Node[] next = new Node[26];
}

public class SearchSuggestionSystem {

	public static void main(String[] args) {
		SearchSuggestionSystem sss = new SearchSuggestionSystem();
		String[] products = { "mobile", "mouse", "moneypot", "monitor", "mousepad" };
		String searchWord = "mouse";
		System.out.println(sss.suggestedProducts(products, searchWord));
	}

	private List<List<String>> suggestedProducts(String[] products, String searchWord) {
		List<List<String>> suggestedProducts = new ArrayList<List<String>>();
		Node root = new Node();
		for (String product : products) {
			root = addToTri(root, product, 0);
		}
		StringBuilder subSt = new StringBuilder();
		for (int i = 0; i < searchWord.length(); i++) {
			subSt.append(searchWord.charAt(i));
			suggestedProducts.add(searchTri(root, subSt.toString()));
		}
		return suggestedProducts;
	}

	private List<String> searchTri(Node node, String search) {
		ArrayList<Character> searchCh = new ArrayList<Character>();
		List<String> matchingProducts = new ArrayList<String>();
		for (char c : search.toCharArray()) {
			searchCh.add(c);
			int index = c - 'a';
			if (node.next[index] == null) {
				return matchingProducts;
			}
			if (node.next[index] != null) {
				node = node.next[index];
			}
		}
		if (node.wordEndCh) {
			String t = "";
			for (char c : searchCh) {
				t += String.valueOf(c);
			}
			if (matchingProducts.size() < 3) {
				matchingProducts.add(t);
			}
		}
		dfs(node, matchingProducts, searchCh);
		return matchingProducts;
	}

	private void dfs(Node node, List<String> matchingProducts, ArrayList<Character> searchCh) {
		for (int i = 0; i < 26; i++) {
			if (null != node.next[i]) {
				searchCh.add((char) (i + 97));
				if (node.next[i].wordEndCh) {
					String t = "";
					for (char c : searchCh) {
						t += String.valueOf(c);
					}
					if (matchingProducts.size() < 3) {
						matchingProducts.add(t);
					}

				}
				dfs(node.next[i], matchingProducts, searchCh);
				searchCh.remove(searchCh.size() - 1);
			}
		}
	}

	private Node addToTri(Node node, String product, int currentValue) {
		if (node == null) {
			node = new Node();
		}
		if (product.length() == currentValue) {
			node.wordEndCh = true;
			return node;
		}
		int c = charToIndex(product.charAt(currentValue));
		node.next[c] = addToTri(node.next[c], product, currentValue + 1);
		return node;
	}

	private int charToIndex(char c) {
		return c - 'a';
	}
}
