package concepts;

import java.util.Arrays;
import java.util.LinkedList;

public class DFSAndBFSRunner {

	public static void main(String args[]) {
		DFS<Integer> dfs = new DFS<Integer>();
		BFS<Integer> bfs = new BFS<Integer>(null);
		GraphNode<Integer> node1 = new GraphNode<Integer>(1);
		GraphNode<Integer> node2 = new GraphNode<Integer>(2);
		GraphNode<Integer> node3 = new GraphNode<Integer>(3);
		GraphNode<Integer> node4 = new GraphNode<Integer>(4);
		GraphNode<Integer> node5 = new GraphNode<Integer>(5);
		GraphNode<Integer> node6 = new GraphNode<Integer>(6);
		node1.children = new LinkedList<GraphNode<Integer>>(Arrays.asList(node2, node3));
		node5.children = new LinkedList<GraphNode<Integer>>(Arrays.asList(node6));
		node6.children = new LinkedList<GraphNode<Integer>>(Arrays.asList(node1,node4,node5));
		System.out.println("DFS:");
		dfs.search(node6);
		System.out.println("BFS:");
		bfs.search(node6);
	}
}
