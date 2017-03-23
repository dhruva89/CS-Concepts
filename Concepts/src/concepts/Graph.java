package concepts;

import java.util.Arrays;
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
}
