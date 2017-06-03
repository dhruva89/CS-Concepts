package concepts;

import java.util.ArrayList;

public class BST<T extends Comparable<T>> {

	public BST(BSTNode<T> node) {
		root = node;
	}

	public BST() {
	}

	public BSTNode<T> root = null;

	public BSTNode<T> add(T data) {
		BSTNode<T> curNode = root;
		BSTNode<T> prevNode = null;
		if (root == null) {
			return root = new BSTNode<T>(data);
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
			prevNode.left = new BSTNode<T>(data);
			prevNode.left.parent = prevNode;
			return prevNode.left;

		} else {
			prevNode.right = new BSTNode<T>(data);
			prevNode.right.parent = prevNode;
			return prevNode.right;
		}

	}

	public boolean remove(T data) {
		BSTNode<T> curNode = root;
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
			BSTNode<T> successor = successor(curNode);
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

	public BSTNode<T> successor(BSTNode<T> curNode) {
		if (curNode.right != null) {
			curNode = curNode.right;
			while (curNode.left != null) {
				curNode = curNode.left;
			}
			return curNode;
		} else {
			while (curNode.parent != null && curNode != curNode.parent.left) {
				curNode = curNode.parent;
			}
			return curNode.parent;
		}
	}

	public BSTNode<T> predecessor(BSTNode<T> curNode) {
		if (curNode.left != null) {
			curNode = curNode.left;
			while (curNode.right != null) {
				curNode = curNode.right;
			}
			return curNode;
		}

		while (curNode.parent != null && curNode.parent.right != curNode) {
			curNode = curNode.parent;
		}
		return curNode.parent;
	}

	private void replace(BSTNode<T> curNode, BSTNode<T> node) {
		curNode.data = node.data;
		curNode.left = node.left;
		curNode.right = node.right;
	}

	public void inOrderTraversal() {
		BSTNode<T> curNode = root;
		recurseInOrder(curNode);
	}

	public static <M extends Comparable<M>> void inOrderTraversal(BSTNode<M> root) {
		(new BST<M>(root)).inOrderTraversal();
	}

	private void recurseInOrder(BSTNode<T> node) {
		if (node != null) {
			recurseInOrder(node.left);
			System.out.println(node.data + " ");
			recurseInOrder(node.right);
		}
	}

	public void preOrderTraversal() {
		BSTNode<T> curNode = root;
		recursePreOrder(curNode);
	}

	private void recursePreOrder(BSTNode<T> node) {
		if (node != null) {
			System.out.println(node.data + " ");
			recursePreOrder(node.left);
			recursePreOrder(node.right);
		}
	}

	public void preOrderTraversalForArray(ArrayList<T> arrList) {
		BSTNode<T> curNode = root;
		recursePreOrder(curNode, arrList);
	}

	private void recursePreOrder(BSTNode<T> node, ArrayList<T> arrList) {
		if (node != null) {
			arrList.add(node.data);
			recursePreOrder(node.left, arrList);
			recursePreOrder(node.right, arrList);
		}
	}

	public void postOrderTraversal() {
		BSTNode<T> curNode = root;
		recursePostOrder(curNode);
	}

	private void recursePostOrder(BSTNode<T> node) {
		if (node != null) {
			recursePostOrder(node.left);
			recursePostOrder(node.right);
			System.out.println(node.data + " ");
		}
	}

	public void inOrderTraversalIterative() {
		Stack<BSTNode<T>> stack = new Stack<BSTNode<T>>();
		BSTNode<T> curNode = root;
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
		Queue<BSTNode<T>> queue = new Queue<BSTNode<T>>();
		BSTNode<T> curNode = root;

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
		Stack<BSTNode<T>> stack = new Stack<BSTNode<T>>();
		BSTNode<T> curNode = root;

		while (curNode != null) {
			stack.push(curNode);
			curNode = curNode.left;
		}

		BSTNode<T> prevNode2 = null;
		while (!stack.isEmpty()) {
			curNode = stack.peek();
			BSTNode<T> prevNode = curNode;
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

	public void morrisTraversal() {
		BSTNode<T> cur = root;
		while (cur != null) {
			if (cur.left == null) {
				System.out.println(cur);
				cur = cur.right;
			} else {
				BSTNode<T> temp = cur.left;
				while (temp.right != null && temp.right != cur) {
					temp = temp.right;
				}
				if (temp.right == null) {
					temp.right = cur;
					cur = cur.left;
				} else {
					temp.right = null;
					System.out.println(cur);
					cur = cur.right;
				}
			}
		}

	}
}
