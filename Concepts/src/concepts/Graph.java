package concepts;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

public class Graph<T> {
	public LinkedList<GraphNode<T>> nodes;

	public Graph(LinkedList<GraphNode<T>> nodes) {
		super();
		this.nodes = nodes;
	}

	public Graph(GraphNode<T>... nodes) {
		super();
		this.nodes = new LinkedList<GraphNode<T>>(Arrays.asList(nodes));
	}

	public boolean isCyclic() {
		HashSet<GraphNode<T>> visited = new HashSet<GraphNode<T>>();
		HashSet<GraphNode<T>> recStack= new HashSet<GraphNode<T>>();
		for (GraphNode<T> node : nodes) {
			if (isCyclic(node, visited, recStack)) {
				return true;
			}
		}
		return false;
	}

	private boolean isCyclic(GraphNode<T> node, HashSet<GraphNode<T>> visited, HashSet<GraphNode<T>> recStack) {
		if (recStack.contains(node)) {
			return true;
		}
		recStack.add(node);
		if (!visited.contains(node)) {
			visited.add(node);
			for (GraphNode<T> child : node.children) {
				if (isCyclic(child, visited, recStack)) {
					return true;
				}
			}
		}
		recStack.remove(node);
		return false;
	}
}
