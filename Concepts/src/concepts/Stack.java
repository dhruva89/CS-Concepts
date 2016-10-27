package concepts;

public class Stack<M extends Comparable<M>> {
	public Node<M> top;

	public Stack() {
		top = null;
	}

	public boolean push(M data) {
		Node<M> newNode = new Node<M>(data, top);
		top = newNode;
		return true;
	}

	public M peek() {
		if (top == null) {
			return null;
		}
		return top.data;
	}

	public M pop() {
		Node<M> node = top;
		top = top.next;
		return node.data;
	}

	public boolean isEmpty() {
		if (top == null) {
			return true;
		} else {
			return false;
		}
	}
}
