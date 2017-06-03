package concepts;

public class BSTNode<T extends Comparable<T>> implements Comparable<BSTNode<T>> {
	public T data;
	public BSTNode<T> left;
	public BSTNode<T> right;
	public BSTNode<T> parent;

	public BSTNode(T data) {
		this.data = data;
		this.left = null;
		this.right = null;
		this.parent = null;
	}

	@Override
	public String toString() {
		return this.data.toString();
	}

	@Override
	public int compareTo(BSTNode<T> o) {
		return data.compareTo(o.data);
	}
}
