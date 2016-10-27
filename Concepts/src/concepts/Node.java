package concepts;

public class Node<N> {
	public N data;
	public Node<N> next;

	public Node() {
		data = null;
		next = null;
	}

	public Node(N data, Node<N> next) {
		this.data = data;
		this.next = next;
	}
}
