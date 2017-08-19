package com.sbtufss.calculate.symbols;

import com.sbtufss.calculate.enums.SymbolPriority;

public class MathPowSymbol extends Symbol {

	@Override
	public String flag() {
		return "Math.pow";
	}

	@Override
	public SymbolPriority priority() {
		// TODO Auto-generated method stub
		return SymbolPriority.CUSTOM;
	}

	@Override
	public int numOfSymbol() {
		return 2;
	}

	@Override
	public double cal(double[] values) {
		double v1 = values[0];
		double v2 = values[1];
		return Math.pow(v1, v2);
	}

}
