package com.sbtufss.calculate.managers;

import com.sbtufss.calculate.lists.Node;
import com.sbtufss.calculate.lists.SearchList;
import com.sbtufss.calculate.symbols.Symbol;

public class SymbolManager {

	protected SearchList<Symbol> list;

	public SymbolManager() {
		super();
		list = new SearchList<>();
	}

	public void add(Symbol symbol) {
		list.add(symbol);
	}

	public Symbol get(String strSymbol) {
		Node<Symbol> first = list.getFirst();
		for (Node<Symbol> node = first; node!= null; node = node
				.getNext()) {
			if(node.getItem().flag().equals(strSymbol)){
				return node.getItem();
			}
		}
		throw new RuntimeException("没有找到指定的操作符：" + strSymbol);
	}
}
