package code;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class DFS {
	private int[] parent;
	private int[] start;
	private int[] finish;
	private boolean[] visited;
	private Queue<Integer> queue;
	
	private Graph graph;
	
	public DFS(Graph g) {
		graph = g;
		int v = g.getVertices();
		parent = new int[v];
		start = new int[v];
		finish = new int[v];
		visited = new boolean[v];
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
	
	public void traverse(int source) {
		this.source = source;
		reset();
		dfs(source);
	}
	
	public void print() {
		System.out.println("Printing Breadth first tree..");
		for (int i=0; i<vertices; i++) {
			System.out.println(String.format("shortest path distance of %d from %d : %d, parent of %d : %d", i, source, distance[i], i, parent[i]));
		}
	}
	
	public void printPath(int vertex) {
		System.out.print(String.format("Printing path from %d to %d .. ",source,vertex));
		Stack<Integer> stack = new Stack<>();
		int i = vertex;
		while (i != -1) {
			stack.push(i);
			i = parent[i];
		}
		
		String s = "";
		while(!stack.isEmpty()) {
			System.out.print(s);
			System.out.print(stack.pop());
			s = "->";
		}
		System.out.println();
	}
	
	private void reset() {
		for (int i=0; i<vertices; i++) {
			parent[i] = -1;
			distance[i] = -1;
			visited[i] = false;
		}
		queue = new LinkedList<Integer>();
	}
	
	private void dfs(int s) {
		System.out.println(s);
		// set attributes for s 
		visited[s] = true;
		distance[s] = 0;
		parent[s] = -1;
		// insert into queue for traversal
		queue.add(s);
		while (!queue.isEmpty()) {
			int node = queue.peek();
			// visit all neighbors of node
			if (adjacencyList.get(node) != null) {
				for (int i : adjacencyList.get(node)) {
					if(!visited[i]) {
						System.out.println(i);
						visited[i] = true;
						distance[i] = distance[node] + 1;
						parent[i] = node;
						queue.add(i);
					}
				}
			}
			queue.remove();
		}
	}
}
