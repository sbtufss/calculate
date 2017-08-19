package com.sbtufss.calculate.symbols;

import com.sbtufss.calculate.enums.SymbolPriority;

/**
 * 除法
 * 
 * @author sbtufss
 * 
 */
public class DivideSymbol extends Symbol {

	@Override
	public String flag() {
		return "/";
	}

	@Override
	public SymbolPriority priority() {
		return SymbolPriority.DIVIDE;
	}

	@Override
	public int numOfSymbol() {
		return 2;
	}

	@Override
	public double cal(double[] values) {
		// TODO Auto-generated method stub
		return values[0] / values[1];
	}


}
