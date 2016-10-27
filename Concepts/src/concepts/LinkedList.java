package concepts;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<M> implements Iterable<M> {

	public static class LinkedListIterator<O> implements Iterator<O> {
		private Node<O> curNode;

		public LinkedListIterator(LinkedList<O> linkedList) {
			curNode = linkedList.head;
		}

		@Override
		public boolean hasNext() {
			if (curNode != null) {
				return true;
			} else {
				return false;
			}
		}

		@Override
		public O next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			} else {
				Node<O> temp = curNode;
				curNode = curNode.next;
				return temp.data;
			}

		}

	}

	public Node<M> head;
	public Node<M> tail;

	public LinkedList() {
		super();
	}

	public LinkedList(M... inputs) {
		Node<M> newNode = null;
		Node<M> prev = null;

		this.head = newNode;
		for (M data : inputs) {
			newNode = new Node<M>();
			newNode.data = data;
			if (prev != null) {
				prev.next = newNode;
			} else {
				this.head = newNode;
			}
			prev = newNode;
		}
		this.tail = prev;
	}

	public boolean add(M newData) {
		Node<M> newNode = new Node<M>();
		newNode.data = newData;
		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
		return true;
	}

	@Override
	public Iterator<M> iterator() {
		return new LinkedListIterator<M>(this);
	}
}