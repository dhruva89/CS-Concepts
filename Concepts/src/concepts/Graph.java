package concepts;

import java.util.LinkedList;

public class Graph<T> {
	public LinkedList<GraphNode<T>> nodes;

	public Graph(LinkedList<GraphNode<T>> nodes) {
		super();
		this.nodes = nodes;
	}
}
