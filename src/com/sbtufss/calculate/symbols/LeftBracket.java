package com.sbtufss.calculate.symbols;

import com.sbtufss.calculate.enums.SymbolPriority;

public class LeftBracket extends Symbol {

	@Override
	public String flag() {
		return "(";
	}

	@Override
	public SymbolPriority priority() {
		return SymbolPriority.USELESS;
	}

	@Override
	public int numOfSymbol() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double cal(double[] values) {
		// TODO Auto-generated method stub
		return 0;
	}

}
