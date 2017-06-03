package concepts;

public class GraphNode<T> {
	public T data;
	public java.util.LinkedList<GraphNode<T>> children = new java.util.LinkedList<GraphNode<T>>();
	
	@Override
	public String toString() {
		return data.toString();
	}

	public GraphNode(T data) {
		super();
		this.data = data;
	}
}
