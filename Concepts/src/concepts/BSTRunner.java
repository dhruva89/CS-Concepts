package concepts;

public class BSTRunner {
	public static void main(String args[]) {
		BST<Integer> bst = new BST<Integer>();
		bst.add(10);
		bst.add(5);
		bst.add(15);
		BSTNode<Integer> node = bst.add(2);
		bst.add(8);
		bst.add(12);
		bst.add(18);
		
		/*
		bst.inOrderTraversalIterative();
		bst.preOrderTraversalIterative();
		bst.postOrderTraversalIterative();*/
		
		//System.out.println(bst.predecessor(node));
		//bst.inOrderTraversalIterative();
		bst.morrisTraversal();
	}
}
