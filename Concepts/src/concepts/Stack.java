package concepts;

public class Stack<M extends Comparable<M>> {
	public LinkedListNode<M> top;

	public Stack() {
		top = null;
	}

	public boolean push(M data) {
		LinkedListNode<M> newNode = new LinkedListNode<M>(data, top);
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
		LinkedListNode<M> node = top;
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
