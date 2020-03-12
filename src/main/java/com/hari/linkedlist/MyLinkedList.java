/**
 * 
 */
package com.hari.linkedlist;

/**
 * @author bc887d
 *
 */
public class MyLinkedList {

	Node head = null;

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public static MyLinkedList insert(MyLinkedList list, int data) {
		Node newNode = new Node(data);
		newNode.next = null;

		if (list.head == null) {
			list.head = newNode;
		} else {
			Node last = list.head;
			while (last.next != null) {
				last = last.next;
			} // while
			last.next = newNode;
		} // last
		return list;
	}

	public static void main(String[] args) {
		/* Start with the empty list. */
		MyLinkedList list = new MyLinkedList();

		//
		// ******INSERTION******
		//
		list = insert(list, 1);
		list = insert(list, 2);
		list = insert(list, 3);
		list = insert(list, 4);
		list = insert(list, 5);
		list = insert(list, 6);
		list = insert(list, 7);
		list = insert(list, 8);

		// Print the LinkedList
		printList(list);
	}

	public static void printList(MyLinkedList list) {
		Node currentNode = list.head;
		System.out.print("My LinkedList : ");
		while (currentNode != null) {
			System.out.print(currentNode.data + " ");
			currentNode = currentNode.next;
		}
	}

}
