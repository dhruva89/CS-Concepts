package concepts;

import java.util.HashSet;

public class DFS<T> {
	HashSet<GraphNode<T>> visitMap = new HashSet<GraphNode<T>>();

	public void search(GraphNode<T> root) {
		if (root == null) {
			return;
		}
		visit(root);
		visitMap.add(root);
		if (root.children != null) {
			for (GraphNode<T> child : root.children) {
				if (!visitMap.contains(child)) {
					search(child);
				}
			}
		}
	}

	private void visit(GraphNode<T> node) {
		System.out.println("Visiting node " + node);
	}
}
