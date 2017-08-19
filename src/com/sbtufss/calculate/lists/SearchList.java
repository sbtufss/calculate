package com.sbtufss.calculate.lists;

public class SearchList<E> {

	private Node<E> first;
	private Node<E> last;

	public SearchList() {
		super();
	}

	/**
	 * 添加元素
	 * 
	 * @param e
	 */
	public void add(E e) {
		if (first == null) {
			first = new Node<E>(e, null);
		} else {
			if (last == null) {
				last = new Node<E>(e, null);
				first.next = last;// 因为first和last还没建立关系，所以在这里要将他们的关系建立起来
			} else {
				Node<E> n = new Node<>(e, null);// 一个临时的引用n
				last.next = n;// 将last的next赋值为n的引用
				last = n;// 然后再将last重新赋值为n的引用
			}
		}
	}

	public Node<E> getFirst() {
		return first;
	}

}