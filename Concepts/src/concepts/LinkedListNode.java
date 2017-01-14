package concepts;

public class LinkedListNode<N> {
	public N data;
	public LinkedListNode<N> next;

	public LinkedListNode() {
		data = null;
		next = null;
	}

	public LinkedListNode(N data, LinkedListNode<N> next) {
		this.data = data;
		this.next = next;
	}
}
