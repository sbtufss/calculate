package com.sbtufss.calculate.lists;

public class Node<E> {
	E item;
	Node<E> next;

	Node(E element, Node<E> next) {
		this.item = element;
		this.next = next;
	}

	public Node<E> getNext() {
		return next;
	}

	public E getItem() {
		return item;
	}
	
}
