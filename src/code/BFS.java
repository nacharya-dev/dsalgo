package code;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BFS {
	private Graph graph;
	private int[] parent;
	private int[] distance;
	private boolean[] visited;
	private Queue<Integer> queue;
	
	private int source;
	
	public BFS(Graph g) {
		graph = g;
		int v = g.getVertices();
		parent = new int[v];
		distance = new int[v];
		visited = new boolean[v];
	}
	
	public void traverse(int source) {
		this.source = source;
		reset();
		bfs(source);
	}
	
	public void print() {
		System.out.println("Printing Breadth first tree..");
		for (int i=0; i<graph.getVertices(); i++) {
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
	
	public void findAllVerticesOnShortestPathOf(int a, int b) {
		traverse(a);
		int[] sourceDistance = new int[graph.getVertices()];
		for(int i=0; i<graph.getVertices(); i++) {
			sourceDistance[i] = distance[i];
		}
		
		traverse(b);
		int[] destDistance = new int[graph.getVertices()];
		for(int i=0; i<graph.getVertices(); i++) {
			destDistance[i] = distance[i];
		}
		
		int atob = sourceDistance[b];
		String s = "";
		for(int i=0; i<graph.getVertices(); i++) {
			if(i == b || i == a) {
				continue;
			}
			if(atob == sourceDistance[i] + destDistance[i]) {
				System.out.print(s);
				System.out.print(i);
				s = ",";
			}
		}
	}
	
	private void reset() {
		for (int i=0; i<graph.getVertices(); i++) {
			parent[i] = -1;
			distance[i] = -1;
			visited[i] = false;
		}
		queue = new LinkedList<Integer>();
	}
	
	private void bfs(int s) {
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
			if (graph.getAdjacencyList().get(node) != null) {
				for (int i : graph.getAdjacencyList().get(node)) {
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
