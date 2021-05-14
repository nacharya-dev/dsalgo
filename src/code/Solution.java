package code;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World");
		bfs();
	}
	
	private static void bfs() {
		Graph graph = new Graph(8);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(1, 5);
		graph.addEdge(2, 1);
		graph.addEdge(2, 4);
		graph.addEdge(2, 6);
		graph.addEdge(4, 7);
		graph.addEdge(5, 1);
		graph.addEdge(5, 3);
		graph.addEdge(5, 6);
		graph.addEdge(5, 7);
		graph.addEdge(6, 4);
		graph.addEdge(6, 5);
		
		BFS bfs = new BFS(graph);
		bfs.traverse(0);
		bfs.print();
		bfs.printPath(1);
		bfs.printPath(2);
		bfs.printPath(3);
		bfs.printPath(4);
		bfs.printPath(5);
		bfs.printPath(6);
		bfs.printPath(7);
		
		// Find all the vertices on any shortest path between a given pair of vertices (a,b)
		System.out.println("Find all the vertices on any shortest path between a given pair of vertices (0,5)");
		bfs.findAllVerticesOnShortestPathOf(0, 5);
	}

	private static void dfs() {
		Graph graph = new Graph(18);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(0, 14);
		graph.addEdge(1, 0);
		graph.addEdge(1, 4);
		graph.addEdge(2, 1);
		graph.addEdge(2, 4);
		graph.addEdge(2, 6);
		graph.addEdge(4, 7);
		graph.addEdge(5, 1);
		graph.addEdge(5, 3);
		graph.addEdge(5, 6);
		graph.addEdge(5, 7);
		graph.addEdge(6, 4);
		graph.addEdge(6, 5);
		
		DFS dfs = new DFS(graph);
		dfs.traverse();
	}
}
