package concepts;

public class TreeNode<T extends Comparable<T>> implements Comparable<TreeNode<T>> {
	public T data;
	public TreeNode<T> left;
	public TreeNode<T> right;
	public TreeNode<T> parent;

	public TreeNode(T data) {
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
	public int compareTo(TreeNode<T> o) {
		return data.compareTo(o.data);
	}
}
