package com.hari.linkedlist;

public class MyDoubleLinkedList {

	Node head;

	class Node {
		int index;
		Node next;
		Node previous;

		Node(int index) {
			this.index = index;
		}
	}

	public void push(int index) {
		Node newNode = new Node(index);
		newNode.next = head;
		newNode.previous = null;
		if (head != null) {
			head.previous = newNode;
		}
		head = newNode;
	}

	public void insertAfter(Node previousNode, int index) {
		if (previousNode == null) {
			return;
		}

		Node newNode = new Node(index);
		newNode.next = previousNode.next;

		previousNode.next = newNode;

		newNode.previous = previousNode;

		if (newNode.next != null) {
			newNode.next.previous = newNode;
		}
	}

	public void append(int index) {
		Node newNode = new Node(index);
		Node last = head;

		newNode.next = null;

		if (head == null) {
			newNode.previous = null;
			head = newNode;
			return;
		}

		while (last.next != null) {
			last = last.next;
		}

		last.next = newNode;

		newNode.previous = last;
	}

	public void printList(Node node) {
		Node lastNode = null;
		System.out.println("Traversal in forward Direction");

		while (lastNode != null) {
			System.out.print(node.index + " ");
			lastNode = node;
			node = node.next;
		}

		System.out.println();
		System.out.println("Traversal in reverse direction");
		while (lastNode != null) {
			System.out.print(lastNode.index + " ");
			lastNode = lastNode.previous;
		}
	}

	public static void main(String[] args) {
		/* Start with the empty list */
		MyDoubleLinkedList dll = new MyDoubleLinkedList();

		// Insert 6. So linked list becomes 6->NULL
		dll.append(6);

		// Insert 7 at the beginning. So linked list becomes 7->6->NULL
		dll.push(7);

		// Insert 1 at the beginning. So linked list becomes 1->7->6->NULL
		dll.push(1);

		// Insert 4 at the end. So linked list becomes 1->7->6->4->NULL
		dll.append(4);

		// Insert 8, after 7. So linked list becomes 1->7->8->6->4->NULL
		dll.insertAfter(dll.head.next, 8);

		System.out.println("Created DLL is: ");
		dll.printList(dll.head);

	}

}
