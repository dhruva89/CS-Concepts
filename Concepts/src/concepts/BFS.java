package concepts;

import java.util.HashSet;

public class BFS<T> {
	public static interface VisitInterface<M> {
		public void visit(GraphNode<M> node);
	}

	HashSet<GraphNode<T>> visitMap = new HashSet<GraphNode<T>>();
	VisitInterface<T> visitInt;

	public void search(GraphNode<T> root) {
		Queue<GraphNode<T>> queue = new Queue<GraphNode<T>>();
		if (root != null) {
			queue.enqueue(root);
		}
		while (!queue.isEmpty()) {
			GraphNode<T> node = queue.dequeue();
			if(visitInt!=null) {
				visitInt.visit(node);
			} else {
				visit(node);
			}
			visitMap.add(node);
			if (node.children != null) {
				for (GraphNode<T> child : node.children) {
					if (!visitMap.contains(child)) {
						queue.enqueue(child);
					}
				}
			}
		}
	}

	private void visit(GraphNode<T> node) {
		System.out.println("Visitingnode " + node);
	}

	public BFS(VisitInterface<T> visitInt) {
		super();
		this.visitInt = visitInt;
	}
}
