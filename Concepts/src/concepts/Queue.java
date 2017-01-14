package concepts;

public class Queue<T> {
	LinkedListNode<T> head;
	LinkedListNode<T> tail;

	public Queue() {
		head = null;
		tail = null;
	}

	public boolean enqueue(T data) {
		LinkedListNode<T> newNode = new LinkedListNode<T>(data, null);
		if (head != null) {
			tail.next = newNode;
			tail = newNode;
		} else {
			head = newNode;
			tail = newNode;
		}
		return true;
	}

	public T dequeue() {
		T data = head.data;
		head = head.next;
		return data;
	}

	public T peek() {
		return head.data;
	}

	public boolean isEmpty() {
		if (head == null) {
			return true;
		} else {
			return false;
		}
	}
}
