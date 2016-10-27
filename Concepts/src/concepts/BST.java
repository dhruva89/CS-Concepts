package concepts;

public class BST<T extends Comparable<T>> {
	public TreeNode<T> root = null;

	public TreeNode<T> add(T data) {
		TreeNode<T> curNode = root;
		TreeNode<T> prevNode = null;
		if (root == null) {
			return root = new TreeNode<T>(data);
		}
		while (curNode != null) {
			prevNode = curNode;
			if (data.compareTo(curNode.data) <= 0) {
				curNode = curNode.left;
			} else {
				curNode = curNode.right;
			}
		}

		if (data.compareTo(prevNode.data) <= 0) {
			prevNode.left = new TreeNode<T>(data);
			prevNode.left.parent = prevNode;
			return prevNode.left;

		} else {
			prevNode.right = new TreeNode<T>(data);
			prevNode.right.parent = prevNode;
			return prevNode.right;
		}

	}

	public boolean remove(T data) {
		TreeNode<T> curNode = root;
		while (curNode != null && curNode.data != data) {
			if (data.compareTo(curNode.data) > 0) {
				curNode = curNode.right;
			} else {
				curNode = curNode.left;
			}
		}
		if (curNode == null) {
			return false;
		}
		if (curNode.left == null && curNode.right != null) {
			replace(curNode, curNode.right);
			return true;
		} else if (curNode.left != null && curNode.right == null) {
			replace(curNode, curNode.left);
			return true;
		} else if (curNode.left != null && curNode.right != null) {
			TreeNode<T> successor = successor(curNode);
			curNode.data = successor.data;
			successor.parent.right = successor.right;
			return true;

		} else {
			if (curNode == curNode.parent.left) {
				curNode.parent.left = null;
			} else {
				curNode.parent.right = null;
			}
			return true;
		}
	}

	public TreeNode<T> successor(TreeNode<T> curNode) {
		if (curNode.right != null) {
			curNode = curNode.right;
			while (curNode.left != null) {
				curNode = curNode.left;
			}
			return curNode;
		} else {
			while (curNode.parent!= null && curNode != curNode.parent.left) {
				curNode = curNode.parent;
			}
			return curNode.parent;
		}
	}

	public TreeNode<T> predecessor(TreeNode<T> curNode) {
		if (curNode.left != null) {
			curNode = curNode.left;
			while (curNode.right != null) {
				curNode = curNode.right;
			}
			return curNode;
		}

		while (curNode.parent!= null && curNode.parent.right != curNode) {
			curNode = curNode.parent;
		}
		return curNode.parent;
	}

	private void replace(TreeNode<T> curNode, TreeNode<T> node) {
		curNode.data = node.data;
		curNode.left = node.left;
		curNode.right = node.right;
	}

	public void inOrderTraversal() {
		TreeNode<T> curNode = root;
		recurseInOrder(curNode);
	}

	private void recurseInOrder(TreeNode<T> node) {
		if (node != null) {
			recurseInOrder(node.left);
			System.out.println(node.data + " ");
			recurseInOrder(node.right);
		}
	}

	public void preOrderTraversal() {
		TreeNode<T> curNode = root;
		recurseInOrder(curNode);
	}

	private void recursePreOrder(TreeNode<T> node) {
		if (node != null) {
			System.out.println(node.data + " ");
			recurseInOrder(node.left);
			recurseInOrder(node.right);
		}
	}

	public void postOrderTraversal() {
		TreeNode<T> curNode = root;
		recurseInOrder(curNode);
	}

	private void recursePostOrder(TreeNode<T> node) {
		if (node != null) {
			recurseInOrder(node.left);
			recurseInOrder(node.right);
			System.out.println(node.data + " ");
		}
	}

	public void inOrderTraversalIterative() {
		Stack<TreeNode<T>> stack = new Stack<TreeNode<T>>();
		TreeNode<T> curNode = root;
		while (curNode != null) {
			stack.push(curNode);
			curNode = curNode.left;
		}
		while (!stack.isEmpty()) {
			curNode = stack.pop();
			System.out.println(curNode.data);
			if (curNode.right != null) {
				curNode = curNode.right;
				stack.push(curNode);

				while (curNode.left != null) {
					stack.push(curNode.left);
					curNode = curNode.left;
				}
			}
		}
	}

	public void preOrderTraversalIterative() {
		Queue<TreeNode<T>> queue = new Queue<TreeNode<T>>();
		TreeNode<T> curNode = root;

		while (curNode != null) {
			queue.enqueue(curNode);
			curNode = curNode.left;
		}
		while (!queue.isEmpty()) {
			curNode = queue.dequeue();
			System.out.println(curNode.data);
			if (curNode.right != null) {
				curNode = curNode.right;
				queue.enqueue(curNode);
				while (curNode.left != null) {
					curNode = curNode.left;
					queue.enqueue(curNode);
				}
			}
		}
	}

	public void postOrderTraversalIterative() {
		Stack<TreeNode<T>> stack = new Stack<TreeNode<T>>();
		TreeNode<T> curNode = root;

		while (curNode != null) {
			stack.push(curNode);
			curNode = curNode.left;
		}

		TreeNode<T> prevNode2 = null;
		while (!stack.isEmpty()) {
			curNode = stack.peek();
			TreeNode<T> prevNode = curNode;
			if (curNode.right != null && prevNode2 != curNode.right) {
				curNode = curNode.right;
				stack.push(curNode);
				while (curNode.left != null) {
					curNode = curNode.left;
					stack.push(curNode);
				}
			}
			if (prevNode == curNode) {
				System.out.println((prevNode2 = stack.pop()).data);

			}
		}

	}
}
