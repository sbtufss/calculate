package com.sbtufss.calculate.symbols;

import com.sbtufss.calculate.enums.SymbolPriority;

/**
 * 加号操作符
 * 
 * @author sbtufss
 * 
 */
public class PlusSymbol extends Symbol {
	@Override
	public String flag() {
		return "+";
	}

	@Override
	public SymbolPriority priority() {
		return SymbolPriority.PLUS;
	}

	@Override
	public int numOfSymbol() {
		return 2;
	}

	@Override
	public double cal(double[] values) {
		// TODO Auto-generated method stub
		return values[0] + values[1];
	}

}
