package com.sbtufss.calculate.symbols;

import com.sbtufss.calculate.enums.SymbolPriority;

/**
 * 减号操作符
 * 
 * @author sbtufss
 * 
 */
public class ReduceSymbol extends Symbol {
	@Override
	public String flag() {
		return "-";
	}

	@Override
	public SymbolPriority priority() {
		return SymbolPriority.RDUCE;
	}

	@Override
	public int numOfSymbol() {
		return 2;
	}

	@Override
	public double cal(double[] values) {
		// TODO Auto-generated method stub
		return values[0] - values[1];
	}


}
