import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class Graph {
	LinkedList<Integer>[] adj;

	Graph(int nuOfNodes, List<List<Integer>> connections) {
		adj = new LinkedList[nuOfNodes];
		for (int i = 0; i < nuOfNodes; i++) {
			adj[i] = new LinkedList<Integer>();
		}
		for (List<Integer> edL : connections) {
			adj[edL.get(0)].add(edL.get(1));
			adj[edL.get(1)].add(edL.get(0));
		}
	}
}

public class CriticalConnections {
	int disTm;
	int children;
	List<List<Integer>> result;

	public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
		result = new LinkedList<List<Integer>>();
		Graph gr = new Graph(n, connections);
		Set<Integer> visitedVertex = new HashSet<Integer>();
		Set<Integer> articulationPoint = new HashSet<Integer>();
		HashMap<Integer, Integer> disTime = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> lowTime = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> parent = new HashMap<Integer, Integer>();
		Integer startVertex = 0;
		parent.put(startVertex, null);
		dfs(visitedVertex, articulationPoint, disTime, lowTime, parent, gr, startVertex);
		if (children > 1) {
			articulationPoint.add(startVertex);
		}

		return result;
	}

	private void dfs(Set<Integer> visitedVertex, Set<Integer> articulationPoint, HashMap<Integer, Integer> disTime,
			HashMap<Integer, Integer> lowTime, HashMap<Integer, Integer> parent, Graph gr, Integer startVertex) {
		visitedVertex.add(startVertex);
		disTime.put(startVertex, disTm);
		lowTime.put(startVertex, disTm);
		disTm++;

		for (Integer adj : gr.adj[startVertex]) {
			if (adj == parent.get(startVertex)) {
				continue;
			}
			if (visitedVertex.contains(adj)) {
				if (parent.get(startVertex) != null) {
					lowTime.put(startVertex, Math.min(lowTime.get(startVertex), lowTime.get(adj)));
				}
			} else {
				if (parent.get(startVertex) == null) {
					children++;
				}
				parent.put(adj, startVertex);
				dfs(visitedVertex, articulationPoint, disTime, lowTime, parent, gr, adj);
				if (null != parent.get(startVertex)) {
					lowTime.put(startVertex, Math.min(lowTime.get(startVertex), lowTime.get(adj)));
				}
			}
		}

		if (null != parent.get(startVertex) && disTime.get(parent.get(startVertex)) < lowTime.get(startVertex)) {
			articulationPoint.add(parent.get(startVertex));
			LinkedList<Integer> ls = new LinkedList<Integer>();
			ls.add(parent.get(startVertex));
			ls.add(startVertex);
			result.add(ls);
		}

	}

}
