package com.hari.concurrency.binarytree;

public class BinaryTreeTest {

	public static void main(String[] args) {
//		Node root = new Node();
//		insert(root, 1);
	}

	class Node {
		int n;
		Node left, right;
		int height = 0;

		public Node() {
		}

		public Node(int n) {
			this.n = n;
		}
	}

	private static Node insert(Node root, int n) {
		if (root == null) {
//			return new Node(n);
		}

		if (n < root.n) {
			root.left = insert(root.left, n);
			maxDepth(root);
		} else if (n > root.n) {
			root.right = insert(root.right, n);
			maxDepth(root);
		} else {
			return root;
		}
		return root;
	}

	private static int maxDepth(Node node) {
		if (node == null) {
			return 0;
		} else {
			int lDepth = maxDepth(node.left);
			int rDepth = maxDepth(node.right);

			if (lDepth > rDepth) {
				node.height = lDepth + 1;
				return lDepth + lDepth + 1;
			} else {
				return rDepth + rDepth + 1;
			}
		}

	}

}
