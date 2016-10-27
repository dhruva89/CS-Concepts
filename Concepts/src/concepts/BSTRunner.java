package concepts;

public class BSTRunner {
	public static void main(String args[]) {
		BST<Integer> bst = new BST<Integer>();
		bst.add(2);
		bst.add(1);
		bst.add(4);
		TreeNode<Integer> node = bst.add(9);
		bst.add(7);
		bst.add(8);
		bst.add(0);
		bst.add(5);
		
		/*
		bst.inOrderTraversalIterative();
		bst.preOrderTraversalIterative();
		bst.postOrderTraversalIterative();*/
		
		System.out.println(bst.predecessor(node));
		//bst.inOrderTraversalIterative();
	}
}
