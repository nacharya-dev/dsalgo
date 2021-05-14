package code;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph {
	private int vertices;
	private List<LinkedList<Integer>> adjacencyList;
	
	public int getVertices() {
		return vertices;
	}

	public List<LinkedList<Integer>> getAdjacencyList() {
		return adjacencyList;
	}
	
	public Graph(int v) {
		vertices = v;
		adjacencyList = new ArrayList<>(v);
		for (int i=0; i<vertices; i++) {
			adjacencyList.add(i, null);
		}
	}

	public boolean addEdge(int x, int y) {
		if(x >= vertices || y >= vertices) {
			return false;
		}
		if(adjacencyList.get(x) == null) {
			adjacencyList.set(x, new LinkedList<>());
		}
		adjacencyList.get(x).add(y);
		return true;
	}
}
